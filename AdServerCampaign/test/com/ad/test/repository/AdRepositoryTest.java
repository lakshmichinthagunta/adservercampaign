package com.ad.test.repository;

import java.com.ad.dto.AdDto;
import java.com.ad.repository.AdRepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class AdRepositoryTest {

	@InjectMocks
	private AdRepositoryImpl adRepositoryImpl;

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
		adRepositoryImpl.postNewAdCampaign(ad);

	}
	
	@Test
	public void testfetchCampaignDetails() {
		AdDto ad = new AdDto();
		ad.setPartnerId("123458");
		adRepositoryImpl.fetchExistingAdCampaign(ad.getPartnerId());

	}

}
