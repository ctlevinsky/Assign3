package edu.csus.csc130.fall2016.assignment3;

import org.junit.Assert;
import org.junit.Test;

public class BSTTest {

	@Test
	public void testFloorI_1() {
		BST<Character, Integer> bst = getBST();
		Character expected = 'Q';
		Assert.assertEquals(expected, bst.floorI('Q'));
	}
	
	@Test
	public void testFloorI_2() {
		BST<Character, Integer> bst = getBST();
		Character expected = 'M';
		Assert.assertEquals(expected, bst.floorI('P'));
	}	
	
	private BST<Character, Integer> getBST() {
		BST<Character, Integer> bst = new BST<Character, Integer>();
		bst.put('E', 0);
		bst.put('D', 1);
		bst.put('A', 2);
		bst.put('Q', 3);
		bst.put('J', 4);
		bst.put('M', 5);
		bst.put('T', 6);
		bst.put('S', 7);
		return bst;
	}

}
