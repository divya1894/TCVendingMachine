package com.yash.casestudy.TCVendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Products {
	private Logger logger = Logger.getLogger(Products.class.getName());
	InputScanner in = new InputScanner();
	VendingMachineImpl vendingMachineImpl = new VendingMachineImpl();
	Map<String, Integer> mapOfItemAndQuantity  = new HashMap<>();
	public int getCupCount() {
		logger.info("Please enter number of cup(s) : ");
		return in.nextInt();
	}
	
	Map<String, Integer> getProductAndCupCount(String drinkType, Integer cupCount) {
		if (mapOfItemAndQuantity.containsKey(drinkType)){
			mapOfItemAndQuantity.put(drinkType, mapOfItemAndQuantity.get(drinkType) + cupCount);
			vendingMachineImpl.updateContainerAfterProductIsDispensed(drinkType,VendingMachineImpl.ingredientsMap, cupCount);
		}else
			mapOfItemAndQuantity.put(drinkType, cupCount);
			vendingMachineImpl.updateContainerAfterProductIsDispensed(drinkType,VendingMachineImpl.ingredientsMap, cupCount);
		return mapOfItemAndQuantity;
	}

	public void refillContainer(String drinkType) {	
		logger.info("Please enter refill quantity : ");
		Integer refillAmount = in.nextInt();
		
		Boolean refillStatus = VendingMachineImpl.refillContainer(drinkType, refillAmount);
		if(refillStatus) {
			logger.info("Refilled Successfully!");
			refillContainerType();
		} else {
			logger.warning("Container is full");
		}
	}
	
	public Integer refillContainerType(){
		
		Integer choice = 0; 
		
		logger.info("\nPlease select container type: ");
		logger.info("1.Water Container\n 2.Milk Container\n 3.Coffee Container\n 4.Tea Container\n 5.SugarContainer\n 6.Exit");
		
		choice = in.nextInt();
		
		switch(choice){
        case 1: 
        	refillContainer("Water");
            break; 
        case 2: 
        	refillContainer("Milk");
        	break; 
        case 3: 
        	refillContainer("Coffee");
        	break; 
        case 4: 
        	refillContainer("Tea");
        	break; 
        case 5:   	
        	refillContainer("Sugar");
        	break;
        case 6:   	
        	Products products = new Products();
        	logger.info("Thank You");
        	products.callSwitchCase();
        	System.exit(0);
        	break;
        default: 
        	logger.info("Invalid option!! Choose again."); 
        	refillContainerType();
            break; 
        } 	
		return choice;
	}
	
	public void callSwitchCase() {
		int cupCount = 0 ;
		Integer output ;

		//do{
			logger.info("\nPlease select your option :");
			logger.info("\n1.Tea \n2.Coffee \n3.Black Tea \n4.Black Coffee"
					+ "\n5.Refill Container \n6.Total Sale \n7.Container Status "
					+ "\n8.Reset Container \n9.Exit");
			output = in.nextInt();
			if(output == 1 || output == 2 || output == 3 || output ==4){
				cupCount = getCupCount();
			}
		        switch (output) { 
		        case 1: 
		        	getProductAndCupCount("Tea", cupCount);
		        	logger.info("Prepared");
		        	//vendingMachineImpl.updateContainerAfterProductIsDispensed("Tea",vendingMachineImpl.ingredientsMap, cupCount);
		            break; 
		        case 2: 
		        	getProductAndCupCount("Coffee", cupCount);			
		        	//vendingMachineImpl.updateContainerAfterProductIsDispensed("Coffee",vendingMachineImpl.ingredientsMap, cupCount);
		        	break; 
		        case 3: 
		        	getProductAndCupCount("BlackTea", cupCount);
		        	//vendingMachineImpl.updateContainerAfterProductIsDispensed("BalckTea",vendingMachineImpl.ingredientsMap, cupCount);
		        	break; 
		        case 4: 
		        	getProductAndCupCount("BlackCoffee", cupCount);
		        	//vendingMachineImpl.updateContainerAfterProductIsDispensed("BlackCoffee",vendingMachineImpl.ingredientsMap, cupCount);
		        	break; 
		        case 5:
		        	Integer containerType = refillContainerType();
		        	break;
		        case 6:
		        	vendingMachineImpl.getTeaCoffeeReportDrinkWise(mapOfItemAndQuantity);
		        	vendingMachineImpl.getTotalTeaCoffeeReport(mapOfItemAndQuantity);
		        	vendingMachineImpl.refillingCounterStatus();
		        	break;
		        case 7:
		        	vendingMachineImpl.getContainerStatus();
		        	break;
		        case 8:
		        	vendingMachineImpl.resetContainer();
		        	break;
		        case 9:
		        	logger.info("\nThank You!!");
		        	break;	
		        default: 
		        	logger.info("Invalid option!! Choose again."); 
		        	callSwitchCase();
		            break; 
		        } 
		//}while(Integer.valueOf(output) < 9);			
	}	

}

