package java.com.ad.dto;

import java.util.List;

public class ServiceResponse {
	
	private List<AdDto> activeAdCampaigns;
	private String errorCode;
	private String errorDesc;
	private String descrptn;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public List<AdDto> getActiveAdCampaigns() {
		return activeAdCampaigns;
	}
	public void setActiveAdCampaigns(List<AdDto> activeAdCampaigns) {
		this.activeAdCampaigns = activeAdCampaigns;
	}
	public String getDescrptn() {
		return descrptn;
	}
	public void setDescrptn(String descrptn) {
		this.descrptn = descrptn;
	}

}
