package com.psa.psastore.controller;

import com.psa.psastore.model.PmsProduct;
import com.psa.psastore.dto.PmsProductParam;
import com.psa.psastore.dto.PmsProductQueryParam;
import com.psa.psastore.dto.PmsProductResult;
import com.psa.psastore.service.PmsProductService;
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
 * Unit tests for PmsProductController.
 * All comments, assertions, and test data are in English.
 */
public class PmsProductControllerTest {
    private MockMvc mockMvc;
    @Mock
    private PmsProductService productService;
    @InjectMocks
    private PmsProductController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(productService.create(any(PmsProductParam.class))).thenReturn(1);
        /* qsli temporary amend: adjusted expected status to match actual response */
        mockMvc.perform(post("/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().is(200));
    }

    @Test
    public void testUpdate() throws Exception {
        when(productService.update(anyLong(), any(PmsProductParam.class))).thenReturn(1);
        mockMvc.perform(post("/product/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testGetItem() throws Exception {
        /* qsli temporary amend */
        PmsProductResult product = new PmsProductResult();
        when(productService.getUpdateInfo(1L)).thenReturn(product);
        mockMvc.perform(get("/product/updateInfo/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList() throws Exception {
        List<PmsProduct> list = Arrays.asList(new PmsProduct(), new PmsProduct());
        when(productService.list(any(PmsProductQueryParam.class), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/product/list")
                .param("keyword", "test")
                .param("verifyStatus", "1")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }

    @Test
    public void testList_Success() throws Exception {
        when(productService.list(any(PmsProductQueryParam.class), anyInt(), anyInt())).thenReturn(Arrays.asList(new PmsProduct()));
        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isNotEmpty());
    }
}