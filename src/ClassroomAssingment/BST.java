package ClassroomAssingment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value>
{
	private Node root;
	
	private class Node
	{
		private Key key;
		private Value value;
		private Node left, right;
		private int size;
		private List<Value> list;
		
		public Node(Key key, Value value, int size)
		{
			this.key = key;
			this.value = value;
			this.size = size;
			this.list = new LinkedList<>();
		}
	}
	
	public BST()
	{
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(Node root)
	{
		if (root == null) return 0;
		else return (root.size + root.list.size());
	}
	
	public List<Value> get(Key key)
	{
		return get(root, key);
	}
	
	private List<Value> get(Node root, Key key) {if (root == null) {return null;}
		
		final int result = key.compareTo(root.key);
		List<Value> list;
		if (result < 0) {return get(root.left, key);}
		else if (result > 0) {return get(root.right, key);}
		else
		{if (root.list.isEmpty()) {list = Collections.singletonList(root.value);}
		else {list = new LinkedList<>();}
		for (int i = 0; i < root.list.size(); i++) {list.add(root.list.get(i));}}
		
		return root.list;
	}
	
	
	public void put(Key key, Value val)
	{
		if (key == null) throw new IllegalArgumentException("calls put() with a null key");
		root = put(root, key, val);
		
		
	}
	
	private Node put(Node root, Key key, Value val)
	{
		if (root == null) return new Node(key, val, 1);
		int result = key.compareTo(root.key);
		if (result < 0) root.left = put(root.left, key, val);
		else if (result > 0) root.right = put(root.right, key, val);
		else root.list.add(val);
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}
	
	public int rank(Key key)
	{
		if (key == null) throw new IllegalArgumentException("argument to rank() is null");
		return rank(key, root);
	}
	
	
	private int rank(Key key, Node root)
	{
		if (root == null) return 0;
		int result = key.compareTo(root.key);
		if (result < 0) return rank(key, root.left);
		else if (result > 0) return 1 + size(root.left) + rank(key, root.right);
		else return size(root.left);
	}
}