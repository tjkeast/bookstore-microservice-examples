package example.micronaut.bookstore.core.security;

import io.micronaut.security.authentication.Authentication;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;
import java.util.Map;

@Getter
@Builder
public class User {

    private String id;

    private String username;

    private Collection<String> roles;

    private Map<String, Object> attributes;

    public static User of(Authentication authentication) {
        return User.builder()
                .id(authentication.getName())
                .username(SecurityHelper.getCurrentUsername())
                .roles(authentication.getRoles())
                .attributes(authentication.getAttributes())
                .build();
    }
}
