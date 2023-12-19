package com.Amazon.COP.Utils;

import java.util.ArrayList;

//This is used to identify the different fleet and region present in the Excel Sheet.
//Finally we return an ArrayList with data about the Fleet and Regions (first row has different fleets and second has different Regions)



public class FleetsAndRegions {
	
	
public ArrayList<ArrayList<String>> DiffFleetsAndRegionsInData(ArrayList<ArrayList<String>> Data){
		
		final ArrayList<ArrayList<String> > FleetAndRegion = new ArrayList<ArrayList<String> >(); //Fleet in first row and Region in secoj=nd row
		FleetAndRegion.add(new ArrayList<String>()); 
		FleetAndRegion.add(new ArrayList<String>());	//Adding two rows 
		
		int FleetNum=0;
		
		//Check whether if the Fleet/Region is already present in the ArrayList (FleetAndRegion) and add if it is not present 
		
		for(int i=1;i<Data.size();i++) {
			if(!FleetAndRegion.get(0).contains(Data.get(i).get(0).toString())) {
		
				FleetAndRegion.get(0).add(FleetNum,Data.get(i).get(0));
				FleetNum++;
			
			}
		}
		
		FleetNum=0;
		
		for(int i=1;i<Data.size();i++) {
			
			if(!FleetAndRegion.get(1).contains(Data.get(i).get(1).toString())) {
		
				FleetAndRegion.get(1).add(FleetNum,Data.get(i).get(1));
				FleetNum++;
			
			}
		}
		
		return FleetAndRegion;
	}  
	
}
