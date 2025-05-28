package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmsHomeRecommendSubjectServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.psa.psastore.service.SmsHomeRecommendSubjectService");
        } catch (ClassNotFoundException e) {
            fail("SmsHomeRecommendSubjectService class should exist");
        }
    }
}
