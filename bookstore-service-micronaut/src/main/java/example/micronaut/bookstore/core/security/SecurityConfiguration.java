package example.micronaut.bookstore.core.security;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import lombok.Getter;

@Singleton
@Getter
public class SecurityConfiguration {

    @Value("${micronaut.security.enabled:true}")
    private boolean enabled;

    @Value("${micronaut.security.issuer}")
    private String issuer;

    @Value("${micronaut.security.client-id}")
    private String clientId;

    @Value("${micronaut.security.scope}")
    private String scope;
}
