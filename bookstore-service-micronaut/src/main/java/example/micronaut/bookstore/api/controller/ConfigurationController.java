package example.micronaut.bookstore.api.controller;

import example.micronaut.bookstore.core.security.SecurityConfiguration;
import example.micronaut.bookstore.core.security.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.utils.SecurityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Tag(name = "Configuration")
@Controller("/configuration")
public class ConfigurationController {

    @Inject
    private SecurityService securityService;

    @Inject
    private SecurityConfiguration securityConfiguration;

    @Secured({SecurityRule.IS_ANONYMOUS})
    @Get("/security")
    public SecurityConfiguration getSecurityConfiguration() {
        return securityConfiguration;
    }

    @Get("/user")
    public User getCurrentUser() {
        Authentication authentication = securityService.getAuthentication().orElseThrow(() -> new IllegalStateException("Authentication is not available while calling secured endpoint"));
        return User.of(authentication);
    }
}
