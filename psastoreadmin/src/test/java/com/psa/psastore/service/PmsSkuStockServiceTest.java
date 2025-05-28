package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PmsSkuStockServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.PmsSkuStockService");
        } catch (ClassNotFoundException e) {
            fail("PmsSkuStockService class should exist");
        }
    }
}
