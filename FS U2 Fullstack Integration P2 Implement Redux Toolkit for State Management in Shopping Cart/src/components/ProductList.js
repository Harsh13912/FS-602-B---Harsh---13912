import React from "react";
import { useDispatch } from "react-redux";
import { addItem } from "../store/cartSlice";

const products = [
  { id: 1, name: "Laptop", price: 1200 },
  { id: 2, name: "Mouse", price: 25 },
  { id: 3, name: "Keyboard", price: 45 },
];

const ProductList = () => {
  const dispatch = useDispatch();

  return (
    <div style={{ display: "flex", justifyContent: "center", gap: "20px" }}>
      {products.map((product) => (
        <div
          key={product.id}
          style={{
            border: "1px solid #ccc",
            borderRadius: "8px",
            padding: "20px",
            width: "150px",
          }}
        >
          <h3>{product.name}</h3>
          <p>${product.price}</p>
          <button onClick={() => dispatch(addItem(product))}>Add to Cart</button>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
