package example.micronaut.bookstore.api.kafka.producer;

import example.micronaut.bookstore.api.model.Book;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Requires(property = "kafka.enabled", notEquals = StringUtils.TRUE)
@Replaces(BookProducer.class)
@Singleton
public class BookProducerFallback implements BookProducer {

    @Override
    public void sendBook(String key, Book book) {
        log.info("Mock send book");
    }
}
