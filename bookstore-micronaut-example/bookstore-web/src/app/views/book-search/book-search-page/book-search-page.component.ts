import { Component, OnInit } from '@angular/core';
import { Book, BookService } from 'generated';

@Component({
	selector: 'app-book-search-page',
	templateUrl: './book-search-page.component.html',
	styleUrls: ['./book-search-page.component.scss']
})
export class BookSearchPageComponent implements OnInit {
	books: Book[] = [];

	constructor(private bookService: BookService) {}

	ngOnInit(): void {
		this.bookService.getBooks().subscribe(response => (this.books = response.results));
	}
}
