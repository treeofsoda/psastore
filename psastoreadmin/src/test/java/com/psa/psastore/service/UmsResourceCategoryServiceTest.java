package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsResourceCategoryServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.UmsResourceCategoryService");
        } catch (ClassNotFoundException e) {
            fail("UmsResourceCategoryService class should exist");
        }
    }
}
