package com.amazon.UpdateTPS.Utils;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;


//This class is to find the RowID of the specific Fleet and Region and return it.


public class GetRowID {
	

	
	public int FindRowID(String Fleet,String Region) {

		@SuppressWarnings("deprecation")
		final DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()));
				   
		final String tblName = "TPSDataBase";	//Table Name
		
		Table table = dynamoDB.getTable(tblName);
		
		ArrayList<String>RequiredCol = new ArrayList<String>() {				
			{add("TCDA_Fleet");add("Region");}						// Name of the columns to be considered for updating
		};		
		
		Logger logger = Logger.getLogger( GetRowID.class.getName());
		int i;
		try {
	    	for(i=0;i<=19;i++) {								//We have RowID from 0 to 19
	    
	    		Item item = table.getItem("RowID", i);			//RowId is PrimaryKey with value as Row Number  
	    		
	    		String val1 = item.getString((String)RequiredCol.get(0));	//Checking which RowID matched
	    		String val2 = item.getString((String)RequiredCol.get(1));

	    		if(val1.equals(Fleet) && val2.equals(Region)) {				// If we found the row we break the loop
	    			break;
	    		}
	    		
	    	}
	    	return i;
	    	
	    }
	      
	    catch (Exception e) {
	         logger.info("Cannot retrieve items... Please make sure Credentials provided are right");
	         logger.info(e.getMessage());									//If any error we print the error message
	         return -1;
	    }
		
	}


}
