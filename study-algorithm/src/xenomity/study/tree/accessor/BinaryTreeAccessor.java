package xenomity.study.tree.accessor;

import xenomity.study.tree.BinaryTree;
import xenomity.study.tree.TreeNode;

/**
 * Binary Tree Accessor
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 14.
 *
 */
public final class BinaryTreeAccessor implements TreeAccessor<Integer> {
	
	private static final BinaryTreeAccessor INSTANCE = new BinaryTreeAccessor();
	
	// The Constructor
	private BinaryTreeAccessor() {}
	
	/**
	 * Get Instance
	 * 
	 * @return BinaryTreeAccessor instance
	 */
	public static BinaryTreeAccessor getInstance() {
		return INSTANCE;
	}
	
	@Override
	public TreeNode<Integer> search(TreeNode<Integer> treeNode, Integer target) {
		if (treeNode == null || treeNode.getNodeValue().equals(target)) {
			return treeNode;
		}
		
		if (target < treeNode.getNodeValue()) {
			return search(treeNode.getChild(BinaryTree.LEFT_NODE), target);
		} else {
			return search(treeNode.getChild(BinaryTree.RIGHT_NODE), target);
		}
	}

	@Override
	public TreeNode<Integer> add(TreeNode<Integer> treeNode, Integer target) {
		if (treeNode.getNodeValue() == null) {
			treeNode.setNodeValue(target);
			
			return treeNode;
		}
		
		if (target < treeNode.getNodeValue()) {
			return add(treeNode.getChild(BinaryTree.LEFT_NODE), target);
		} else {
			return add(treeNode.getChild(BinaryTree.RIGHT_NODE), target);
		}
	}

	@Override
	public void remove(TreeNode<Integer> treeNode, Integer target) throws IllegalAccessException {
		BinaryTree targetNode = (BinaryTree) search(treeNode, target);
		
		if (targetNode.isRoot()) {
			throw new IllegalAccessException("target node is root.");
		}
		
		BinaryTree parentTree = (BinaryTree) targetNode.getParent();
		
		if (targetNode.isLeaf()) {
			parentTree.removeChild(targetNode);
		} else if (targetNode.getChild(BinaryTree.LEFT_NODE).getNodeValue() != null
				|| targetNode.getChild(BinaryTree.RIGHT_NODE).getNodeValue() != null) {
			BinaryTree childNode = targetNode.getChild(BinaryTree.LEFT_NODE).getNodeValue() != null
					? (BinaryTree) targetNode.getChild(BinaryTree.LEFT_NODE)
					: (BinaryTree) targetNode.getChild(BinaryTree.RIGHT_NODE);
			
			int childIndex = parentTree.contain(childNode);
			parentTree.setChild(childNode, childIndex);
		} else {
			BinaryTree leftChildNode = (BinaryTree) targetNode.getChild(BinaryTree.LEFT_NODE);
			BinaryTree rightChildNode = (BinaryTree) targetNode.getChild(BinaryTree.RIGHT_NODE);
			BinaryTree parentNode = (BinaryTree) targetNode.getParent();
			int targetNodeIndex = parentNode.contain(targetNode);
			
			// TODO: 직후 원소 찾기.
			BinaryTree replaceNode = null;
			BinaryTree replaceChildNode = (BinaryTree) replaceNode.getChild(BinaryTree.RIGHT_NODE);
			BinaryTree replaceParentNode = (BinaryTree) replaceNode.getParent();
			
			// replace
			parentNode.setChild(replaceNode, targetNodeIndex);
			replaceNode.setChild(leftChildNode, BinaryTree.LEFT_NODE);
			replaceNode.setChild(rightChildNode, BinaryTree.RIGHT_NODE);
			replaceParentNode.setChild(replaceChildNode, BinaryTree.RIGHT_NODE);
		}
	}
	
	@Override
	public String toString(TreeNode<Integer> treeNode) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(treeNode.toString());
		buffer.append(" ");
		
		if (treeNode.getChild(BinaryTree.LEFT_NODE) != null) {
			buffer.append(toString(treeNode.getChild(BinaryTree.LEFT_NODE)));
		}
		
		if (treeNode.getChild(BinaryTree.RIGHT_NODE) != null) {
			buffer.append(toString(treeNode.getChild(BinaryTree.RIGHT_NODE)));
		}
		
		return buffer.toString();
	}

}
