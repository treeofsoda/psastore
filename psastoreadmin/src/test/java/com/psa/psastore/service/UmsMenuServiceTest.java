package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsMenuServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.UmsMenuService");
        } catch (ClassNotFoundException e) {
            fail("UmsMenuService class should exist");
        }
    }
}
