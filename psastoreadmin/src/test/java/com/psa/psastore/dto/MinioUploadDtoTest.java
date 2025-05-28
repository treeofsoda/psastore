package com.psa.psastore.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinioUploadDtoTest {
    @Test
    public void testNoArgsConstructor() {
        MinioUploadDto param = new MinioUploadDto();
        assertNotNull(param);
    }
}
