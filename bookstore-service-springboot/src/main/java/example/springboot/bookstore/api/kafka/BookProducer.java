package example.springboot.bookstore.api.kafka;

import example.springboot.bookstore.api.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookProducer {

    static final String TOPIC_NAME = "example.springboot.bookstore.book";
    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    public void send(Book book) {
        kafkaTemplate.send(TOPIC_NAME, book);
    }

}
