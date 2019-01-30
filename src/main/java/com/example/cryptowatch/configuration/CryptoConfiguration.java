package com.example.cryptowatch.configuration;

import com.example.cryptowatch.entity.Ticker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by eleven on 26.01.2019.
 */
@Configuration
public class CryptoConfiguration {
    @Bean
    ReactiveRedisOperations<String, Ticker> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Ticker> serializer = new Jackson2JsonRedisSerializer<>(Ticker.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Ticker> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Ticker> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
