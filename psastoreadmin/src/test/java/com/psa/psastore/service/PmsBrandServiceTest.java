package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PmsBrandServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.PmsBrandService");
        } catch (ClassNotFoundException e) {
            fail("PmsBrandService class should exist");
        }
    }
}
