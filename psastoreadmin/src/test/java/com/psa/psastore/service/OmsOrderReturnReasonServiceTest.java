package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmsOrderReturnReasonServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.OmsOrderReturnReasonService");
        } catch (ClassNotFoundException e) {
            fail("OmsOrderReturnReasonService class should exist");
        }
    }
}
