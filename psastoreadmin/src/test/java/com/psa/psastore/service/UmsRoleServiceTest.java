package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsRoleServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.UmsRoleService");
        } catch (ClassNotFoundException e) {
            fail("UmsRoleService class should exist");
        }
    }
}
