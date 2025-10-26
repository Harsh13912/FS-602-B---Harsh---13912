import express from "express";
import bodyParser from "body-parser";
import jwt from "jsonwebtoken";
import { JWT_SECRET } from "./config/jwtConfig.js";
import bankingRoutes from "./routes/bankingRoutes.js";

const app = express();
app.use(bodyParser.json());

const user = { username: "user1", password: "password123" };

app.post("/login", (req, res) => {
  const { username, password } = req.body;

  if (username === user.username && password === user.password) {
    const token = jwt.sign({ username }, JWT_SECRET, { expiresIn: "1h" });
    return res.status(200).json({ token });
  } else {
    return res.status(401).json({ message: "Invalid credentials" });
  }
});

app.use("/", bankingRoutes);

const PORT = 3000;
app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));
