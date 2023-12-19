package com.Amazon.COP.Utils;

import java.util.logging.Logger; 

import java.util.ArrayList;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class AmazDynReader implements Datastore {
	
	@Override
	 public ArrayList<ArrayList <String>> read() {
		
		final ArrayList<ArrayList <String>> Data = new ArrayList<ArrayList <String>>();
		
		@SuppressWarnings("deprecation")
		final DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()));
				   
		final String tblName = "TPSDataBase";	//Table Name

		//We add all the coulmns names of the columns that are required from the table and fetch them.
		
		ArrayList<String>RequiredCol = new ArrayList<String>() {				
			{add("TCDA_Fleet");add("Region");add("Host_Count");add("Current_TPS");add("FLO_TPM");} //Columns names that we need and read
		};							
		
		// 2D Arraylist that has the data of the coulmn names that are added in RequiredCol
		Table table = dynamoDB.getTable(tblName);
		
		Logger logger = Logger.getLogger( AmazDynReader.class.getName());
		
	    try {
	    	for(int i=0;i<=19;i++) {						// 20 items are present so loop upto 20
	    
	    		Item item = table.getItem("RowID", i);		//RowId is PrimaryKey with value as Row Number  
	    		
	    		Data.add(new ArrayList<String>());
	    		
	    		
	    		for(int j=0;j<RequiredCol.size();j++) {
	    		
	    			Data.get(i-1).add(j, (String) item.get((String)RequiredCol.get(j)));
	    		
	    		}
	    		
	    	}
	    	
	    }
	      
	    catch (Exception e) {
	    	  
	         logger.info("Cannot retrieve items... Please make sure Credentials provided are right");
	         logger.info(e.getMessage());
	    
	    }
	    
	    return Data;
	
	}

}
