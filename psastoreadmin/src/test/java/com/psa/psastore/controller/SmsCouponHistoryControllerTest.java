package com.psa.psastore.controller;

import com.psa.psastore.model.SmsCouponHistory;
import com.psa.psastore.service.SmsCouponHistoryService;
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
 * Unit tests for SmsCouponHistoryController.
 * All comments, assertions, and test data are in English.
 */
public class SmsCouponHistoryControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsCouponHistoryService couponHistoryService;
    @InjectMocks
    private SmsCouponHistoryController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testList() throws Exception {
        List<SmsCouponHistory> list = Arrays.asList(new SmsCouponHistory(), new SmsCouponHistory());
        when(couponHistoryService.list(anyLong(),  anyInt(), anyString(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/couponHistory/list")
                .param("couponId", "1")
                .param("useStatus", "1")
                .param("orderSn", "test")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}