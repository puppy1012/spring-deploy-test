package com.example.springdeploytest.redis_cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;


@Service
@RequiredArgsConstructor
public class RedisCacheServiceImpl implements RedisCacheService {
    final private StringRedisTemplate redisTemplate;

    @Override
    public <K, V> void setKeyAndValue(K key, V value) {
        setKeyAndValue(key, value, Duration.ofMinutes(720));
    }

    @Override
    public <K, V> void setKeyAndValue(K key, V value, Duration timeToLive) {
        String keyAsString = String.valueOf(key);
        String valueAsString = String.valueOf(value);

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(keyAsString, valueAsString, timeToLive);
    }

    @Override
    public Long getValueByKey(String token) {
        return 0L;
    }
}
