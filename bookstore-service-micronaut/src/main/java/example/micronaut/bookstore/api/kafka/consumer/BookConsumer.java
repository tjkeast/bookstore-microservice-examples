package example.micronaut.bookstore.api.kafka.consumer;

import example.micronaut.bookstore.api.kafka.producer.BookProducer;
import example.micronaut.bookstore.api.model.Book;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@KafkaListener(groupId = "example.micronaut.bookstore.api.kafka.consumer.BookConsumer", clientId = "book-consumer", offsetReset = OffsetReset.EARLIEST)
public class BookConsumer {

    @Topic(BookProducer.TOPIC)
    public void receive(@KafkaKey String key, Book book) {
        log.info(String.format("New book received (key=%s, title=%s)", key, book.getTitle()));
    }
}
