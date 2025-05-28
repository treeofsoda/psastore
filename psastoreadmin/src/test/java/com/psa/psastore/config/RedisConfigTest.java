package com.psa.psastore.config;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


class RedisConfigTest {
    @Test
    void testRedisConfigIsSubclassOfBaseRedisConfig() {
        RedisConfig config = new RedisConfig();
        assertTrue(config instanceof com.psa.psastore.common.config.BaseRedisConfig);
    }
}
