package com.psa.psastore.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateAdminPasswordParamTest {
    @Test
    public void testNoArgsConstructor() {
        UpdateAdminPasswordParam param = new UpdateAdminPasswordParam();
        assertNotNull(param);
    }
}
