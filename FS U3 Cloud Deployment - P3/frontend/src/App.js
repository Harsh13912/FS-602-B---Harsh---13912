import React, { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("Loading...");

  useEffect(() => {
    fetch("http://YOUR_BACKEND_PUBLIC_DNS_OR_LOAD_BALANCER/api/hello")
      .then((res) => res.json())
      .then((data) => setMessage(data.message))
      .catch(() => setMessage("Backend not reachable"));
  }, []);

  return (
    <div style={{ textAlign: "center", marginTop: "100px" }}>
      <h1>🚀 Full Stack App on AWS</h1>
      <p>Backend says: <strong>{message}</strong></p>
    </div>
  );
}

export default App;
