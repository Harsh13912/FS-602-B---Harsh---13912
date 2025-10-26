const express = require('express');
const logger = require('./middleware/logger');
const auth = require('./middleware/auth');

const app = express();
const PORT = 3000;

// Apply logger middleware globally
app.use(logger);

// Public route
app.get('/public', (req, res) => {
  res.status(200).json({ message: 'This is a public route. No authentication required.' });
});

// Protected route
app.get('/protected', auth, (req, res) => {
  res.status(200).json({ message: 'You have accessed a protected route with a valid Bearer token!' });
});

// Start server
app.listen(PORT, () => console.log(`Server running at http://localhost:${PORT}`));
