package com.Amazon.COP.Utils;

public class DatastoreFactory {
	
	public static Datastore getReader(String readerType) {
		 Datastore reader = null;
		 
		 if (readerType.equalsIgnoreCase("AmazonDynamoDB")) {
		     reader = new AmazDynReader();
		 }
		 
		 return reader;
	}

}
