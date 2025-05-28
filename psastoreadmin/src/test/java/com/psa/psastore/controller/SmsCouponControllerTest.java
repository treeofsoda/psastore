package com.psa.psastore.controller;

import com.psa.psastore.model.SmsCoupon;
import com.psa.psastore.dto.SmsCouponParam;
import com.psa.psastore.service.SmsCouponService;
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
 * Unit tests for SmsCouponController.
 * All comments, assertions, and test data are in English.
 */
public class SmsCouponControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsCouponService couponService;
    @InjectMocks
    private SmsCouponController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(couponService.create(any(SmsCouponParam.class))).thenReturn(1);
        mockMvc.perform(post("/coupon/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete() throws Exception {
        when(couponService.delete(anyLong())).thenReturn(1);
        mockMvc.perform(post("/coupon/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate() throws Exception {
        when(couponService.update(anyLong(), any(SmsCouponParam.class))).thenReturn(1);
        mockMvc.perform(post("/coupon/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testGetItem() throws Exception {
        when(couponService.getItem(anyLong())).thenReturn(new SmsCouponParam());
        mockMvc.perform(get("/coupon/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void testList() throws Exception {
        List<SmsCoupon> list = Arrays.asList(new SmsCoupon(), new SmsCoupon());
        when(couponService.list(anyString(), anyInt(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/coupon/list")
                .param("name", "test")
                .param("type", "1")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}