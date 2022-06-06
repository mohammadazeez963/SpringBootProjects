package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.zensar.bean.SimpleCaluculator;

public class SimpleCaluculatorTester {
	
		@Test
		public void testAdd() {
			SimpleCaluculator simple = new SimpleCaluculator();
			int expected = 10;
			int actual = simple.add(6,4);
			assertEquals(expected, actual);
			simple = null;
		}
		
		@Test
		public void testSubtract() {
			SimpleCaluculator simple = new SimpleCaluculator();
			int expected = 2;
			int actual = simple.subtract(5, 3);
			assertEquals(expected, actual);
			simple = null;
		}
		
		@Test
		public void testMultiply() {
			SimpleCaluculator simple = new SimpleCaluculator();
			int expected = 20;
			int actual = simple.multiply(4, 5);
			assertEquals(expected, actual);
			simple = null;
		}
		
		@Test
		public void testDivision(){
			SimpleCaluculator simple = new SimpleCaluculator();
			int expected = 2;
			int actual = simple.divide(6, 3);
			assertEquals(expected, actual);
			simple = null;
		}
}
