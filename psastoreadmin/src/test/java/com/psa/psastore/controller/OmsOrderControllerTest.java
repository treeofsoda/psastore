package com.psa.psastore.controller;

import com.psa.psastore.service.OmsOrderService;
import com.psa.psastore.model.OmsOrder;
import com.psa.psastore.dto.OmsOrderQueryParam;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OmsOrderController.class)
public class OmsOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OmsOrderService orderService;

    @Test
    public void testList_Success() throws Exception {
        Mockito.when(orderService.list(any(OmsOrderQueryParam.class), anyInt(), anyInt())).thenReturn(Collections.singletonList(new OmsOrder()));
        mockMvc.perform(get("/order/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList_Empty() throws Exception {
        Mockito.when(orderService.list(any(OmsOrderQueryParam.class), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/order/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
