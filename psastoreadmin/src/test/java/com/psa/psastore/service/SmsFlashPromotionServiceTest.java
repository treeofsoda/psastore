package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsFlashPromotionServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsFlashPromotionService");
        } catch (ClassNotFoundException e) {
            fail("SmsFlashPromotionService class should exist");
        }
    }
}
