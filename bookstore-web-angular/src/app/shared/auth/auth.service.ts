import { Injectable } from '@angular/core';
import { AuthConfig, OAuthErrorEvent, OAuthService } from 'angular-oauth2-oidc';
import { ConfigurationService } from 'generated';

import { from, mergeMap, of } from 'rxjs';
import { SystemConfigService } from '../service/system-config.service';

@Injectable({
	providedIn: 'root'
})
export class AuthService {
	constructor(
		private oauthService: OAuthService,
		private systemConfig: SystemConfigService,
		private configService: ConfigurationService
	) {}

	initialise() {
		if (this.systemConfig.securityConfig.enabled) {
			return this.configureOidc();
		} else {
			return of(true);
		}
	}

	private configureOidc() {
		const config: AuthConfig = {
			issuer: this.systemConfig.securityConfig.issuer,
			redirectUri: window.location.origin + window.location.pathname,
			postLogoutRedirectUri: window.location.origin + window.location.pathname,
			clientId: this.systemConfig.securityConfig.clientId,
			scope: this.systemConfig.securityConfig.scope,
			responseType: 'code',
			showDebugInformation: true,
			requireHttps: false
		};
		this.oauthService.configure(config);
		this.oauthService.setupAutomaticSilentRefresh();

		this.oauthService.events.subscribe(event => {
			if (event instanceof OAuthErrorEvent) {
				console.error(event);
			} else {
				console.debug(event);
			}
		});

		return from(this.oauthService.loadDiscoveryDocumentAndTryLogin()).pipe(
			mergeMap(() => {
				if (!this.oauthService.hasValidAccessToken()) {
					this.oauthService.initCodeFlow();
				}
				return this.initialiseUser();
			})
		);
	}

	private initialiseUser() {
		return this.configService.getCurrentUser().pipe(
			mergeMap(user => {
				console.log(user);
				return of(true);
			})
		);
	}
}
