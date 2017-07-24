package java.com.ad.repository;

import java.com.ad.dto.AdDto;
import java.io.IOException;
import java.util.List;

public interface AdRepository {

	public int postNewAdCampaign(AdDto ad) throws IOException;

	public List<AdDto> fetchExistingAdCampaign(String partnerId);

}
