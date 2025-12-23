import { useState } from "react";
import { useUser } from "../context/UserContext";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [name, setName] = useState("");
  const { login } = useUser();
  const navigate = useNavigate();

  return (
    <div>
      <input onChange={e => setName(e.target.value)} placeholder="Username" />
      <button onClick={() => { login(name); navigate("/"); }}>
        Login
      </button>
    </div>
  );
}
