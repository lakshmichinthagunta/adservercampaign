package com.ad.test.controller;

import java.com.ad.controller.AdController;
import java.com.ad.dto.AdDto;
import java.com.ad.dto.ServiceResponse;
import java.com.ad.service.AdServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
public class AdControllerMockTest {

	@InjectMocks
	AdController controller;

	private MockMvc mockMvc;

	@Mock
	private AdServiceImpl serviceImplMock;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	@Test
	public void testpostCampaignDetailsMock() throws Exception {
		AdDto ad = new AdDto();
		ad.setPartnerId("123458");
		ad.setDuration(1900800);
		ad.setCreationTime(1498699245000l);
		Mockito.when(serviceImplMock.postNewAdCampaign(ad)).thenReturn(new ServiceResponse());
		mockMvc.perform(MockMvcRequestBuilders.get("/postNewAdCampaign"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testfetchCampaignDetailsMock() throws Exception {
		AdDto ad = new AdDto();
		ad.setPartnerId("123458");
		Mockito.when(serviceImplMock.fetchExistingAdCampaign(ad.getPartnerId())).thenReturn(new ServiceResponse());
		mockMvc.perform(MockMvcRequestBuilders.get("/fetchCampaign/{partnerId}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
