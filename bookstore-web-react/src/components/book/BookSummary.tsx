import { Book } from "../../generated";
import "./BookSummary.css";

export default function BookSummary({ book }: { book: Book }) {
  return (
    <div>
      <h2>{book.title}</h2>
      <p>{book.author}</p>
      <p>{book.description}</p>
      {book.coverImageUrl ? (
        <img className="cover-image" src={book.coverImageUrl} />
      ) : (
        <div className="cover-image-background">
          <div className="cover-image-placeholder"></div>
        </div>
      )}
      <p>{book.releaseDate.toISOString()}</p>
    </div>
  );
}
