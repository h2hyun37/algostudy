package xenomity.examination.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import xenomity.examination.tree.structure.BinaryTree;
import xenomity.examination.tree.structure.TreeNode;

/**
 * Binary Search Tree Test
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class BST {
	
	private static final int[] SOURCE = new int[] { 30, 20, 40, 10, 25, 35, 45 };
	
	private BinaryTree rootNode;

	@Before
	public void setUp() throws IllegalAccessException {
		rootNode = new BinaryTree(SOURCE[0]);
		BinaryTree depth1_1 = new BinaryTree(SOURCE[1]);
		BinaryTree depth1_2 = new BinaryTree(SOURCE[2]);
		
		rootNode.setChild(depth1_1, BinaryTree.LEFT_NODE);
		rootNode.setChild(depth1_2, BinaryTree.RIGHT_NODE);
		depth1_1.setChild(new BinaryTree(SOURCE[3]), BinaryTree.LEFT_NODE);
		depth1_1.setChild(new BinaryTree(SOURCE[4]), BinaryTree.RIGHT_NODE);
		depth1_2.setChild(new BinaryTree(SOURCE[5]), BinaryTree.LEFT_NODE);
		depth1_2.setChild(new BinaryTree(SOURCE[6]), BinaryTree.RIGHT_NODE);
		
		// debug
		System.out.println("Initialized: " + BinaryTree.toString(rootNode));
	}
	
	@Test
	public void add(BinaryTree tree, int value) {
		// TODO: later
	}
	
	@Test
	public void remove(BinaryTree tree, int value) {
		// TODO: later
	}
	
	@Test
	public void search() {
		int searchValue = 35;
		
		System.out.print("Search ");
		Assert.assertTrue(search(rootNode, searchValue));
	}
	
	private boolean search(TreeNode<Integer> treeNode, int value) {
		System.out.printf("=> %d ", treeNode.getNodeValue());
		
		if (treeNode.getNodeValue() == value) {
			return true;
		} else if (!treeNode.isLeaf()) {
			TreeNode<Integer> leftChildNode = treeNode.getChild(0);
			TreeNode<Integer> rightChildNode = treeNode.getChild(1);
			
			if (leftChildNode != null && treeNode.getNodeValue() > value) {
				return search(leftChildNode, value);
			} else if (rightChildNode != null && treeNode.getNodeValue() < value) {
				return search(rightChildNode, value);
			}
		}
		
		return false;
	}
	
}
