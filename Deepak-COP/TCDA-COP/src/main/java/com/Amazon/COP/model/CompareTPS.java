package com.Amazon.COP.model;


import BaseCodes.StableAndCurrTpm;
import javafx.util.Pair; 

import java.util.ArrayList;

// This class is used to give out the capacity the fleet can handle (i.e., max value of TPS accepted)

public class CompareTPS  {
	
	private ArrayList<ArrayList<String>> Fleet_Region;		//With data that contains 2 rows with first row as Fleet second as Region
	private ArrayList<ArrayList<Float>> Curr_Stable_Tpm;	//With data that contains 2 rows with first row as Current TPM and second row with Stable TPM of Specific fleet and region
	private String Fleet="";				// User requested Fleet
	private String Region="";				// User requested Region

	
	public float compare(String CustFleet,String CustRegion) {
		
		
		float StableTpmFleet = 0;		// Tpm fleet can handle
		float CurrTpmFleet = 0;			// Current TPM at which fleet is serving
		
		
		// For Identifying the Stable and Current TPM of the specific fleet and region as specified by user
		
		for(int i=0;i<Fleet_Region.get(0).size();i++) {
			
			if(Fleet_Region.get(0).get(i).equals(CustFleet) && Fleet_Region.get(1).get(i).equals(CustRegion)) {
				
				StableTpmFleet =  Curr_Stable_Tpm.get(1).get(i);
				CurrTpmFleet= Curr_Stable_Tpm.get(0).get(i);
				break;
				
			}
		}  
		// Returning the maximum TPS user specified Fleet and Region can serve 
				
		return (int)(((StableTpmFleet/(float)1.15)-CurrTpmFleet)/(float)60);
		
	}
	
	
	public void getTpmData() {
		
		//Reading the data from StableAndCurrTpm
		
		Pair<ArrayList<ArrayList<String>>, ArrayList<ArrayList<Float>>> x =StableAndCurrTpm.TpmReadings();
		
		Fleet_Region    = x.getKey();
		Curr_Stable_Tpm = x.getValue();
		
	}
	
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
	
	
	public float getCapacity() {
		this.getTpmData();
		return this.compare(this.getFleet(),this.getRegion());
		
	}
	
}
