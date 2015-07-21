package com.acs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ControlSystemMain {
	BufferedReader 		objBR; 				
	AircraftQManager 	objAqManager;	
	
	
	public ControlSystemMain(){
		objBR					= new BufferedReader(new InputStreamReader(System.in));
		objAqManager 			= new AircraftQManager();
	}

	public static void main(String args[]) {
		
		new ControlSystemMain().run();

	}
	
	
	public void printMenu(){
		System.out.print("1. Display AC Queue" + ACSConstants.newLine()
						+"2. Insert the Queue" + ACSConstants.newLine()
						+"3. Delete the Queue" + ACSConstants.newLine()
						+"4. Exit" + ACSConstants.newLine());
	}
	
	public void run(){
		int option;
		Aircraft ac;

		while(true){
			printMenu();
			try {
				option = Integer.parseInt(objBR.readLine());

				switch(option){

				case 1:
					objAqManager.displayPriorityQueue();
					break;

				case 2:					
					String name;
					int type;
					int size;
					System.out.print("Enter Aircraft name : ");
					name = objBR.readLine();	
					System.out.print("Enter Type of Aircraft (Passenger - "+ACSConstants.TYPE_PASSANGER+" , Cargo - "+ACSConstants.TYPE_CARGO+") : ");
					type = Integer.parseInt(objBR.readLine());
					System.out.print("Type of Aircraft (Big - "+ACSConstants.SIZE_LARGE+" , Small - "+ACSConstants.SIZE_SMALL+") : ");
					size = Integer.parseInt(objBR.readLine());
					if(type<1 || type>2){
						System.out.println("Please enter valid type");
						break;
					}
					if(size<1 || size>2){
						System.out.println("Please enter valid size");
						break;
					}
					
					ac= new Aircraft(name,type,size);
					objAqManager.enqueueAC(ac);				
					
					
						break;

				case 3:	
					ac = objAqManager.dequeueAC();
					break;

				case 4:										
					System.out.println("Exit....");
					System.exit(0);						
					break;

				default:
					System.out.println("Please enter valid option");
					break;
				}

			} catch (NumberFormatException e) {

				System.out.println("Please enter valid number");

			} catch (IOException e) {

				System.err.println("Error in reading data from console");
			}
		}
	}

}
