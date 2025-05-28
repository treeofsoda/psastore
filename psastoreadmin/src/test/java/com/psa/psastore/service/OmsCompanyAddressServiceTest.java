package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmsCompanyAddressServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.OmsCompanyAddressService");
        } catch (ClassNotFoundException e) {
            fail("OmsCompanyAddressService class should exist");
        }
    }
}
