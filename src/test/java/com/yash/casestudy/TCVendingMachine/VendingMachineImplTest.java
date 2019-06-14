package com.yash.casestudy.TCVendingMachine;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineImplTest {
	
	@InjectMocks
	VendingMachineImpl vendingMachineImpl ;
	
	@Mock
	Logger logger;
	
	@Test
	public void shouldGetDrinkWiseReport(){
		Map<String, Integer> mapOfItemAndQuantity = new HashMap<>();
		mapOfItemAndQuantity.put("Tea", 5);
		Map<String, Integer> productCostMap = new HashMap<>();
		productCostMap.put("Tea", 10);
		productCostMap.put("BlackTea", 5);
		productCostMap.put("Coffee", 15);
		productCostMap.put("BlackCoffee", 10);
		vendingMachineImpl.getTeaCoffeeReportDrinkWise(mapOfItemAndQuantity);

	}

	@Test
	public void shouldGetTotalTeaCoffeeReport(){
		Map<String, Integer> mapOfItemAndQuantity = new HashMap<>();
		mapOfItemAndQuantity.put("Coffee", 5);
		Map<String, Integer> productCostMap = new HashMap<>();
		productCostMap.put("Tea", 10);
		productCostMap.put("BlackTea", 5);
		productCostMap.put("Coffee", 15);
		productCostMap.put("BlackCoffee", 10);
		vendingMachineImpl.getTotalTeaCoffeeReport(mapOfItemAndQuantity);
		
	}
	
	@Test
	public void shouldResetContainer(){
		vendingMachineImpl.resetContainer();
	}
	
	@Test
	public void shouldGetContainerStatus(){
		vendingMachineImpl.getContainerStatus();
		
	}
	
	@Test
	public void shouldGetIngredients(){
		vendingMachineImpl.getIngredients();
	}
	
	@Test
	public void shouldReturnTrueSuccessfulForMilk(){
		vendingMachineImpl.milkContainerAvailableQuantity = 2000;
		Boolean actual = vendingMachineImpl.refillContainer("Milk", 500);
		Assert.assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenSuccessfulForWater(){
		vendingMachineImpl.waterContainerAvailableQuantity = 2000;
		Boolean actual = vendingMachineImpl.refillContainer("Water", 600);
		Assert.assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueSuccessfulForSugar(){
		vendingMachineImpl.sugarContainerAvailableQuantity = 2000;
		Boolean actual = vendingMachineImpl.refillContainer("Sugar", 200);
		Assert.assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueSuccessfulForCoffee(){
		vendingMachineImpl.coffeeContainerAvailableQuantity = 1500;
		Boolean actual = vendingMachineImpl.refillContainer("Coffee", 200);
		Assert.assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenSuccessfulForTea(){
		vendingMachineImpl.teaContainerAvailableQuantity = 1400;
		Boolean actual = vendingMachineImpl.refillContainer("Tea", 200);
		Assert.assertTrue(actual);
	}
	
	@Test
	public void shouldReturnFalseWhenIfContainerIsAlreadyFilled(){
		vendingMachineImpl.teaContainerAvailableQuantity = 2000;
		Boolean actual = vendingMachineImpl.refillContainer("Tea", 200);
		Assert.assertFalse(actual);
	}
	
	@Test
	public void shouldCallupdateContainerAfterProductIsDispensed(){
		vendingMachineImpl.updateContainerAfterProductIsDispensed("Tea", vendingMachineImpl.ingredientsMap, 5);
	}
	
	@Test
	public void shouldGetRefillingCounterStatus(){
		vendingMachineImpl.refillingCounterStatus();
		
		//verify(logger, times(4)).info(anyString());
	}
}
