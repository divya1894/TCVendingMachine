package com.yash.casestudy.TCVendingMachine;

import java.util.HashMap;
import java.util.Map;

public interface VendingMachine {

	public void updateContainerAfterProductIsDispensed(String drinkType, Map<String, ContainerDTO> getIngredients, Integer cupCount);
}
