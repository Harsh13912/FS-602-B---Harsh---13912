// server.js
const express = require("express");
const app = express();
const PORT = 3000;

// Middleware to parse JSON
app.use(express.json());

// In-memory "database" for cards
let cards = [
  { id: 1, suit: "Hearts", value: "A" },
  { id: 2, suit: "Spades", value: "K" },
  { id: 3, suit: "Diamonds", value: "Q" }
];

// Routes

// 1. Get all cards
app.get("/cards", (req, res) => {
  res.json(cards);
});

// 2. Get a single card by ID
app.get("/cards/:id", (req, res) => {
  const id = parseInt(req.params.id);
  const card = cards.find((c) => c.id === id);
  if (!card) {
    return res.status(404).json({ error: "Card not found" });
  }
  res.json(card);
});

// 3. Add a new card
app.post("/cards", (req, res) => {
  const { suit, value } = req.body;

  if (!suit || !value) {
    return res.status(400).json({ error: "Suit and value are required" });
  }

  const newCard = {
    id: cards.length ? cards[cards.length - 1].id + 1 : 1,
    suit,
    value
  };

  cards.push(newCard);
  res.status(201).json(newCard);
});

// 4. Update a card
app.put("/cards/:id", (req, res) => {
  const id = parseInt(req.params.id);
  const card = cards.find((c) => c.id === id);

  if (!card) {
    return res.status(404).json({ error: "Card not found" });
  }

  const { suit, value } = req.body;
  if (suit) card.suit = suit;
  if (value) card.value = value;

  res.json(card);
});

// 5. Delete a card
app.delete("/cards/:id", (req, res) => {
  const id = parseInt(req.params.id);
  const index = cards.findIndex((c) => c.id === id);

  if (index === -1) {
    return res.status(404).json({ error: "Card not found" });
  }

  const deletedCard = cards.splice(index, 1);
  res.json({ message: "Card deleted", deleted: deletedCard[0] });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
