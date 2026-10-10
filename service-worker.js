/**
 * Service Worker — Handles offline caching and asset management.
 *
 * Responsibilities:
 * - Cache essential app assets on install
 * - Serve cached assets when offline
 * - Handle cache updates on new versions
 * - Provide fallback for offline requests
 */

const CACHE_NAME = "college-nav-v1";
const STATIC_ASSETS = [
  "/",
  "/index.html",
  "/manifest.webmanifest",
  "/styles/style.css",
  "/src/config.js",
  "/src/gps.js",
  "/src/geofence.js",
  "/src/compass.js",
  "/src/navigation.js",
  "/src/map.js",
  "/src/offline.js",
  "/src/ui.js",
  "/src/app.js",
  "/assets/campus-map.svg",
  "/assets/icons/icon.svg"
];

/**
 * Install event — Cache all static assets.
 */
self.addEventListener("install", (event) => {
  console.log("[ServiceWorker] Installing...");

  event.waitUntil(
    caches.open(CACHE_NAME)
      .then((cache) => {
        console.log("[ServiceWorker] Caching static assets...");
        return cache.addAll(STATIC_ASSETS);
      })
      .then(() => {
        console.log("[ServiceWorker] All assets cached successfully.");
        return self.skipWaiting();
      })
      .catch((error) => {
        console.error("[ServiceWorker] Cache failed:", error);
      })
  );
});

/**
 * Activate event — Clean up old caches.
 */
self.addEventListener("activate", (event) => {
  console.log("[ServiceWorker] Activating...");

  event.waitUntil(
    caches.keys()
      .then((cacheNames) => {
        return Promise.all(
          cacheNames
            .filter((name) => name !== CACHE_NAME)
            .map((name) => caches.delete(name))
        );
      })
      .then(() => {
        console.log("[ServiceWorker] Old caches cleaned up.");
        return self.clients.claim();
      })
  );
});

/**
 * Fetch event — Serve from cache, fall back to network.
 * Strategy: Cache-first for static assets, network-first for others.
 */
self.addEventListener("fetch", (event) => {
  const { request } = event;

  // Only handle GET requests
  if (request.method !== "GET") return;

  const url = new URL(request.url);

  // Skip non-http requests
  if (!url.protocol.startsWith("http")) return;

  // Skip Google Maps and external navigation requests
  if (url.hostname.includes("google.com") || url.hostname.includes("googleapis.com")) {
    return;
  }

  event.respondWith(
    caches.match(request)
      .then((cachedResponse) => {
        if (cachedResponse) {
          // Return cached response
          console.log("[ServiceWorker] Serving from cache:", request.url);
          return cachedResponse;
        }

        // Not in cache — fetch from network
        return fetch(request)
          .then((networkResponse) => {
            // Cache successful responses for future offline use
            if (networkResponse.ok && networkResponse.status === 200) {
              const responseToCache = networkResponse.clone();
              caches.open(CACHE_NAME)
                .then((cache) => {
                  cache.put(request, responseToCache);
                });
            }
            return networkResponse;
          })
          .catch(() => {
            // Network failed and not in cache
            console.log("[ServiceWorker] Offline and not cached:", request.url);

            // Return offline fallback for navigation requests
            if (request.mode === "navigate") {
              return caches.match("/index.html");
            }

            // Return a generic offline response
            return new Response("Offline", {
              status: 503,
              statusText: "Service Unavailable"
            });
          });
      })
  );
});

/**
 * Message event — Handle messages from the main app.
 */
self.addEventListener("message", (event) => {
  if (event.data && event.data.type === "SKIP_WAITING") {
    self.skipWaiting();
  }

  if (event.data && event.data.type === "CACHE_URL") {
    caches.open(CACHE_NAME)
      .then((cache) => {
        cache.add(event.data.url);
      });
  }
});
