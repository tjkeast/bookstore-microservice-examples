import axios from "axios";
import { useEffect, useState } from "react";

export default function BookSearchPage() {
  const [books, setBooks] = useState<any[]>([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/books")
      .then((res) => setBooks(res.data.results));
  }, []);

  return (
    <div>
      BookSearchPage
      <div>
        {books.map((book) => (
          <span>{book.title}</span>
        ))}
      </div>
    </div>
  );
}
