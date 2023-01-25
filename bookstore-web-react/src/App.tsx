import { BrowserRouter, Route, Routes } from "react-router-dom";
import BookSearchPage from "./pages/bookSearch/BookSearchPage";
import DashboardPage from "./pages/dashboard/DashboardPage";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<DashboardPage></DashboardPage>} />
        <Route path="/books" element={<BookSearchPage></BookSearchPage>} />
      </Routes>
    </BrowserRouter>
  );
}
