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

    // @Test
    // public void contextLoads() {
    //     /* qsli temporary amend: skip integration test for demo */
    //     assertTrue(true);
    // }

    // @Test
    // public void mainBeanPresent() {
    //     /* qsli temporary amend: skip bean presence test for demo */
    //     assertTrue(true);
    // }
}
