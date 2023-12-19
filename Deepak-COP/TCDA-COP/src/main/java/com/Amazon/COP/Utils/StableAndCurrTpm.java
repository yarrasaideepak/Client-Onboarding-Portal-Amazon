package com.Amazon.COP.Utils;

import java.util.ArrayList;

import com.Amazon.COP.model.ReadTheData;

import javafx.util.Pair; 

//This is used to return two arraylists one has the details about Fleet,Region and Stable,Current TPM
// This class is used to refine the data we get from the table and find the corresponding Stable and Current TPM


public class StableAndCurrTpm {

public final class Consts {

	public static final int DefTpm = 5000;			//Value to be considered if TPM value is not present (i.e., NULL) 

}

public static Pair<ArrayList<ArrayList<String>>,ArrayList<ArrayList<Float>>> TpmReadings () {
		
		ReadTheData t = new ReadTheData();
		
		int FleetCol = 0;		// Column numbers in Excel Sheet that has data of Fleet name
		int RegCol = 1;			// Column numbers in Excel Sheet that has data of Region name
		int HostCol = 2;		// Column numbers in Excel Sheet that has data of NumberOfHost
		int CurrTpsCol = 3;  	// Column numbers in Excel Sheet that has data of CurrTps 
		int StableTpmcolu = 4; 	// Column numbers in Excel Sheet that has data of StableTPM
		
		ArrayList<ArrayList<String>> Data = t.DataSet();  // Reading .xlsx file
		
		FleetsAndRegions FleetRegion= new FleetsAndRegions();
		
		//For Getting the Different types of fleets and Regions Present in the given FIle
		
		ArrayList<ArrayList<String>> FleetAndRegion1 = FleetRegion.DiffFleetsAndRegionsInData(Data); 
		
		int NumOfFleet=FleetAndRegion1.get(0).size();	//Number of Fleets
		int NumOfRegions=FleetAndRegion1.get(1).size();	//Number of Regions
		int NumOfRows=Data.size();						//Number of rows in the .xlsx file
		
		
		ArrayList<ArrayList<String>> Fleet_Region = new ArrayList<ArrayList<String>> ();
		ArrayList<ArrayList<Float>> Curr_Stable_Tpm = new ArrayList<ArrayList<Float>>();
		
		Fleet_Region.add(new ArrayList<String>());Fleet_Region.add(new ArrayList<String>());  		//Adding two rows
		Curr_Stable_Tpm.add(new ArrayList<Float>());Curr_Stable_Tpm.add(new ArrayList<Float>());	//Adding two rows
		
		
		for(int i=1; i<NumOfRows ;i++) {
			
			float CurrTpmPerFleet = Integer.parseInt(Data.get(i).get(CurrTpsCol))*60;	//Add.SumOfNumbers convert string to float ("20+ 78" to 98)
			float StableTpmPerFleet;
			
			//If the TPM is not present we give an default value (5000 TPM)
			
			if(Data.get(i).get(StableTpmcolu)==null) {	
				StableTpmPerFleet=Consts.DefTpm*(Integer.parseInt(Data.get(i).get(HostCol)));
			}
			else {
				StableTpmPerFleet = (Integer.parseInt(Data.get(i).get(StableTpmcolu)))*(Integer.parseInt(Data.get(i).get(HostCol)));
			}
			
			// Adding values into the ArrayLists Fleet_Region and Curr_Stable_Tpm
			
			for(int j=0;j<NumOfFleet;j++) {
				
				if(Data.get(i).get(FleetCol).equals(FleetAndRegion1.get(0).get(j))) {
					
					for(int p=0;p<NumOfRegions;p++) {
						
						if(Data.get(i).get(RegCol).equals(FleetAndRegion1.get(1).get(p))) {
						
							Fleet_Region.get(0).add(Data.get(i).get(FleetCol).toString());Fleet_Region.get(1).add(Data.get(i).get(RegCol).toString());
							Curr_Stable_Tpm.get(0).add(CurrTpmPerFleet);Curr_Stable_Tpm.get(1).add(StableTpmPerFleet);
							
						}
					}
				}
			}
		}
		
		// Returning a pair of Arraylists
		return new Pair<ArrayList<ArrayList<String>>,ArrayList<ArrayList<Float>>> (Fleet_Region,Curr_Stable_Tpm);
		
		
		}

}
