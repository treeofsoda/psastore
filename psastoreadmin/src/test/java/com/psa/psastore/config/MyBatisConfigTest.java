package com.psa.psastore.config;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.jupiter.api.Assertions.*;

class MyBatisConfigTest {
    @Test
    void testAnnotationsPresent() {
        assertNotNull(MyBatisConfig.class.getAnnotation(Configuration.class));
        assertNotNull(MyBatisConfig.class.getAnnotation(EnableTransactionManagement.class));
        assertNotNull(MyBatisConfig.class.getAnnotation(MapperScan.class));
    }
}
