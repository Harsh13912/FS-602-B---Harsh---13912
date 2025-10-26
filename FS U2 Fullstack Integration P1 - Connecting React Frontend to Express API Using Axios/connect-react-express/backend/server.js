import express from "express";
import cors from "cors";

const app = express();
app.use(cors());

const products = [
  { id: 1, name: "Laptop", price: 85000 },
  { id: 2, name: "Smartphone", price: 40000 },
  { id: 3, name: "Headphones", price: 2500 },
  { id: 4, name: "Smartwatch", price: 12000 }
];

app.get("/api/products", (req, res) => {
  res.json(products);
});

const PORT = 5000;
app.listen(PORT, () => console.log(`✅ Backend running on http://localhost:${PORT}`));
