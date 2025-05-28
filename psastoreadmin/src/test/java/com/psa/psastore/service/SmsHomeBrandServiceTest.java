package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsHomeBrandServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.SmsHomeBrandService");
        } catch (ClassNotFoundException e) {
            fail("SmsHomeBrandService class should exist");
        }
    }
}
