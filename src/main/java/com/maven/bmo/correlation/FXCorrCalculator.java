package com.maven.bmo.correlation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FXCorrCalculator {

	public List<Double> getResults(String startDate, String endDate) throws Exception{

		BOCValetWebService service = new BOCValetWebService();

		MarketData mktData;
		try {
			mktData = service.getMarketData(startDate, endDate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		List<Double> results = new ArrayList<Double>();

		HashMap<String, Double> fxQuotes = mktData.getFXQuotes();

		HashMap<String, Double> corrQuotes = mktData.getCorrQuotes();


		/*		HashMap<String,Double> fxQuotes = new HashMap<>();
		fxQuotes.put("2020-05-09", Double.parseDouble("6"));
		fxQuotes.put("2020-05-12", Double.parseDouble("8"));
		fxQuotes.put("2020-05-15", Double.parseDouble("10"));

		HashMap<String,Double> corrQuotes = new HashMap<>();
		corrQuotes.put("2020-05-09", Double.parseDouble("12"));
		corrQuotes.put("2020-05-12", Double.parseDouble("10"));
		corrQuotes.put("2020-05-15", Double.parseDouble("20"));*/

		double highFX = getHighQuote(fxQuotes);
		double lowFX = getLowQuote(fxQuotes);
		double meanFX = getMeanQuote(fxQuotes);

		double highCorr = getHighQuote(corrQuotes);
		double lowCorr = getLowQuote(corrQuotes);
		double meanCorr = getMeanQuote(corrQuotes);

		double correlation = getCorrelation(fxQuotes, corrQuotes);
		results.add(highFX);
		results.add(lowFX);
		results.add(meanFX);
		results.add(highCorr);
		results.add(lowCorr);
		results.add(meanCorr);
		results.add(correlation);

		return results;

	}

	/*	Formula Source
		https://www.wallstreetmojo.com/pearson-correlation-coefficient/
	 */	
	private double getCorrelation(HashMap<String, Double> quoteX, HashMap<String, Double> quoteY) {

		int n = quoteX.size()<quoteY.size()?quoteX.size():quoteY.size();

		double sumX = quoteX.values().stream().reduce(0d, Double::sum);
		double sumY = quoteY.values().stream().reduce(0d, Double::sum);


		double sumXY = quoteX.entrySet().stream().mapToDouble(e->e.getValue()* quoteY.getOrDefault(e.getKey(), 1d)).sum();

		double sumXX = quoteX.entrySet().stream().mapToDouble(e->e.getValue()* quoteX.getOrDefault(e.getKey(), 1d)).sum();

		double sumYY = quoteY.entrySet().stream().mapToDouble(e->e.getValue()* quoteY.getOrDefault(e.getKey(), 1d)).sum();

		double correlation  = ((n*sumXY) - (sumX*sumY))/Math.sqrt((n*sumXX - (sumX*sumX))*(n*sumYY - (sumY*sumY)));
		
		correlation = Double.isInfinite(correlation) ? 0 : correlation; // Corner case, if values of quotes are unchanged in given range of date
		
		return correlation;
	}

	private double getHighQuote(HashMap<String, Double> quotes) {
		return quotes.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
	}

	private double getLowQuote(HashMap<String, Double> quotes) {
		return quotes.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get().getValue();
	}

	private double getMeanQuote(HashMap<String, Double> quotes) {

		return quotes.entrySet().stream().mapToDouble(i -> i.getValue()).average().orElse(0);
	}
}
