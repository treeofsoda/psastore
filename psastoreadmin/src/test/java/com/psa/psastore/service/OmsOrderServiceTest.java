package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmsOrderServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.OmsOrderService");
        } catch (ClassNotFoundException e) {
            fail("OmsOrderService class should exist");
        }
    }
}
