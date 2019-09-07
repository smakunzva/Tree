



package datastractures.tree;


public class TreeNode {
	
	public int data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int myvalue) {
		this.data = myvalue;
	}

	public void insert(int value) {

		// Simple tree that will not allow adding duplicate values
		if(value == data) {
			return;
		}

		// If value is less than current node data then it is a left child
		if(value < data) {

			if(left == null) {
				left = new TreeNode(value);
			} else {
			 left.insert(value);
			}
		} else { // value is greater than data therefore it's in the right side

			if(right == null) {
				right = new TreeNode(value);
			} else {
				right.insert(value);
			}

		}


	}


	// Getting the min value is simple. We traverse the left child and if it doesnt have a left child then we return that value
	public int getMin() {
		if(left == null) {
			return data;
		} else { 
			return left.getMin();
		}
	}

	// Getting the max value is similar to min
	public int getMax() {
		if(right == null) {
			return data;
		} else {
			return right.getMax();
		}
	}


    // Perform similar action to the insert where you compare the node to the value and traverse either left or right child
	public TreeNode findValue(int value) {

		if(value == data) {
			return this;
		}

		if(value < data) {
			if(left != null) {
				return left.findValue(value);
			}
		} else {
			if(right != null) {
				return right.findValue(value);
			}
		}

		return null;
	}


	public void traverseInOrder() {
		// Inorder traversal visits the child left node first then the root node, then the right child node
		// In other words if the tree has digits they are returned in sorted order

		if(left != null) {
			left.traverseInOrder();
		}

		System.out.println(data);

		if(right != null) {
			right.traverseInOrder();
		}
	}


	@Override
	public String toString() {
		return "Data : " + data + " right" + right;
	}
}