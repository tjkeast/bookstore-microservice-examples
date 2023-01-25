import { Injectable } from '@angular/core';
import { OAuthErrorEvent, OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from './auth-config';

@Injectable({
	providedIn: 'root'
})
export class AuthService {
	constructor(private oauthService: OAuthService) {}

	initialise() {
		this.oauthService.configure(authCodeFlowConfig);
		this.oauthService.setupAutomaticSilentRefresh();

		this.oauthService.events.subscribe(event => {
			if (event instanceof OAuthErrorEvent) {
				console.error(event);
			} else {
				console.debug(event);
			}
		});

		this.oauthService.loadDiscoveryDocumentAndLogin();
	}
}
