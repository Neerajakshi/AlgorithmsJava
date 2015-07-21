package com.acs;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;

public class AircraftQManager {
	
	private static AircraftQManager 	objAirCraftQManager;
	private static PriorityQueue<Aircraft> 	objACList;  		
	

	public AircraftQManager(){

		try {
			objACList = new PriorityQueue<Aircraft>(ACSConstants.QUEUE_SIZE);
		} catch (Exception e) {
			System.out.println("Initialization Error");
			
		}		
	}

	
	/**
	 * This method inserts the Aircraft object into Queue
	 * @param airCraft
	 */
	public void enqueueAC(Aircraft airCraft){
		objACList.add(airCraft);
	}
	/**
	 * This method removes and returns the Aircraft object which has highest priority.
	 * @return
	 */
	public Aircraft dequeueAC(){
		Aircraft ac=null;		
		ac = objACList.remove();		
		return ac;
	}
	
	/**
	 * Displays the Aircraft object which are currently stored in the Queue.
	 */
	public void displayPriorityQueue(){
		int i=1;
		Object pqArray[] = objACList.toArray();
		Arrays.sort(pqArray);
		System.out.println("Aicrafts Objects in the priority Queue");
		for(Object ac : pqArray){
			System.out.println(i+"."+ac);
			i++;
		}
	}	
	
	
}
