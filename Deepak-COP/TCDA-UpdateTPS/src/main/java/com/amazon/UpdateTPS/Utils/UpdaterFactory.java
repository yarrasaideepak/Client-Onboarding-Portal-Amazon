package com.amazon.UpdateTPS.Utils;


public class UpdaterFactory {
	
	public static Updater getUpdater(String updaterType) {
		
		Updater updater = null;
		if (updaterType.equalsIgnoreCase("AmazonDynamoDB")) {
			updater = new AmazonDBUpdater();
		 }
		return updater;
	}
	
}
