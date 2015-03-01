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
	public TreeNode<Integer> add(TreeNode<Integer> treeNode, int value) {
		if (treeNode.getNodeValue() == null) {
			treeNode.setNodeValue(value);
			
			return treeNode;
		}
		
		if (value < treeNode.getNodeValue()) {
			return add(treeNode.getChild(BinaryTree.LEFT_NODE), value);
		} else {
			return add(treeNode.getChild(BinaryTree.RIGHT_NODE), value);
		}
	}
	
	@Test
	public void remove(BinaryTree treeNode, int value) throws IllegalAccessException {
		BinaryTree parentTree = (BinaryTree) treeNode.getParent();
		
		if (treeNode.isLeaf()) {
			parentTree.removeChild(treeNode);
		} else if (treeNode.getChild(BinaryTree.LEFT_NODE).getNodeValue() != null
				|| treeNode.getChild(BinaryTree.RIGHT_NODE).getNodeValue() != null) {
			BinaryTree childNode = treeNode.getChild(BinaryTree.LEFT_NODE).getNodeValue() != null
					? (BinaryTree) treeNode.getChild(BinaryTree.LEFT_NODE)
					: (BinaryTree) treeNode.getChild(BinaryTree.RIGHT_NODE);
			
			int childIndex = parentTree.contain(childNode);
			parentTree.setChild(childNode, childIndex);
		} else {
			BinaryTree leftChildNode = (BinaryTree) treeNode.getChild(BinaryTree.LEFT_NODE);
			BinaryTree rightChildNode = (BinaryTree) treeNode.getChild(BinaryTree.RIGHT_NODE);
			BinaryTree parentNode = (BinaryTree) treeNode.getParent();
			int targetNodeIndex = parentNode.contain(treeNode);
			
			// TODO: 직후 원소 찾기.
			BinaryTree replaceNode = parentTree;
			BinaryTree replaceChildNode = (BinaryTree) replaceNode.getChild(BinaryTree.RIGHT_NODE);
			BinaryTree replaceParentNode = (BinaryTree) replaceNode.getParent();
			
			// replace
			parentNode.setChild(replaceNode, targetNodeIndex);
			replaceNode.setChild(leftChildNode, BinaryTree.LEFT_NODE);
			replaceNode.setChild(rightChildNode, BinaryTree.RIGHT_NODE);
			replaceParentNode.setChild(replaceChildNode, BinaryTree.RIGHT_NODE);
		}
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
			TreeNode<Integer> leftChildNode = treeNode.getChild(BinaryTree.LEFT_NODE);
			TreeNode<Integer> rightChildNode = treeNode.getChild(BinaryTree.RIGHT_NODE);
			
			if (leftChildNode != null && treeNode.getNodeValue() > value) {
				return search(leftChildNode, value);
			} else if (rightChildNode != null && treeNode.getNodeValue() < value) {
				return search(rightChildNode, value);
			}
		}
		
		return false;
	}
	
}
