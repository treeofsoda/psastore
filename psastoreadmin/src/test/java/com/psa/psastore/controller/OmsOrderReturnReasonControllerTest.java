package com.psa.psastore.controller;

import com.psa.psastore.service.OmsOrderReturnReasonService;
import com.psa.psastore.model.OmsOrderReturnReason;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OmsOrderReturnReasonController.class)
public class OmsOrderReturnReasonControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OmsOrderReturnReasonService returnReasonService;

    @Test
    public void testList_Success() throws Exception {
        Mockito.when(returnReasonService.list(anyInt(), anyInt())).thenReturn(Collections.singletonList(new OmsOrderReturnReason()));
        mockMvc.perform(get("/returnReason/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList_Empty() throws Exception {
        Mockito.when(returnReasonService.list(anyInt(), anyInt())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/returnReason/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
