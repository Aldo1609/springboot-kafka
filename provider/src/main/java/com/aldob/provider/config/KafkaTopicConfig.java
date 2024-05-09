package com.aldob.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");

        NewTopic newTopic = TopicBuilder.name("example-topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();


        return newTopic;
    }

}
