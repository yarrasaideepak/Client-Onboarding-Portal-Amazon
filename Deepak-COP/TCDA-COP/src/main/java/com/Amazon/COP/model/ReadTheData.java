package com.Amazon.COP.model;

import java.util.ArrayList;

import BaseCodes.DatastoreFactory;

public class  ReadTheData {
	
	public ArrayList<ArrayList<String>> DataSet(){
	
		ArrayList<ArrayList<String> > Data2 = new ArrayList<ArrayList<String> >();
		Data2 = DatastoreFactory.getReader("AmazonDynamoDB").read();
		return Data2;
	}
	
}
	
	
