package com.psa.psastore.controller;

import com.psa.psastore.service.OmsCompanyAddressService;
import com.psa.psastore.model.OmsCompanyAddress;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OmsCompanyAddressController.class)
public class OmsCompanyAddressControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OmsCompanyAddressService companyAddressService;

    @Test
    public void testList_Success() throws Exception {
        Mockito.when(companyAddressService.list()).thenReturn(Collections.singletonList(new OmsCompanyAddress()));
        mockMvc.perform(get("/companyAddress/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList_Empty() throws Exception {
        Mockito.when(companyAddressService.list()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/companyAddress/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
