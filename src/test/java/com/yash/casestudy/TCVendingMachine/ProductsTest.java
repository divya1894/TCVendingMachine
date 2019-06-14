package com.yash.casestudy.TCVendingMachine;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductsTest {
	
	@InjectMocks
	Products products;
	
	@Mock
	InputScanner in;
	
	@Mock
	VendingMachineImpl vendingMachineImpl;
	
	@Mock
	Logger logger;
		
	@Test
	public void shouldReturnCupCountIfChoiceIsAnyDrink(){
		when(in.nextInt()).thenReturn(2);
		doNothing().when(logger).info(anyString());
		int actualResult = products.getCupCount();
		
		assertEquals(2, actualResult);
		verify(logger, times(1)).info(anyString());
	}
	
	@Test
	public void shouldGetProductAndCupCount(){
		Map<String, Integer> expectedMap = new HashMap<>();
		expectedMap.put("Tea", 1);
		Map<String, Integer> actualMap = products.getProductAndCupCount("Tea", 1);
		
		assertEquals(expectedMap.size(), actualMap.size());
	}

	@Test
	public void shouldCallGetSwitchCaseWithTea(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(1,2);
		products.callSwitchCase();
		verify(logger, times(4)).info(anyString());
	}
	
	@Test
	public void shouldCallGetSwitchCaseWithCoffee(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(2);
		products.callSwitchCase();
		verify(logger, times(3)).info(anyString());
	}
		
	@Test
	public void shouldCallGetSwitchCaseWithBlackTea(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(3);
		products.callSwitchCase();
		verify(logger, times(3)).info(anyString());
	}
	
	@Test
	public void shouldCallGetSwitchCaseWithBlackCoffee(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(4);
		products.callSwitchCase();
		verify(logger, times(3)).info(anyString());
	}
	
	@Test
	public void shouldCallSwitchcaseToRefill(){
		when(in.nextInt()).thenReturn(5,2,100);
		doNothing().when(logger).info(anyString());
		products.callSwitchCase();
		verify(logger, times(5)).info(anyString());
	}
	
	@Test
	public void shouldGetReportDrinkWise(){
		when(in.nextInt()).thenReturn(6);
		doNothing().when(vendingMachineImpl).getTeaCoffeeReportDrinkWise(Mockito.anyMap());
		products.callSwitchCase();
		
		verify(vendingMachineImpl).getTeaCoffeeReportDrinkWise(Mockito.anyMap());
	}

	@Test
	public void shouldGetReportForTotalSale(){
		when(in.nextInt()).thenReturn(6);
		doNothing().when(vendingMachineImpl).getTotalTeaCoffeeReport(Mockito.anyMap());
		 products.callSwitchCase();
		verify(vendingMachineImpl).getTotalTeaCoffeeReport(Mockito.anyMap());
	}

	@Test
	public void shouldCallGetContainerStatus(){
		when(in.nextInt()).thenReturn(7);
		doNothing().when(logger).info(anyString());
		doNothing().when(vendingMachineImpl).getContainerStatus();
		products.callSwitchCase();
		verify(logger, times(2)).info(anyString());
	}
	
	@Test
	public void shouldCallSwitchCaseToResetContainer(){
		when(in.nextInt()).thenReturn(8);
		doNothing().when(vendingMachineImpl).resetContainer();
		products.callSwitchCase();
	}

	
	@Test
	public void shouldExit(){
		when(in.nextInt()).thenReturn(9);
		products.callSwitchCase();
	}
	
	@Test
	public void shouldReturnValidOptionForRefillContainer(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(2,100);
		Integer actual = products.refillContainerType();
		assertEquals(new Integer(2), actual);
		
		verify(logger, times(3)).info(anyString());
	}
	
	@Test
	public void shouldReturnInvalidOptionMessageForRefillContainer(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(6,100);
		products.callSwitchCase();
		verify(in, times(1)).nextInt();
		verify(logger, times(2)).info(anyString());
	}
	
	@Test
	public void shouldgetContainerStatus(){
		doNothing().when(logger).info(anyString());
		when(in.nextInt()).thenReturn(6);
		doNothing().when(vendingMachineImpl).refillingCounterStatus();
		products.callSwitchCase();
		
		verify(logger, times(2)).info(anyString());
	}
	
}
