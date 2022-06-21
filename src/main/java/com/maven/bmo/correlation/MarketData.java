package com.maven.bmo.correlation;

import java.util.HashMap;

public class MarketData {



	private HashMap<String,Double> fxQuotes;

	private HashMap<String,Double> corrQuotes;

	public void setFXQuotes(HashMap<String,Double> fxQuotes) {
		this.fxQuotes = fxQuotes;
	}

	public void setCorrQuotes(HashMap<String,Double> corrQuotes) {
		this.corrQuotes = corrQuotes;
	}

	public HashMap<String,Double> getFXQuotes() {
		return fxQuotes;
	}

	public HashMap<String,Double> getCorrQuotes() {
		return corrQuotes;
	}

	@Override
	public String toString() {
		return "FXQuotes : "+ fxQuotes.toString()+"\nCorrQuotes :"+corrQuotes.toString();
	}
}
