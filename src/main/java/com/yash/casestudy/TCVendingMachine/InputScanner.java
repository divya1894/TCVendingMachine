package com.yash.casestudy.TCVendingMachine;

import java.util.Scanner;

public class InputScanner {

	private final Scanner in;

	public InputScanner() {
		this.in = new Scanner(System.in);
	}
	
	public InputScanner(Scanner in) {
		super();
		this.in = in;
	}

	public int nextInt() {
		return in.nextInt();		
	}
	
}
