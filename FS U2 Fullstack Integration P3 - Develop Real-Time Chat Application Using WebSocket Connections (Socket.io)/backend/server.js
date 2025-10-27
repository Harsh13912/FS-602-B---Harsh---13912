import express from 'express';
import http from 'http';
import { Server } from 'socket.io';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const server = http.createServer(app);
const io = new Server(server, {
  cors: { origin: "*" }
});

// serve static frontend build (optional)
app.use(express.static(path.join(__dirname, '../frontend/build')));

// socket.io events
io.on('connection', (socket) => {
  console.log('A user connected:', socket.id);

  socket.on('join', (username) => {
    socket.username = username || 'Anonymous';
    socket.broadcast.emit('systemMessage', { message: `${socket.username} joined the chat.` });
  });

  socket.on('message', (data) => {
    // data: { username, message, time }
    io.emit('message', data); // broadcast to all
  });

  socket.on('disconnect', () => {
    console.log('user disconnected', socket.id);
    if (socket.username) {
      socket.broadcast.emit('systemMessage', { message: `${socket.username} left the chat.` });
    }
  });
});

const PORT = process.env.PORT || 4000;
server.listen(PORT, () => console.log(`Socket.io server running on http://localhost:${PORT}`));
