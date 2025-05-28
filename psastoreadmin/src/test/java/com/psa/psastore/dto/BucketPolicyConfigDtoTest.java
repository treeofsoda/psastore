package com.psa.psastore.dto;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class BucketPolicyConfigDtoTest {
    @Test
    public void testBuilder() {
        BucketPolicyConfigDto.Statement statement = BucketPolicyConfigDto.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action("s3:GetObject")
                .Resource("arn:aws:s3:::example-bucket/*")
                .build();
        BucketPolicyConfigDto dto = BucketPolicyConfigDto.builder()
                .Version("2012-10-17")
                .Statement(Collections.singletonList(statement))
                .build();
        assertEquals("2012-10-17", dto.getVersion());
        assertNotNull(dto.getStatement());
        assertEquals(1, dto.getStatement().size());
        assertEquals("Allow", dto.getStatement().get(0).getEffect());
    }
}
