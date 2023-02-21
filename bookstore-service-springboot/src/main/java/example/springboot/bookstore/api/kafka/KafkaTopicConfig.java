package example.springboot.bookstore.api.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name(BookProducer.TOPIC_NAME)
                .partitions(3)
                .build();
    }
}