package com.psa.psastore.controller;

import com.psa.psastore.service.OmsOrderReturnApplyService;
import com.psa.psastore.model.OmsOrderReturnApply;
import com.psa.psastore.dto.OmsReturnApplyQueryParam;
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

@WebMvcTest(OmsOrderReturnApplyController.class)
public class OmsOrderReturnApplyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OmsOrderReturnApplyService returnApplyService;

    @Test
    public void testList_Success() throws Exception {
        Mockito.when(returnApplyService.list(any(OmsReturnApplyQueryParam.class), anyInt(), anyInt())).thenReturn(Collections.singletonList(new OmsOrderReturnApply()));
        mockMvc.perform(get("/returnApply/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList_Empty() throws Exception {
        Mockito.when(returnApplyService.list(any(OmsReturnApplyQueryParam.class), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/returnApply/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
