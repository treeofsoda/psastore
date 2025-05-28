package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsFlashPromotionProductRelationServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsFlashPromotionProductRelationService");
        } catch (ClassNotFoundException e) {
            fail("SmsFlashPromotionProductRelationService class should exist");
        }
    }
}
