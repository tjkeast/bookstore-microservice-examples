package example.micronaut.bookstore.core.security;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.utils.DefaultSecurityService;
import io.micronaut.security.utils.SecurityService;
import jakarta.inject.Singleton;

import java.util.Optional;

@Replaces(DefaultSecurityService.class)
@Singleton
public class SecurityServiceFallback implements SecurityService {

    @Override
    public Optional<String> username() {
        return Optional.of(SecurityHelper.DEFAULT_USERNAME);
    }

    @Override
    public Optional<Authentication> getAuthentication() {
        return Optional.empty();
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public boolean hasRole(String role) {
        return true;
    }
}
