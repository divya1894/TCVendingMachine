package com.yash.casestudy.TCVendingMachine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class VendingMachineImpl implements VendingMachine {
	
	private Logger logger = Logger.getLogger(VendingMachineImpl.class.getName());
	static Map<String,ContainerDTO> ingredientsMap = new HashMap<>();
	InputScanner in;
	
	public static Integer refillCounterForTeaContainer = 0;
	public static Integer refillCounterForCoffeeContainer = 0;
	public static Integer refillCounterForSugarContainer = 0;
	public static Integer refillCounterForWaterContainer = 0;
	public static Integer refillCounterForMilkContainer = 0;
	
	public static final Integer teaContainerCapacity = 2000;
	public static final Integer coffeeContainerCapacity = 2000;
	public static final Integer sugarContainerCapacity = 8000;
	public static final Integer waterContainerCapacity = 15000;
	public static final Integer milkContainerCapacity = 10000;
	
	public static Integer teaContainerAvailableQuantity = 2000;
	public static Integer coffeeContainerAvailableQuantity = 2000;
	public static Integer sugarContainerAvailableQuantity = 8000;
	public static Integer waterContainerAvailableQuantity = 15000;
	public static Integer milkContainerAvailableQuantity = 10000;
	
	static Map<String, ContainerDTO> getIngredients() {			
		
		ContainerDTO teaIngredients = new ContainerDTO(6,0,65,44,17);
		ingredientsMap.put("Tea",teaIngredients);
		
		ContainerDTO coffeeIngredients = new ContainerDTO(0,5,23,88,17);
		ingredientsMap.put("Coffee",coffeeIngredients);
		
		ContainerDTO blackTeaIngredients = new ContainerDTO(3,0,112,0,17);
		ingredientsMap.put("BlackTea",blackTeaIngredients);
		
		ContainerDTO blackCoffeeIngredients = new ContainerDTO(0,3,112,0,17);
		ingredientsMap.put("BlackCoffee",blackCoffeeIngredients);
				
		return ingredientsMap;
	}
	
	Map<String, Integer> getProductAndCost() {
		Map<String, Integer> productCost = new HashMap<>();
		
		productCost.put("Tea", 10);
		productCost.put("Coffee", 15);
		productCost.put("Black Tea", 5);
		productCost.put("Black Coffee", 10);

		return productCost;
	}
	
	public void getTeaCoffeeReportDrinkWise(Map<String, Integer> mapOfItemAndQuantity){
		Map<String, Integer> productCostMap = getProductAndCost();
		if (!mapOfItemAndQuantity.isEmpty()) {
			logger.info("Drink wise :");
			for (Map.Entry<String, Integer> map : mapOfItemAndQuantity.entrySet()) {
				if(productCostMap.containsKey(map.getKey())){
					logger.info(map.getKey()+"   "+map.getValue()+"   "+productCostMap.get(map.getKey())*map.getValue());					
				}
			}
		}
	}

	public void getTotalTeaCoffeeReport(Map<String, Integer> mapOfItemAndQuantity) {
		Integer cupCount = 0;
		Integer totalSale = 0;
		Map<String, Integer> productCostMap = getProductAndCost();
		if (!mapOfItemAndQuantity.isEmpty()) {
			for (Map.Entry<String, Integer> map : mapOfItemAndQuantity.entrySet()) {
				cupCount = cupCount + map.getValue();
				if(productCostMap.containsKey(map.getKey())){
					totalSale = totalSale + productCostMap.get(map.getKey())*map.getValue();				
				}
			}
			logger.info("Total cups: "+cupCount + "\nTotal cost: "+totalSale);
		}
	}
	
	public static boolean refillContainer(String drinkType, Integer refillAmount) {		
		Boolean refillStatus = false;
		
		if(drinkType.equals("Milk")){
			if(VendingMachineImpl.milkContainerCapacity - VendingMachineImpl.milkContainerAvailableQuantity >= refillAmount){
				VendingMachineImpl.milkContainerAvailableQuantity += refillAmount;
				VendingMachineImpl.refillCounterForMilkContainer++;
				refillStatus = true;
			}
				
		} 
		
		if(drinkType.equals("Water")){
			if(VendingMachineImpl.waterContainerCapacity - VendingMachineImpl.waterContainerAvailableQuantity >= refillAmount){
				VendingMachineImpl.waterContainerAvailableQuantity += refillAmount; 
				VendingMachineImpl.refillCounterForWaterContainer++;
				refillStatus = true;
			}
				
		}
		
		if(drinkType.equals("Sugar")){
			if(VendingMachineImpl.sugarContainerCapacity - VendingMachineImpl.sugarContainerAvailableQuantity >= refillAmount){
				VendingMachineImpl.sugarContainerAvailableQuantity += refillAmount;
				VendingMachineImpl.refillCounterForSugarContainer++;
				refillStatus = true;
			}
		}
		
		if(drinkType.equals("Coffee")){
			if(VendingMachineImpl.coffeeContainerCapacity - VendingMachineImpl.coffeeContainerAvailableQuantity >= refillAmount){
				VendingMachineImpl.coffeeContainerAvailableQuantity += refillAmount; 
				VendingMachineImpl.refillCounterForCoffeeContainer++;
				refillStatus = true;
			}
		}
		
		if(drinkType.equals("Tea")){
			if(VendingMachineImpl.teaContainerCapacity - VendingMachineImpl.teaContainerAvailableQuantity >= refillAmount){
				VendingMachineImpl.teaContainerAvailableQuantity += refillAmount; 
				VendingMachineImpl.refillCounterForTeaContainer++;
				refillStatus = true;
			}
		}
		return refillStatus;		
	}
	
	public void refillingCounterStatus() {
		logger.info("Tea container Status: "+VendingMachineImpl.refillCounterForTeaContainer);
		logger.info("Water container Status: "+VendingMachineImpl.refillCounterForWaterContainer);
		logger.info("Sugar container Status: "+VendingMachineImpl.refillCounterForSugarContainer);
		logger.info("Coffee container Status: "+VendingMachineImpl.refillCounterForCoffeeContainer);
		logger.info("Milk container Status: "+VendingMachineImpl.refillCounterForMilkContainer);

	}
	
	public void getContainerStatus() {
		logger.info("Tea Container : "+VendingMachineImpl.teaContainerAvailableQuantity);
		logger.info("Coffee Container : "+VendingMachineImpl.coffeeContainerAvailableQuantity);
		logger.info("Sugar Container : "+VendingMachineImpl.sugarContainerAvailableQuantity);
		logger.info("Water Container : "+VendingMachineImpl.waterContainerAvailableQuantity);
		logger.info("Milk Container : "+VendingMachineImpl.milkContainerAvailableQuantity);
	}
	
	@Override
	public void updateContainerAfterProductIsDispensed(String drinkType, Map<String, ContainerDTO> getIngredients, Integer cupCount) {
		Map<String, ContainerDTO> mapOfIngredients = getIngredients();
		VendingMachineImpl.teaContainerAvailableQuantity = teaContainerQuantity(drinkType,mapOfIngredients,cupCount);
		VendingMachineImpl.waterContainerAvailableQuantity = waterContainerQuantity(drinkType,mapOfIngredients,cupCount);
		VendingMachineImpl.sugarContainerAvailableQuantity = sugarContainerQuantity(drinkType,mapOfIngredients,cupCount);
		VendingMachineImpl.milkContainerAvailableQuantity = milkContainerQuantity(drinkType,mapOfIngredients,cupCount);
		VendingMachineImpl.coffeeContainerAvailableQuantity = coffeeContainerQuantity(drinkType,mapOfIngredients,cupCount);
	}
	
	public void resetContainer(){
		VendingMachineImpl.teaContainerAvailableQuantity = teaContainerCapacity;
		VendingMachineImpl.coffeeContainerAvailableQuantity = coffeeContainerCapacity;
		VendingMachineImpl.waterContainerAvailableQuantity = waterContainerCapacity;
		VendingMachineImpl.milkContainerAvailableQuantity=milkContainerCapacity;
		VendingMachineImpl.sugarContainerAvailableQuantity=sugarContainerCapacity;
	}

	private Integer teaContainerQuantity(String drinkType,Map<String, ContainerDTO> mapOfIngredients, Integer cupCount){
		return VendingMachineImpl.teaContainerAvailableQuantity -   Optional.ofNullable(mapOfIngredients.get(drinkType).getTea()).orElse(0)*cupCount;
	}
	private Integer waterContainerQuantity(String drinkType,Map<String, ContainerDTO> mapOfIngredients, Integer cupCount){
		return VendingMachineImpl.waterContainerAvailableQuantity -  Optional.ofNullable(mapOfIngredients.get(drinkType).getWater()).orElse(0)*cupCount;
	}
	private Integer sugarContainerQuantity(String drinkType,Map<String, ContainerDTO> mapOfIngredients, Integer cupCount){
		return VendingMachineImpl.sugarContainerAvailableQuantity -  Optional.ofNullable(mapOfIngredients.get(drinkType).getSugar()).orElse(0)*cupCount;
	}
	private Integer milkContainerQuantity(String drinkType,Map<String, ContainerDTO> mapOfIngredients, Integer cupCount){
		return VendingMachineImpl.milkContainerAvailableQuantity -  Optional.ofNullable(mapOfIngredients.get(drinkType).getMilk()).orElse(0)*cupCount;
	}
	private Integer coffeeContainerQuantity(String drinkType,Map<String, ContainerDTO> mapOfIngredients, Integer cupCount){
		return VendingMachineImpl.coffeeContainerAvailableQuantity -  Optional.ofNullable(mapOfIngredients.get(drinkType).getCoffee()).orElse(0)*cupCount;
	}

}
