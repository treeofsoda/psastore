package com.psa.psastore.controller;

import com.psa.psastore.model.SmsHomeRecommendProduct;
import com.psa.psastore.service.SmsHomeRecommendProductService;
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
 * Unit tests for SmsHomeRecommendProductController.
 * All comments, assertions, and test data are in English.
 */
public class SmsHomeRecommendProductControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsHomeRecommendProductService recommendProductService;
    @InjectMocks
    private SmsHomeRecommendProductController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(recommendProductService.create(anyList())).thenReturn(1);
        mockMvc.perform(post("/home/recommendProduct/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(recommendProductService.create(anyList())).thenReturn(0);
        mockMvc.perform(post("/home/recommendProduct/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdateSort() throws Exception {
        when(recommendProductService.updateSort(anyLong(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/home/recommendProduct/update/sort/1")
                .param("sort", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete() throws Exception {
        when(recommendProductService.delete(anyList())).thenReturn(1);
        mockMvc.perform(post("/home/recommendProduct/delete")
                .param("ids", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateRecommendStatus() throws Exception {
        when(recommendProductService.updateRecommendStatus(anyList(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/home/recommendProduct/update/recommendStatus")
                .param("ids", "1,2")
                .param("recommendStatus", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList() throws Exception {
        List<SmsHomeRecommendProduct> list = Arrays.asList(new SmsHomeRecommendProduct(), new SmsHomeRecommendProduct());
        when(recommendProductService.list(anyString(), anyInt(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/home/recommendProduct/list")
                .param("productName", "test")
                .param("recommendStatus", "1")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}