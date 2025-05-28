package com.psa.psastore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmsOrderReturnApplyServiceTest {
    @Test
    public void testClassExists() {
        try {
            Class.forName("com.macro.mall.service.OmsOrderReturnApplyService");
        } catch (ClassNotFoundException e) {
            fail("OmsOrderReturnApplyService class should exist");
        }
    }
}
