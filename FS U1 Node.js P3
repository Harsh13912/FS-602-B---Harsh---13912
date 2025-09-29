// server.js
const http = require("http");
const { randomUUID } = require("crypto");

const PORT = 3000;
const NUM_SEATS = 5;
const seats = Array.from({ length: NUM_SEATS }, (_, i) => ({
  id: i + 1,
  status: "available"
}));

const server = http.createServer((req, res) => {
  if (req.url === "/seats" && req.method === "GET") {
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(seats));
  } else {
    res.writeHead(404);
    res.end("Not found");
  }
});

server.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
