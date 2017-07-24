package java.com.ad.controller;
import java.com.ad.dto.AdDto;
import java.com.ad.dto.ServiceResponse;
import java.com.ad.service.AdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdController {
	
	@Autowired
	private AdService service;
	
	@RequestMapping(value="/postNewAdCampaign",method=RequestMethod.POST)
	public ServiceResponse postNewAdCampaign(@RequestBody AdDto ad,@RequestHeader HttpHeaders headers) 
	{
		return service.postNewAdCampaign(ad);
	}
	
	@RequestMapping(value="/fetchCampaign/{partnerId}",method=RequestMethod.GET)
	public ServiceResponse fetchExistingActiveCampaign(@PathVariable String partnrId,@RequestHeader HttpHeaders headers) 
	{
		return service.fetchExistingAdCampaign(partnrId);
	}
	
	

}
