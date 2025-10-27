import React from "react";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";

function App() {
  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      <h1>My Shop</h1>
      <h2>Products</h2>
      <ProductList />
      <h2>Shopping Cart</h2>
      <Cart />
    </div>
  );
}

export default App;
