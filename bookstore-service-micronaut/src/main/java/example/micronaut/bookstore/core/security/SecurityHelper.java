package example.micronaut.bookstore.core.security;

import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.security.authentication.Authentication;

public class SecurityHelper {
    public static final String DEFAULT_USERNAME = "engine";
    public static final String PREFERRED_USERNAME_ATTRIBUTE = "preferred_username";

    private SecurityHelper() {
    }

    public static String getCurrentUsername() {
        return ServerRequestContext.currentRequest().flatMap(request -> request.getUserPrincipal(Authentication.class)).map(SecurityHelper::getUsername).orElse(DEFAULT_USERNAME);
    }

    public static String getUsername(Authentication authentication) {
        return String.valueOf(authentication.getAttributes().getOrDefault(PREFERRED_USERNAME_ATTRIBUTE, authentication.getName()));
    }
}
