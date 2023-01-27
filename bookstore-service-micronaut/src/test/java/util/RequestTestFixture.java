package util;

import example.micronaut.bookstore.api.model.BookRequest;

import java.time.LocalDate;

public class RequestTestFixture {

    public static BookRequest createBookRequest() {
        return BookRequest.builder()
                .title("Dune")
                .author("Frank Herbert")
                .releaseDate(LocalDate.of(2015, 8, 9))
                .coverImageUrl("https://www.whitcoulls.co.nz/content/products/94/76/6077694_MAIN.jpg?width=416&height=620&fit=bounds&enable=upscale&bg-color=ffffff&canvas=416%2C620")
                .description("""
                        Melange, or 'spice', is the most valuable element in the universe;
                        a drug that does everything from increasing a person
                        's life-span to making intersteller travel possible. And it can only be found on a single planet: the inhospitable desert world Arrakis.
                        """)
                .build();
    }
}
