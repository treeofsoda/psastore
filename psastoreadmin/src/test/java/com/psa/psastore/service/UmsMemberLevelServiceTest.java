package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmsMemberLevelServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.UmsMemberLevelService");
        } catch (ClassNotFoundException e) {
            fail("UmsMemberLevelService class should exist");
        }
    }
}
