import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OAuthModule } from 'angular-oauth2-oidc';
import { ApiModule, Configuration } from 'generated';
import { mergeMap } from 'rxjs';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthService } from './shared/auth/auth.service';
import { SystemConfigService } from './shared/service/system-config.service';
import { SharedModule } from './shared/shared.module';
import { BookSearchPageComponent } from './views/book-search/book-search-page/book-search-page.component';

@NgModule({
	declarations: [AppComponent, BookSearchPageComponent],
	imports: [
		BrowserModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		HttpClientModule,
		ApiModule.forRoot(() => new Configuration({ basePath: '/api' })),
		SharedModule,
		OAuthModule.forRoot({
			resourceServer: {
				customUrlValidation: (url: string): boolean => !!url && url.indexOf('/api') >= 0,
				sendAccessToken: true
			}
		})
	],
	providers: [
		{
			provide: APP_INITIALIZER,
			useFactory: initialiseApp,
			deps: [SystemConfigService, AuthService],
			multi: true
		}
	],
	bootstrap: [AppComponent]
})
export class AppModule {}

function initialiseApp(systemConfig: SystemConfigService, authService: AuthService) {
	return () => systemConfig.initialise().pipe(mergeMap(() => authService.initialise()));
}
