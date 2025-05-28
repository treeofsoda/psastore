package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PmsProductAttributeServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.PmsProductAttributeService");
        } catch (ClassNotFoundException e) {
            fail("PmsProductAttributeService class should exist");
        }
    }
}
