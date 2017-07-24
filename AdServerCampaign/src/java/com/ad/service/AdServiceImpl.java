package java.com.ad.service;

import java.com.ad.dto.AdDto;
import java.com.ad.dto.ServiceResponse;
import java.com.ad.repository.AdRepository;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {
	private static Logger LOGGER = LoggerFactory.getLogger(AdServiceImpl.class);
	@Autowired
	private AdRepository adRepositry;

	@Override
	public ServiceResponse postNewAdCampaign(AdDto ad) {
		ServiceResponse response = new ServiceResponse();

		try {
			int postFlag = adRepositry.postNewAdCampaign(ad);
			switch (postFlag) {
			case 200:
				response.setErrorDesc(
						"no need to post,already active campaign is present for the requested partner id");
				response.setErrorCode("200");
				break;
			case 300:
				response.setDescrptn("new active campaign details posted");
				response.setErrorCode("300");
				break;
			case 400:
				response.setErrorDesc("invalid request");
				response.setErrorCode("400");
				break;
			case 500:
				response.setDescrptn("new campaign inserted");
				response.setErrorCode("500");
				break;
				default:break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ServiceResponse fetchExistingAdCampaign(String partnerId) {
		ServiceResponse response = new ServiceResponse();
		List<AdDto> list = adRepositry.fetchExistingAdCampaign(partnerId);
		response.setActiveAdCampaigns(list);
		response.setDescrptn("fetched successfully");
		return response;
	}

}
