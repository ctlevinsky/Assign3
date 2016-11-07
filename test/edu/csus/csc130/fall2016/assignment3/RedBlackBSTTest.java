package edu.csus.csc130.fall2016.assignment3;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackBSTTest {

	@Test
	public void testGetRedNodePercentage_1() {
		RedBlackBST<Character, Integer> redBlackBST= getRedBlackBST("EASYQUETION");
		double expected = 0.2;
		Assert.assertEquals(expected,  redBlackBST.getRedNodePercentage(), 0.01);
	}
	
	@Test
	public void testGetRedNodePercentage_2() {
		RedBlackBST<Character, Integer> redBlackBST= getRedBlackBST("SEARCHXMPL");
		double expected = 0.3;
		Assert.assertEquals(expected,  redBlackBST.getRedNodePercentage(), 0.01);
	}	
	
	private RedBlackBST<Character, Integer> getRedBlackBST(String s) {
		RedBlackBST<Character, Integer> redBlackBST= new RedBlackBST<Character, Integer>();	
		for (int i=0; i<s.length(); i++) {
			redBlackBST.put(s.charAt(i), i);
		}
		return redBlackBST;
	}

}
