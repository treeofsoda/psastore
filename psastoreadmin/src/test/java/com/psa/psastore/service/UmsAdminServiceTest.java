package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsAdminServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.UmsAdminService");
        } catch (ClassNotFoundException e) {
            fail("UmsAdminService class should exist");
        }
    }
}
