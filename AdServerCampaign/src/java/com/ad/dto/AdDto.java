package java.com.ad.dto;

import java.io.Serializable;

public class AdDto implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String partnerId;
private long duration;
private long creationTime;
private String adContent;
public String getPartnerId() {
	return partnerId;
}
public void setPartnerId(String partnerId) {
	this.partnerId = partnerId;
}
public long getDuration() {
	return duration;
}
public void setDuration(long duration) {
	this.duration = duration;
}

public String getAdContent() {
	return adContent;
}
public void setAdContent(String adContent) {
	this.adContent = adContent;
}
public long getCreationTime() {
	return creationTime;
}
public void setCreationTime(long creationTime) {
	this.creationTime = creationTime;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((partnerId == null) ? 0 : partnerId.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AdDto other = (AdDto) obj;
	if (partnerId == null) {
		if (other.partnerId != null)
			return false;
	} else if (!partnerId.equals(other.partnerId))
		return false;
	return true;
}

}
