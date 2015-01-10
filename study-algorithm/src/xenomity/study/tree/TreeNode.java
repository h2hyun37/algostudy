package xenomity.study.tree;

/**
 * Tree Node Interface
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 13.
 *
 */
public interface TreeNode<T> {
	
	/**
	 * Set Node Value
	 * 
	 * @param value node value
	 */
	void setNodeValue(T value);
	
	/**
	 * Get Node Value
	 * 
	 * @return node value
	 */
	T getNodeValue();

	/**
	 * Set Child
	 * 
	 * @param treeNode tree node reference
	 * @param childIndex child index
	 */
	void setChild(TreeNode<T> treeNode, int childIndex);
	
	/**
	 * Get Child
	 * 
	 * @param childIndex child index
	 * @return tree node
	 */
	TreeNode<T> getChild(int childIndex);
	
	/**
	 * Remove Child
	 * 
	 * @param childIndex child index
	 */
	void removeChild(int childIndex);
	
	/**
	 * Remove Child
	 * 
	 * @param treeNode tree node
	 */
	void removeChild(TreeNode<T> treeNode);
	
	/**
	 * Get Children Size
	 * 
	 * @return children size
	 */
	int childrenSize();
	
	/**
	 * Is Root Node
	 * 
	 * @return if current node is root.
	 */
	boolean isRoot();
	
	/**
	 * Is Leaf
	 * 
	 * @return if current node is leaf.
	 */
	boolean isLeaf();
	
}
