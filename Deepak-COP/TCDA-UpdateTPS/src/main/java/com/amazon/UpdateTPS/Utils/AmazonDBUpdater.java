package com.amazon.UpdateTPS.Utils;

//This class is to update the values in the Amazon DynamoDB

import java.util.logging.Logger;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;


public class AmazonDBUpdater implements Updater {
	
	

	public int update(String Fleet,String Region,String StableTPS,String CurrentTPS,String NoOfHosts) {
	
		 
		@SuppressWarnings("deprecation")
		final  DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()));
				   
		final String tblName = "TPSDataBase";	//Table Name
		
		Table table = dynamoDB.getTable(tblName);
		
		
		
		GetRowID ID = new GetRowID();			
		
		int RowID = ID.FindRowID(Fleet, Region);	//To get the RowID of the Fleet and Region specified by client (RowID is primary key which is different for each item)
		
		if(RowID == -1) {return 0;}					//If the specied fleet and region were not found
		
		float TPS_TPM=Integer.parseInt(StableTPS);
		TPS_TPM=TPS_TPM*60;							//Converting TPS entered to TPM as we are storing in TPM ot TPS 
		String StableTPM= String.valueOf(TPS_TPM);
		
        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("RowID", RowID)			//Specifying the details like the RowID and the Data that is to be updated
                .withUpdateExpression("set Current_TPS = :r, FLO_TPM = :s, Host_Count = :a")
                .withValueMap(new ValueMap().withString(":r", CurrentTPS).withString(":s", StableTPM ).withString(":a", NoOfHosts))
                .withReturnValues(ReturnValue.UPDATED_NEW);
        
        Logger logger = Logger.getLogger( AmazonDBUpdater.class.getName());
     
        try {
            logger.info("Updating the item...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);							//Updating the values
            logger.info("UpdateItem succeeded completely:\n" + outcome.getItem().toJSONPretty());
            return 1;
        }
        
        catch (Exception e) {
            logger.info("Unable to update item check for error");
            logger.info(e.getMessage());															//Shows error message
            return 0;
        }
		
	}


}
