package edu.csus.csc130.fall2016.assignment3;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;

	private class Node {
		Key key; // key
		Value val; // associated data
		Node left, right; // subtrees
		int n; // # nodes in this subtree
		boolean color; // color of link from parent to this node

		Node(Key key, Value val, int n, boolean color) {
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}
	}

	private boolean isRed(Node x) {
		if (x == null)  return false;
		return x.color == RED;
	}
	
	// get the number of nodes rooted at Node node
	private int size(Node node) {
		return (node == null ? 0: node.n);
	}	
	
	//make a right-leaning link lean to the left
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	// make a left-leaning link lean to the right
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	// flip colors to split a 4-node
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	//Search for key. Update value if found; grow table if new.
	public void put(Key key, Value val) { 
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		if (h == null)
			// Do standard insert, with red link to parent.
			return new Node(key, val, 1, RED);
		
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;
		
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);
		h.n = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }	
    
    //Q11
    public double getRedNodePercentage() {
    	throw new UnsupportedOperationException();
    }

}
