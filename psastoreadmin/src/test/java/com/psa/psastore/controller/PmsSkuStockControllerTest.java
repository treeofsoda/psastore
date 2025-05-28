package com.psa.psastore.controller;

import com.psa.psastore.model.PmsSkuStock;
import com.psa.psastore.service.PmsSkuStockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for PmsSkuStockController.
 * All comments, assertions, and test data are in English.
 */
public class PmsSkuStockControllerTest {
    private MockMvc mockMvc;
    @Mock
    private PmsSkuStockService skuStockService;
    @InjectMocks
    private PmsSkuStockController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetList() throws Exception {
        List<PmsSkuStock> list = Arrays.asList(new PmsSkuStock(), new PmsSkuStock());
        when(skuStockService.getList(anyLong(), anyString())).thenReturn(list);
        mockMvc.perform(get("/skuStock/list/1")
                .param("keyword", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testUpdate() throws Exception {
        when(skuStockService.update(anyLong(), anyList())).thenReturn(1);
        mockMvc.perform(post("/skuStock/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
}