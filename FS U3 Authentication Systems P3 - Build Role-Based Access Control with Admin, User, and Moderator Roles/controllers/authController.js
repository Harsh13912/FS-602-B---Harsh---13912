const jwt = require('jsonwebtoken');
const SECRET = process.env.SECRET_KEY || 'mysecretkey';

// In a real app you'd verify user credentials from DB. Here we accept posted user data.
exports.login = (req, res) => {
  const { id, username, password, role } = req.body;
  if (!username || !password || !role) {
    return res.status(400).json({ message: 'id, username, password and role are required' });
  }

  // For demo: accept any credentials and issue token containing role
  const payload = { id, username, role };
  const token = jwt.sign(payload, SECRET, { expiresIn: '1h' });
  res.json({ token });
};
