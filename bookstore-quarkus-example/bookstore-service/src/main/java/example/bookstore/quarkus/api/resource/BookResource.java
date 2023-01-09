package example.bookstore.quarkus.api.resource;

import example.bookstore.quarkus.api.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> hello() {
        return Collections.emptyList();
    }
}
