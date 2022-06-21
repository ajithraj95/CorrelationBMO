package com.maven.bmo.correlation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BOCValetWebService {

	final String baseURL = "https://www.bankofcanada.ca/valet";

	public MarketData getMarketData(String startDate, String endDate) throws Exception {

		MarketData marketData = new MarketData();

		HashMap<String,Double> fxQuotes = getMarketQuotes("FXUSDCAD",startDate,endDate);
		marketData.setFXQuotes(fxQuotes);

		HashMap<String,Double> corrQuotes = getMarketQuotes("AVG.INTWO", startDate, endDate);
		marketData.setCorrQuotes(corrQuotes);

		System.out.println(marketData);

		return marketData;
	}

	private HashMap<String,Double> getMarketQuotes(String marketData, String startDate, String endDate) throws Exception {

		String response = getResponse(marketData,startDate,endDate);

		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) new JSONParser().parse(response);
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
		JSONArray jsonArr= (JSONArray) jsonObj.get("observations");
		HashMap<String,Double> quotesMap = new HashMap<>();
		for(int i=0;i<jsonArr.size();i++) {
			JSONObject json = (JSONObject) jsonArr.get(i);
			String date = (String) json.get("d");
			String rate = (String)((JSONObject)json.get(marketData)).get("v");
			quotesMap.put(date, Double.parseDouble(rate));
		}
		return quotesMap;
	}

	private String getResponse(String marketData, String startDate, String endDate) throws Exception {

		String response = "";

		String connectionURL =  baseURL+"/observations/"+marketData+"?start_date="+startDate+"&end_date="+endDate;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(connectionURL).openConnection();
			connection.setRequestMethod("GET");
			if(connection.getResponseCode() == 200){
				Scanner scanner = new Scanner(connection.getInputStream());
				while(scanner.hasNextLine()){
					response += scanner.nextLine();
					response += "\n";
				}
				scanner.close();
			}
			else {
				throw new Exception("Connection Refused for "+connectionURL+" with Response Code : "+connection.getResponseCode());
			}
		} catch (MalformedURLException e) {
			throw new Exception(e.getMessage()); 
		} catch (IOException e) {
			throw new Exception(e.getMessage()); 
		}
		return response;
	}
}
