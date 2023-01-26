import { Injectable } from '@angular/core';
import { ConfigurationService, SecurityConfiguration } from 'generated';
import { tap } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class SystemConfigService {
	securityConfig: SecurityConfiguration;

	constructor(private configService: ConfigurationService) {}

	initialise() {
		return this.configService.getSecurityConfiguration().pipe(tap(resp => (this.securityConfig = resp)));
	}
}
