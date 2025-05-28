package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsCouponServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsCouponService");
        } catch (ClassNotFoundException e) {
            fail("SmsCouponService class should exist");
        }
    }
}
