const https = require('https');
const fs = require('fs');
const path = require('path');

const options = {
  key: fs.readFileSync(path.join(__dirname, 'cert.key')),
  cert: fs.readFileSync(path.join(__dirname, 'cert.crt'))
};

const mimeTypes = {
  '.html': 'text/html',
  '.css': 'text/css',
  '.js': 'application/javascript',
  '.json': 'application/json',
  '.svg': 'image/svg+xml',
  '.png': 'image/png',
  '.jpg': 'image/jpeg',
  '.ico': 'image/x-icon',
  '.webmanifest': 'application/manifest+json'
};

https.createServer(options, (req, res) => {
  let filePath = path.join(__dirname, req.url === '/' ? 'index.html' : req.url.split('?')[0]);
  const ext = path.extname(filePath).toLowerCase();
  const contentType = mimeTypes[ext] || 'application/octet-stream';

  fs.readFile(filePath, (err, data) => {
    if (err) {
      res.writeHead(404);
      res.end('Not Found');
      return;
    }
    res.writeHead(200, { 'Content-Type': contentType });
    res.end(data);
  });
}).listen(3443, '0.0.0.0', () => {
  console.log('HTTPS Server running at https://localhost:3443');
});
