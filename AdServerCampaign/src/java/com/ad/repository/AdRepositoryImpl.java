package java.com.ad.repository;

import java.com.ad.dto.AdDto;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AdRepositoryImpl implements AdRepository {

	private static Logger LOGGER = LoggerFactory.getLogger(AdRepositoryImpl.class);
	AdRepositoryImpl repostryImplInstnce = new AdRepositoryImpl();

	@Override
	public int postNewAdCampaign(AdDto ad) {

		int flag = 0;
		boolean flag1 = false;
		boolean flag2 = false;

		List<AdDto> adList;
		try {
			adList = repostryImplInstnce.readDataFromMemory();

			if (adList.contains(ad.getPartnerId())) {
				int i = adList.indexOf(ad);
				AdDto newObj = adList.get(i);
				Date currentdate = new Date();
				long crtnTmst = newObj.getCreationTime();
				long duratn = newObj.getDuration();
				long total = crtnTmst + duratn;
				Date actualDate = new Date(total);
				flag1 = currentdate.before(actualDate);
				flag2 = checkforrequestObj(ad);
			} else {
				flag2 = checkforrequestObj(ad);
			}
			if (flag1 == true) {
				flag = 200;
			} else if (flag1 == false && flag2 == true) {
				ListIterator<AdDto> itertr = adList.listIterator();
				while (itertr.hasNext()) {
					AdDto oldObj = itertr.next();
					if (oldObj.getPartnerId().equalsIgnoreCase(ad.getPartnerId())) {
						itertr.remove();
						itertr.add(ad);
					}

				}
				flag = 300;
			} else if (!adList.contains(ad.getPartnerId()) && flag2 == false) {
				flag = 400;
			} else if (!adList.contains(ad.getPartnerId()) && flag2 == true) {
				adList.add(ad);
				flag = 500;
			}

			FileOutputStream fos = new FileOutputStream("data.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(adList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public List<AdDto> fetchExistingAdCampaign(String partnerId) {
		List<AdDto> resultList = new ArrayList<>();
		try {
			List<AdDto> adList = repostryImplInstnce.readDataFromMemory();

			if (adList.contains(partnerId)) {
				int i = adList.indexOf(partnerId);
				resultList.add(adList.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	public List<AdDto> readDataFromMemory() throws IOException {
		final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.txt");
		final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
		List<AdDto> adList = new ArrayList<>();
		String rowData = "";
		try {
			// reading file and setting to dto.
			while ((rowData = bufferReader.readLine()) != null) {
				final String[] rowValues = rowData.split(",");
				AdDto dtoObj = new AdDto();
				dtoObj.setPartnerId(rowValues[0]);
				dtoObj.setCreationTime(Long.valueOf(rowValues[1]));
				dtoObj.setDuration(Long.valueOf(rowValues[2]));
				dtoObj.setAdContent(rowValues[3]);
				adList.add(dtoObj);
			}
		} finally {
			bufferReader.close();
			inputStream.close();
		}
		return adList;
	}

	private boolean checkforrequestObj(AdDto ad) {
		Date currentdate = new Date();
		long crtnTmst = ad.getCreationTime();
		long duratn = ad.getDuration();
		long total = crtnTmst + duratn;
		Date actualDate = new Date(total);

		return currentdate.before(actualDate);
	}
}
