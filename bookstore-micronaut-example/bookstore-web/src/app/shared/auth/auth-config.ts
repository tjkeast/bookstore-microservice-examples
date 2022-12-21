import { AuthConfig } from 'angular-oauth2-oidc';

export const authCodeFlowConfig: AuthConfig = {
	issuer: 'http://localhost:8082/realms/local-test',
	redirectUri: window.location.origin + window.location.pathname,
	clientId: 'bookstore-example',
	responseType: 'code',
	scope: 'openid profile',
	showDebugInformation: true
};
