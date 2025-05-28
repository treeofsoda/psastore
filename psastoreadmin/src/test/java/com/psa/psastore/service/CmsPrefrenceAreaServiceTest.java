package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CmsPrefrenceAreaServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.CmsPrefrenceAreaService");
        } catch (ClassNotFoundException e) {
            fail("CmsPrefrenceAreaService class should exist");
        }
    }
}
