package xenomity.study.tree;

/**
 * Bidirection Interface
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 14.
 *
 */
public interface Bidirectionable<T> {

	/**
	 * Get Parent
	 * 
	 * @return parent node
	 * @throws if node is root.
	 */
	TreeNode<T> getParent() throws IllegalAccessException;
	
	/**
	 * Set Parent
	 * 
	 * @param treeNode parent tree node
	 * @throws if parent node have two children.
	 */
	void setParent(TreeNode<T> treeNode) throws IllegalAccessException;
	
}
