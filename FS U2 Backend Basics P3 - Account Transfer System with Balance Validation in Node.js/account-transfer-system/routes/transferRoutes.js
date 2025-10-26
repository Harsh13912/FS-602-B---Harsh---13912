import express from "express";
import { Account } from "../models/Account.js";

const router = express.Router();

router.post("/transfer", async (req, res) => {
  const { fromUser, toUser, amount } = req.body;

  if (!fromUser || !toUser || !amount || amount <= 0) {
    return res.status(400).json({ message: "Invalid input data" });
  }

  try {
    const sender = await Account.findOne({ username: fromUser });
    const receiver = await Account.findOne({ username: toUser });

    if (!sender || !receiver) {
      return res.status(404).json({ message: "Sender or receiver not found" });
    }

    if (sender.balance < amount) {
      return res.status(400).json({ message: "Insufficient balance" });
    }

    sender.balance -= amount;
    receiver.balance += amount;

    await sender.save();
    await receiver.save();

    res.status(200).json({
      message: `Transferred $${amount} from ${fromUser} to ${toUser}`,
      senderBalance: sender.balance,
      receiverBalance: receiver.balance
    });
  } catch (err) {
    res.status(500).json({ message: "Server error", error: err.message });
  }
});

export default router;
