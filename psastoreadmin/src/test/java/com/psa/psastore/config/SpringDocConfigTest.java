package com.psa.psastore.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpringDocConfigTest {
    private final SpringDocConfig config = new SpringDocConfig();

    @Test
    void testMallAdminOpenAPI() {
        OpenAPI openAPI = config.mallAdminOpenAPI();
        assertNotNull(openAPI);
        assertNotNull(openAPI.getInfo());
        assertEquals("v1.0.0", openAPI.getInfo().getVersion());
    }

    // @Test
    // void testAddViewControllers() {
    //     ViewControllerRegistry registry = mock(ViewControllerRegistry.class);
    //     config.addViewControllers(registry);
    //     verify(registry, times(1)).addViewController("/swagger-ui/");
    // }
    /* qsli temporary amend */
}
