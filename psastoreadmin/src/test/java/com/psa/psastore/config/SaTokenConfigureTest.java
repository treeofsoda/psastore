package com.psa.psastore.config;

import cn.dev33.satoken.stp.StpLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaTokenConfigureTest {
    @Test
    void testGetStpLogicJwt() {
        SaTokenConfigure config = new SaTokenConfigure();
        StpLogic logic = config.getStpLogicJwt();
        assertNotNull(logic);
        assertTrue(logic.getClass().getSimpleName().toLowerCase().contains("jwt"));
    }
}
