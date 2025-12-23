import { Link } from "react-router-dom";

export default function ProductCard({ product }) {
  return (
    <div className="card">
      <img src={product.image} />
      <h3>{product.title}</h3>
      <p>₹{product.price}</p>
      <p>⭐ {product.rating}</p>
      <Link to={`/product/${product.id}`}>View</Link>
    </div>
  );
}
