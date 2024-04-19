package com.csti.intercopretail.microservice1.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    private static final String CLEANUP_POLICY_CONFIG = TopicConfig.CLEANUP_POLICY_CONFIG;
    private static final String RETENTION_MS_CONFIG = TopicConfig.RETENTION_MS_CONFIG;
    private static final String SEGMENT_BYTES_CONFIG = TopicConfig.SEGMENT_BYTES_CONFIG;
    private static final String MAX_MESSAGE_BYTES_CONFIG = TopicConfig.MAX_MESSAGE_BYTES_CONFIG;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = new HashMap<>();
        configurations.put(CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(RETENTION_MS_CONFIG, "86400000");
        configurations.put(SEGMENT_BYTES_CONFIG, "1073741824");
        configurations.put(MAX_MESSAGE_BYTES_CONFIG, "1000012");

        return TopicBuilder.name(topicName)
                .partitions(1)
                .replicas(1)
                .configs(configurations)
                .build();
    }
}
