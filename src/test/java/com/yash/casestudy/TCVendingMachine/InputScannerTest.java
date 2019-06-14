package com.yash.casestudy.TCVendingMachine;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class InputScannerTest {

	@Test
	public void getInputInteger() {

		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		InputScanner obj = new InputScanner(new Scanner(System.in));
		Integer i = obj.nextInt();

		assertEquals(new Integer(1), i);

	}
}
