import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import BookSearchPage from "./pages/bookSearch/BookSearchPage";
import DashboardPage from "./pages/dashboard/DashboardPage";

function App() {
  return (
    <React.StrictMode>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<DashboardPage></DashboardPage>} />
          <Route path="/books" element={<BookSearchPage></BookSearchPage>} />
        </Routes>
      </BrowserRouter>
    </React.StrictMode>
  );
}

export default App;
