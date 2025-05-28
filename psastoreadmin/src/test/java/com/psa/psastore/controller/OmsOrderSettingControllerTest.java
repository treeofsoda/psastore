package com.psa.psastore.controller;

import com.psa.psastore.service.OmsOrderSettingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OmsOrderSettingController.class)
public class OmsOrderSettingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OmsOrderSettingService orderSettingService;

    @Test
    public void testList_Success() throws Exception {
        mockMvc.perform(get("/orderSetting/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList_Empty() throws Exception {
        mockMvc.perform(get("/orderSetting/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
