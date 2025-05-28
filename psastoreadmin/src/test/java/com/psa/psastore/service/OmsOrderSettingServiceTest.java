package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmsOrderSettingServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.OmsOrderSettingService");
        } catch (ClassNotFoundException e) {
            fail("OmsOrderSettingService class should exist");
        }
    }
}
