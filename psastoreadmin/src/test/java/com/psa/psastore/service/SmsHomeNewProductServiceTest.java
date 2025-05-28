package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsHomeNewProductServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsHomeNewProductService");
        } catch (ClassNotFoundException e) {
            fail("SmsHomeNewProductService class should exist");
        }
    }
}
