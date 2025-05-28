package com.psa.psastore.controller;

import com.psa.psastore.model.SmsFlashPromotionProductRelation;
import com.psa.psastore.dto.SmsFlashPromotionProduct;
import com.psa.psastore.service.SmsFlashPromotionProductRelationService;
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
 * Unit tests for SmsFlashPromotionProductRelationController.
 * All comments, assertions, and test data are in English.
 */
public class SmsFlashPromotionProductRelationControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsFlashPromotionProductRelationService relationService;
    @InjectMocks
    private SmsFlashPromotionProductRelationController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(relationService.create(anyList())).thenReturn(1);
        mockMvc.perform(post("/flashProductRelation/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(relationService.create(anyList())).thenReturn(0);
        mockMvc.perform(post("/flashProductRelation/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete() throws Exception {
        when(relationService.delete(anyLong())).thenReturn(1);
        mockMvc.perform(post("/flashProductRelation/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate() throws Exception {
        when(relationService.update(anyLong(), any(SmsFlashPromotionProductRelation.class))).thenReturn(1);
        mockMvc.perform(post("/flashProductRelation/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testGetItem() throws Exception {
        when(relationService.getItem(anyLong())).thenReturn(new SmsFlashPromotionProductRelation());
        mockMvc.perform(get("/flashProductRelation/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void testList() throws Exception {
        List<SmsFlashPromotionProduct> list = Arrays.asList(new SmsFlashPromotionProduct(), new SmsFlashPromotionProduct());
        when(relationService.list(anyLong(), anyLong(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/flashProductRelation/list")
                .param("flashPromotionId", "1")
                .param("flashPromotionSessionId", "1")
                .param("productId", "1")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}