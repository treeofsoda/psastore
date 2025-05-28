package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsResourceServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.UmsResourceService");
        } catch (ClassNotFoundException e) {
            fail("UmsResourceService class should exist");
        }
    }
}
