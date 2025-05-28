package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CmsSubjectServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.CmsSubjectService");
        } catch (ClassNotFoundException e) {
            fail("CmsSubjectService class should exist");
        }
    }
}
