package com.psa.psastore.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PmsProductQueryParamTest {
    @Test
    public void testNoArgsConstructor() {
        PmsProductQueryParam param = new PmsProductQueryParam();
        assertNotNull(param);
    }
}
