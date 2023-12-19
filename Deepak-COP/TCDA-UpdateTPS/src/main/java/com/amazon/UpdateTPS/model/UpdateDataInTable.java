package com.amazon.UpdateTPS.model;

import com.amazon.UpdateTPS.Utils.*;			//Importing all .java files from Utils 


public class UpdateDataInTable {
	
	public String Fleet;
	public String Region;
	public String StableTPS;
	public String CurrentTPS;
	public String NoOfHosts;
	
	public int Reader() {
	
	// Passes the data to the AmazonDBUpdater.java to update in the DynamoDB
		
	return UpdaterFactory.getUpdater("AmazonDynamoDB").update(getFleet(),getRegion(),getStableTPS(),getCurrentTPS(),getNoOfHosts());
		
	}
	
	
	// Setter and Getter for getting different values
	
	public String getFleet() {
		return Fleet;
	}
	
	public void setFleet(String Fleet) {
		this.Fleet = Fleet;
	}
	
	public String getRegion() {
		return Region;
	}
	
	public void setRegion(String Region) {
		this.Region = Region;
	}
	
	public String getStableTPS() {
		return StableTPS;
	}
	
	public void setStableTPS(String StableTPS) {
		this.StableTPS = StableTPS;
	}
	
	public String getCurrentTPS() {
		return CurrentTPS;
	}
	
	public void setCurrentTPS(String CurrentTPS) {
		this.CurrentTPS = CurrentTPS;
	}
	
	public String getNoOfHosts() {
		return NoOfHosts;
	}
	
	public void setNoOfHosts(String NoOfHosts) {
		this.NoOfHosts = NoOfHosts;
	}
	
	
	public int Results() {
		
	if(getRegion()!= null) {
		return Reader();
	}
	
	else {
		return 1;
	}
	
	}


}
