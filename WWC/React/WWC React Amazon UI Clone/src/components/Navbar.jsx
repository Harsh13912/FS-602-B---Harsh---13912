import { Link } from "react-router-dom";
import { useCart } from "../context/CartContext";
import { useUser } from "../context/UserContext";

export default function Navbar() {
  const { state } = useCart();
  const { user, logout } = useUser();

  return (
    <nav className="nav">
      <Link to="/">Nimbus</Link>
      <Link to="/cart">Cart ({state.cart.length})</Link>
      {user ? (
        <>
          <span>Hello, {user}</span>
          <button onClick={logout}>Logout</button>
        </>
      ) : (
        <Link to="/login">Login</Link>
      )}
    </nav>
  );
}
