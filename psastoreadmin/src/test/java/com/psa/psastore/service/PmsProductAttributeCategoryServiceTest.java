package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PmsProductAttributeCategoryServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.PmsProductAttributeCategoryService");
        } catch (ClassNotFoundException e) {
            fail("PmsProductAttributeCategoryService class should exist");
        }
    }
}
