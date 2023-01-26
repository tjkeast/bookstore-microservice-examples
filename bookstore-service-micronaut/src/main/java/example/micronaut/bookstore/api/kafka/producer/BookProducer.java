package example.micronaut.bookstore.api.kafka.producer;

import example.micronaut.bookstore.api.model.Book;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;

@Requires(property = "kafka.enabled", value = StringUtils.TRUE)
@KafkaClient
public interface BookProducer {

    String TOPIC = "example.bookstore.topic.book";

    @Topic(TOPIC)
    void sendBook(@KafkaKey String key, Book book);
}
