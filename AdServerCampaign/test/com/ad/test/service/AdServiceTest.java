package com.ad.test.service;

import java.com.ad.dto.AdDto;
import java.com.ad.repository.AdRepositoryImpl;
import java.com.ad.service.AdService;
import java.com.ad.service.AdServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={AdServiceImpl.class,AdRepositoryImpl.class})
public class AdServiceTest {

	@InjectMocks
	private AdServiceImpl adServiceImpl;

	@Mock
	private AdRepositoryImpl repositoryImplMock;

	@Autowired
	private AdService adService;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	

	@Test
	public void testPostNewCampaignDetails() {
		AdDto ad = new AdDto();
		ad.setPartnerId("123458");
		ad.setDuration(1900800);
		ad.setCreationTime(1498699245000l);
		adServiceImpl.postNewAdCampaign(ad);

	}
	
	@Test
	public void testfetchCampaignDetails() {
		AdDto ad = new AdDto();
		ad.setPartnerId("123458");
		adServiceImpl.fetchExistingAdCampaign(ad.getPartnerId());

	}
}
