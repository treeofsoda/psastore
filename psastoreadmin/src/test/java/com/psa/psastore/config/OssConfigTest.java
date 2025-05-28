package com.psa.psastore.config;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class OssConfigTest {
    @Test
    void testOssClientBean() {
        OssConfig config = new OssConfig();
        ReflectionTestUtils.setField(config, "ALIYUN_OSS_ENDPOINT", "endpoint");
        ReflectionTestUtils.setField(config, "ALIYUN_OSS_ACCESSKEYID", "keyId");
        ReflectionTestUtils.setField(config, "ALIYUN_OSS_ACCESSKEYSECRET", "keySecret");
        OSSClient client = config.ossClient();
        assertNotNull(client);
    }
}
