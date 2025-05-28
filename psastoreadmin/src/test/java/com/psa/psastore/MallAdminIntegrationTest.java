package com.psa.psastore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MallAdminIntegrationTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        assertNotNull(applicationContext, "Application context should be loaded");
    }

    @Test
    public void mainBeanPresent() {
        assertTrue(applicationContext.containsBeanDefinition("psaStoreAdminApplication"), "Main application bean should be present");
    }
}
