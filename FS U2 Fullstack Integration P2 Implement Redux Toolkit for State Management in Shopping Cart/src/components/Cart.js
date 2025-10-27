import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { removeItem, updateQuantity } from "../store/cartSlice";

const Cart = () => {
  const cart = useSelector((state) => state.cart);
  const dispatch = useDispatch();

  return (
    <div>
      {cart.items.map((item) => (
        <div key={item.id} style={{ marginBottom: "10px" }}>
          {item.name} (${item.price}){" "}
          <input
            type="number"
            value={item.quantity}
            min="1"
            onChange={(e) =>
              dispatch(updateQuantity({ id: item.id, quantity: Number(e.target.value) }))
            }
            style={{ width: "40px", marginLeft: "10px" }}
          />
          <button onClick={() => dispatch(removeItem(item.id))}>Remove</button>
        </div>
      ))}
    </div>
  );
};

export default Cart;
