package xenomity.study.tree;


/**
 * Binary Tree (이진 트리)
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 13.
 *
 */
public class BinaryTree implements TreeNode<Integer>, Bidirectionable<Integer> {

	public static final int LEFT_NODE = 0;
	public static final int RIGHT_NODE = 1;
	private static final int MAX_LIMIT = 2;
	private final BinaryTree[] childList = new BinaryTree[MAX_LIMIT];
	private BinaryTree parent;
	private Integer value;
	
	/**
	 * The Constructor
	 */
	public BinaryTree() {}
	
	/**
	 * The Constructor
	 * 
	 * @param value value
	 */
	public BinaryTree(Integer value) {
		this();
		this.value = value;
		
		init();
	}
	
	/**
	 * The Constructor
	 * 
	 * @param value value
	 * @param parent parent tree node
	 * @throws IllegalAccessException 
	 */
	public BinaryTree(Integer value, BinaryTree parent) throws IllegalAccessException {
		this();
		this.value = value;
		
		init();
		setParent(parent);
	}
	
	@Override
	public int hashCode() {
		return value == null ? System.identityHashCode(this) : value.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || (!(obj instanceof BinaryTree))) {
			return false;
		}
		
		return hashCode() == obj.hashCode();
	}
	
	@Override
	public String toString() {
		return value == null ? "NIL" : value.toString();
	}

	@Override
	public void setNodeValue(Integer value) {
		this.value = value;
		
		init();
	}

	@Override
	public Integer getNodeValue() {
		return value;
	}

	@Override
	public void setChild(TreeNode<Integer> treeNode, int childIndex) {
		BinaryTree binaryTree = (BinaryTree) treeNode;
		childList[childIndex] = binaryTree;
		
		try {
			binaryTree.setParent(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TreeNode<Integer> getChild(int childIndex) {
		return childList[childIndex];
	}
	
	@Override
	public void removeChild(int childIndex) {
		childList[childIndex] = new BinaryTree();
		
		try {
			childList[childIndex].setParent(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int childrenSize() {
		return MAX_LIMIT;
	}
	
	@Override
	public TreeNode<Integer> getParent() throws IllegalAccessException {
		if (parent == null) {
			throw new IllegalAccessException("current node is root,");
		}
		
		return parent;
	}

	@Override
	public void setParent(TreeNode<Integer> treeNode)
			throws IllegalAccessException {
		BinaryTree binaryTree = (BinaryTree) treeNode;
		
		// argument validation
		if (binaryTree.isEmpty()) {
			throw new IllegalAccessException("parent node is empty node.");
		}
		
		if (binaryTree.isFull()) {
			throw new IllegalAccessException("parent node have two child nodes.");
		}
		
		// set parent
		parent = binaryTree;
	}
	
	@Override
	public void removeChild(TreeNode<Integer> treeNode) {
		for (int i = 0; i < MAX_LIMIT; i++) {
			BinaryTree elementNode = childList[i];
			
			if (elementNode.equals(treeNode)) {
				removeChild(i);
			}
		}
	}
	
	@Override
	public boolean isRoot() {
		return parent == null;
	}
	
	@Override
	public boolean isLeaf() {
		return value != null && childList[LEFT_NODE].isEmpty() && childList[RIGHT_NODE].isEmpty();
	}
	
	// initialize
	private void init() {
		childList[LEFT_NODE] = new BinaryTree();
		childList[RIGHT_NODE] = new BinaryTree();
		
		try {
			childList[LEFT_NODE].setParent(this);
			childList[RIGHT_NODE].setParent(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Is Empty
	 * 
	 * @return if current node value is empty.
	 */
	public boolean isEmpty() {
		return value == null;
	}
	
	/**
	 * Is Full
	 * 
	 * @return if current node have two children.
	 */
	public boolean isFull() {
		return !childList[LEFT_NODE].isEmpty() && !childList[RIGHT_NODE].isEmpty();
	}
	
	/**
	 * Is Contain Child Node
	 * 
	 * @param childNode child node
	 * @return child node index
	 */
	public int contain(BinaryTree childNode) {
		int containIndex = -1;
		
		if (childList[LEFT_NODE].equals(childNode)) {
			containIndex = LEFT_NODE;
		} else if (childList[RIGHT_NODE].equals(childNode)) {
			containIndex = RIGHT_NODE;
		}
		
		return containIndex;
	}

}
