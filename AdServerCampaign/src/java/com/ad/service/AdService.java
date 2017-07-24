package java.com.ad.service;

import java.com.ad.dto.AdDto;
import java.com.ad.dto.ServiceResponse;

public interface AdService {

	public ServiceResponse postNewAdCampaign(AdDto ad);

	public ServiceResponse fetchExistingAdCampaign(String partnrId);
}
