import express from "express";
import { verifyToken } from "../middleware/authMiddleware.js";

const router = express.Router();
let balance = 1000;

router.get("/balance", verifyToken, (req, res) => {
  res.status(200).json({ balance });
});

router.post("/deposit", verifyToken, (req, res) => {
  const { amount } = req.body;
  balance += amount;
  res.status(200).json({
    message: `Deposited $${amount}`,
    newBalance: balance
  });
});

router.post("/withdraw", verifyToken, (req, res) => {
  const { amount } = req.body;

  if (amount > balance) {
    return res.status(400).json({ message: "Insufficient balance" });
  }

  balance -= amount;
  res.status(200).json({
    message: `Withdrew $${amount}`,
    newBalance: balance
  });
});

export default router;
