package xenomity.study.tree.accessor;

import xenomity.study.tree.TreeNode;

/**
 * Tree Accessor
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 14.
 *
 * @param <T> stored value type in node
 */
public interface TreeAccessor<T> {

	/**
	 * Tree Search
	 * 
	 * @param treeNode tree node
	 * @param target target value
	 * @return tree node
	 */
	TreeNode<T> search(TreeNode<T> treeNode, T target);
	
	/**
	 * Add
	 * 
	 * @param treeNode tree node
	 * @param target target value
	 * @return tree node
	 */
	TreeNode<T> add(TreeNode<T> treeNode, T target);
	
	/**
	 * Remove
	 * 
	 * @param treeNode tree node
	 * @param target target value
	 * @throws
	 */
	void remove(TreeNode<T> treeNode, T target) throws IllegalAccessException;
	
	/**
	 * Show all nodes
	 * 
	 * @param treeNode tree node
	 * @return all nodes
	 */
	String toString(TreeNode<Integer> treeNode);
	
}
