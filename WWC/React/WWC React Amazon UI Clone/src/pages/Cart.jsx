import { useCart } from "../context/CartContext";
import { Link } from "react-router-dom";

export default function Cart() {
  const { state, dispatch } = useCart();

  const total = state.cart.reduce((a, c) => a + c.price, 0);

  return (
    <div>
      {state.cart.map(item => (
        <div key={item.id}>
          <h4>{item.title}</h4>
          <button onClick={() => dispatch({ type: "REMOVE", payload: item.id })}>
            Remove
          </button>
        </div>
      ))}
      <h3>Total: ₹{total}</h3>
      <Link to="/checkout">Checkout</Link>
    </div>
  );
}
