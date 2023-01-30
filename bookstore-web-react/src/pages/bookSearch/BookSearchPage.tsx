import { useEffect, useState } from "react";
import openapiDefaultConfig from "../../config/openapi-default-config";
import { BookApi } from "../../generated";

export default function BookSearchPage() {
  const [books, setBooks] = useState<any[]>([]);

  useEffect(() => {
    const api = new BookApi(openapiDefaultConfig);
    api.getBooks().then((resp) => setBooks(resp.results));
  }, []);

  return (
    <div>
      BookSearchPage
      <div>
        {books.map((book, i) => (
          <div key={i}>{book.title}</div>
        ))}
      </div>
    </div>
  );
}
