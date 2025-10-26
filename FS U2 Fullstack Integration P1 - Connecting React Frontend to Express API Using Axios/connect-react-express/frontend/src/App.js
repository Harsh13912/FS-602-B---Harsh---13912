import React from "react";
import ProductList from "./components/ProductList";

function App() {
  return (
    <div style={{ fontFamily: "Arial", textAlign: "center", padding: "20px" }}>
      <h1>🛍️ Product List</h1>
      <ProductList />
    </div>
  );
}

export default App;
