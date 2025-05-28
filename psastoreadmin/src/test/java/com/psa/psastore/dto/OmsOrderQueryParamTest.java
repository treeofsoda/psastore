package com.psa.psastore.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmsOrderQueryParamTest {
    @Test
    public void testNoArgsConstructor() {
        OmsOrderQueryParam param = new OmsOrderQueryParam();
        assertNotNull(param);
    }
}
