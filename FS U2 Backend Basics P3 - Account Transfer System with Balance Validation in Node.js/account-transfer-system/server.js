import express from "express";
import bodyParser from "body-parser";
import { connectDB } from "./config/db.js";
import transferRoutes from "./routes/transferRoutes.js";
import { Account } from "./models/Account.js";

const app = express();
app.use(bodyParser.json());

connectDB();

app.post("/createAccount", async (req, res) => {
  const { username, balance } = req.body;

  try {
    const existing = await Account.findOne({ username });
    if (existing) return res.status(400).json({ message: "Account already exists" });

    const newAccount = new Account({ username, balance });
    await newAccount.save();

    res.status(201).json({ message: "Account created successfully", account: newAccount });
  } catch (err) {
    res.status(500).json({ message: "Error creating account", error: err.message });
  }
});

app.use("/", transferRoutes);

const PORT = 3000;
app.listen(PORT, () => console.log(`🚀 Server running on http://localhost:${PORT}`));
