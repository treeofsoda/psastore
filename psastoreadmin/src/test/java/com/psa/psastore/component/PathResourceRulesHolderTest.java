package com.psa.psastore.component;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

class PathResourceRulesHolderTest {
    private PathResourceRulesHolder holder;
    private com.psa.psastore.service.UmsResourceService resourceService;

    @BeforeEach
    void setUp() {
        resourceService = mock(com.psa.psastore.service.UmsResourceService.class);
        holder = new PathResourceRulesHolder();
        ReflectionTestUtils.setField(holder, "resourceService", resourceService);
    }

    @Test
    void testInitPathResourceMap_callsResourceService() {
        holder.initPathResourceMap();
        verify(resourceService, times(1)).initPathResourceMap(); // com.psa.psastore.service.UmsResourceService
    }
}
