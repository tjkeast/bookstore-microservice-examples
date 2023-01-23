import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookSearchPageComponent } from './views/book-search/book-search-page/book-search-page.component';

const routes: Routes = [
	{ path: '', redirectTo: 'books', pathMatch: 'full' },
	{ path: 'books', component: BookSearchPageComponent }
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {}
