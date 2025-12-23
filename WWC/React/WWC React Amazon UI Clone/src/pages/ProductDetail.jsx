import { useParams } from "react-router-dom";
import { products } from "../data/products";
import { useCart } from "../context/CartContext";

export default function ProductDetail() {
  const { id } = useParams();
  const { dispatch } = useCart();

  const product = products.find(p => p.id === Number(id));

  return (
    <div>
      <img src={product.image} />
      <h2>{product.title}</h2>
      <p>{product.description}</p>
      <button onClick={() => dispatch({ type: "ADD", payload: product })}>
        Add to Cart
      </button>
    </div>
  );
}
