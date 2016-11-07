package edu.csus.csc130.fall2016.assignment3;

import org.junit.Assert;
import org.junit.Test;

public class STClientTest {

	@Test
	public void testGetAverage_1() {
		String[] grades = {"A", "B", "C", "D"};
		double expected = 2.5;
		Assert.assertEquals(expected,  STClient.getAverage(grades), 0.01);
	}
	
	@Test
	public void testGetAverage_2() {
		String[] grades = {"A+", "B+", "C+", "D+"};
		double expected = 3.33;
		Assert.assertEquals(expected,  STClient.getAverage(grades), 0.01);
	}	

}
