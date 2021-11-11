package portifolioOverLap.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import portifolioOverLap.exceptions.InstrumentException.InstrumentAlreadyMappedException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundExistsException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundNotExistsException;
import portifolioOverLap.factory.MutalFundServiceFactory;
import portifolioOverLap.service.MutualFundService;



public class DataUtility {
	
	
	

	public static String getSrcJson() throws URISyntaxException {
		
		InputStream is  = DataUtility.class.getClassLoader().getResourceAsStream("stock_data.json");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String jsonString = "{}";
		try 
		{
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) 
			{
			    sb.append(line);
			}

			jsonString = sb.toString();

		} catch (IOException ioex) {

			try {
				isr.close();
				br.close();
			} catch (Exception ex) {

			}

		}
		return jsonString;
	}


	public static void storeTestData() throws URISyntaxException 
	{
		MutualFundService mfService  = MutalFundServiceFactory.getMfService(MutalFundServiceFactory.EQUITY_MF_SERVICE_TYPE);
		
		String jsonString = getSrcJson();
		JSONObject object = new JSONObject(jsonString);
		JSONArray arr = object.getJSONArray("funds");
		arr.forEach(obj -> 
		{
			JSONObject mfObj = (JSONObject) obj;
			String fundname =  mfObj.getString("name");
			try 
			{
				mfService.createMf(fundname);
			}
			catch (MutualFundExistsException e) 
			{
				e.printStackTrace();
			}
			
			JSONArray stocks = mfObj.getJSONArray("stocks");
			stocks.forEach(stock ->
			{
				try
				{
					mfService.addInstrument(fundname, stock.toString());
				}
				catch(InstrumentAlreadyMappedException iemx)
				{
					iemx.printStackTrace();
				}
				catch(MutualFundNotExistsException mnee)
				{
					mnee.printStackTrace();
				}
				
			});
		});		
		/*
		 * System.out.println("#######################################");
		 * System.out.println("      Data Loaded From JSON File       ");
		 * System.out.println("#######################################");
		 */
	}

}