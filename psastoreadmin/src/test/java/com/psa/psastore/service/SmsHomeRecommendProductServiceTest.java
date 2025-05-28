package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsHomeRecommendProductServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsHomeRecommendProductService");
        } catch (ClassNotFoundException e) {
            fail("SmsHomeRecommendProductService class should exist");
        }
    }
}
