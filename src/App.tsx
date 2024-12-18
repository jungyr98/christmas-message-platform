import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Send from "./app/send";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Send />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
