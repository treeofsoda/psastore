package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsCouponHistoryServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsCouponHistoryService");
        } catch (ClassNotFoundException e) {
            fail("SmsCouponHistoryService class should exist");
        }
    }
}
