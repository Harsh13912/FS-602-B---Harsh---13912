const express = require("express");
const cors = require("cors");
const app = express();
const PORT = process.env.PORT || 5000;

app.use(cors());

app.get("/api/hello", (req, res) => {
  res.json({ message: "Hello from the backend running on AWS EC2!" });
});

app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
