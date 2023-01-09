package example.micronaut.bookstore.api.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.OffsetDateTime;

@Controller("/")
@Tag(name = "base")
public class BaseController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return OffsetDateTime.now().toString();
    }
}