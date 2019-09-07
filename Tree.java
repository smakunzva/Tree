


package datastractures.tree;


public class Tree {
	

	public TreeNode root;

	public void insert(int value) {

		if(root == null) {

			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	public void traverseInOrder() {
		if(root != null) {
			root.traverseInOrder();
		}
	}

	public TreeNode findValue(int value) {
		if(root == null) {
			return null;
		} else {
			return root.findValue(value);
		}
	}

	public int getMin() {
		if(root == null) {
			return -1;
		} else {
			return root.getMin();
		}
	}

	public int getMax() {
		if(root == null) {
			return -1;
		} else {
			return root.getMax();
		}
	}

	// With delete there are various scenarios you have to consider
		// 1) The node is a leaf node
		// 2) The node has one child
		// 3) The node has two children

	// When deleting a node with 2 children you need to decide whether you will find the replacement node in the right or left side of a root node
	// Once you have decided on one you must stick to it.
	// NB: When you choose the right search for the node containing the lowest value. That node will replace the deleted node, we choose the node with
	    // lowest value because all the values to it's right will be greater than it.
	    // When you choose to use the left side find a node on the left which contains the highest value and that node will replace the deleted node
		// we chose the node with highest value so that nodes on the left will all be less than the value of the replacement node
	// With this implementation we will be using the left tree to find a replacement for a deleted node
	// When we find a node that should be deleted we check the left side of the node for the node with the highest number because everything to it's left side
	// will be less therefore mantaining the binary tree principles.

	public TreeNode delete(int value) {
		root = delete(root, value);
	}


    // This method return the replacement node
	public TreeNode delete(TreeNode rootSubtree, int value) {
		// Check if the node has a left child
		// Traverse the right child nodes until you find a right node without a child node

		if(rootSubtree == null) {
			return rootSubtree;
		}

		if(rootSubtree.data > value) {
			rootSubtree.left = delete(rootSubtree.left, value);
		} else if(value > rootSubtree.data) {
			rootSubtree.right = delete(rootSubtree.right, value);
		}

		else { 

		// Means the value is equal to the root and it has a subtree
		// This caters for deleting a node with 0 or 1 child

			if(rootSubtree.left == null) {
				return rootSubtree.right;
			} else if(rootSubtree.right == null) {
				return rootSubtree.left;
			}
		}
		return rootSubtree;
	}
}