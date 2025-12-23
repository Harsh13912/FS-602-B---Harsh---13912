import { createContext, useReducer, useContext } from "react";

const CartContext = createContext();

const initialState = {
  cart: JSON.parse(localStorage.getItem("cart")) || []
};

function reducer(state, action) {
  switch (action.type) {
    case "ADD":
      return { cart: [...state.cart, action.payload] };
    case "REMOVE":
      return { cart: state.cart.filter(i => i.id !== action.payload) };
    default:
      return state;
  }
}

export const CartProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  localStorage.setItem("cart", JSON.stringify(state.cart));

  return (
    <CartContext.Provider value={{ state, dispatch }}>
      {children}
    </CartContext.Provider>
  );
};

export const useCart = () => useContext(CartContext);
