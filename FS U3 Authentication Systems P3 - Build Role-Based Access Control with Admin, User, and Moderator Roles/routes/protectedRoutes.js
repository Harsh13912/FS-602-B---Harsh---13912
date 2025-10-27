const express = require('express');
const router = express.Router();
const auth = require('../middleware/authMiddleware');
const role = require('../middleware/roleMiddleware');

router.get('/admin-dashboard', auth, role('Admin'), (req, res) => {
  res.json({ message: 'Welcome to the Admin dashboard', user: req.user });
});

router.get('/moderator-panel', auth, role(['Moderator','Admin']), (req, res) => {
  res.json({ message: 'Welcome to the Moderator panel', user: req.user });
});

router.get('/user-profile', auth, role(['User','Admin','Moderator']), (req, res) => {
  res.json({ message: `Welcome to your profile, ${req.user.username}`, user: req.user });
});

module.exports = router;
