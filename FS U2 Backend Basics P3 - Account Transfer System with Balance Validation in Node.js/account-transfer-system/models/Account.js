import mongoose from "mongoose";

const accountSchema = new mongoose.Schema({
  username: { type: String, required: true, unique: true },
  balance: { type: Number, required: true, min: 0 }
});

export const Account = mongoose.model("Account", accountSchema);
