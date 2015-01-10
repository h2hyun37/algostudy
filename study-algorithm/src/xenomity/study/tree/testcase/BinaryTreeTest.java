package xenomity.study.tree.testcase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import xenomity.study.tree.BinaryTree;
import xenomity.study.tree.TreeNode;
import xenomity.study.tree.accessor.BinaryTreeAccessor;
import xenomity.study.tree.accessor.TreeAccessor;

/**
 * Binary Tree Test
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 13.
 *
 */
public class BinaryTreeTest {

	private static final int[] SOURCE = new int[] { 20, 40, 10, 25, 35, 45 };
	private final TreeAccessor<Integer> treeAccessor = BinaryTreeAccessor.getInstance();
	private final TreeNode<Integer> rootTreeNode = new BinaryTree(30);
	
	@Before
	public void setUp() {
		for (int value : SOURCE) {
			treeAccessor.add(rootTreeNode, value);
		}
		
		System.out.println(treeAccessor.toString(rootTreeNode));
	}
	
	@Test
	public void test_검색() {
		TreeNode<Integer> searchedNode = treeAccessor.search(rootTreeNode, 35);
		
		Assert.assertEquals(searchedNode.getNodeValue(), Integer.valueOf(35));
	}
	
}
