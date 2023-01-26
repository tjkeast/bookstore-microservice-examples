package example.micronaut.bookstore.core.security;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.security.token.DefaultRolesFinder;
import io.micronaut.security.token.config.TokenConfiguration;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
@Replaces(DefaultRolesFinder.class)
public class NestedRolesFinder extends DefaultRolesFinder {

    private final TokenConfiguration tokenConfiguration;

    public NestedRolesFinder(TokenConfiguration tokenConfiguration) {
        super(tokenConfiguration);
        this.tokenConfiguration = tokenConfiguration;
    }

    @Override
    public List<String> resolveRoles(Map<String, Object> attributes) {
        if (!tokenConfiguration.getRolesName().contains(".")) {
            return super.resolveRoles(attributes);
        } else {
            String[] rolePathComponents = tokenConfiguration.getRolesName().split("\\.");
            Map<String, Object> currentAttribute = attributes;
            for (String rolePathComponent : rolePathComponents) {
                if (currentAttribute != null) {
                    Object value = currentAttribute.get(rolePathComponent);
                    if (value instanceof Map) {
                        currentAttribute = (Map<String, Object>) value;
                    } else if (value instanceof Iterable<?>) {
                        return StreamSupport.stream(((Iterable<String>) value).spliterator(), false)
                                .collect(Collectors.toList());
                    } else if (value != null) {
                        return Collections.singletonList(value.toString());
                    } else {
                        break; // Value was null; no roles found
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}
