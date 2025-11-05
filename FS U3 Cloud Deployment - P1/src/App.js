import React from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>🚀 React App Running in Docker!</h1>
        <p>Served via Nginx with a multi-stage Docker build</p>
      </header>
    </div>
  );
}

export default App;
