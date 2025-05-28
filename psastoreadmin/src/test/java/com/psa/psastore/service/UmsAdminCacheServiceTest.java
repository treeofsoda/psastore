package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsAdminCacheServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.UmsAdminCacheService");
        } catch (ClassNotFoundException e) {
            fail("UmsAdminCacheService class should exist");
        }
    }
}
