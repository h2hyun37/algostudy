package xenomity.study.tree;

import java.util.ArrayList;
import java.util.List;


/**
 * Binary Tree (이진 트리)
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 13.
 *
 */
public class BinaryTree<T> implements TreeNode<T>, Bidirectionable<T> {

	public static final int LEFT_NODE = 0;
	public static final int RIGHT_NODE = 1;
	private static final int MAX_LIMIT = 2;
	private final List<BinaryTree<T>> childList = new ArrayList<>(MAX_LIMIT);
	private BinaryTree<T> parent;
	private T value;
	
	/**
	 * The Constructor
	 */
	public BinaryTree() {}
	
	/**
	 * The Constructor
	 * 
	 * @param value value
	 */
	public BinaryTree(T value) {
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
	public BinaryTree(T value, BinaryTree<T> parent) throws IllegalAccessException {
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
	public void setNodeValue(T value) {
		this.value = value;
		
		init();
	}

	@Override
	public T getNodeValue() {
		return value;
	}

	@Override
	public void setChild(TreeNode<T> treeNode, int childIndex) {
		BinaryTree<T> binaryTree = (BinaryTree<T>) treeNode;
		childList.set(childIndex, binaryTree);
		
		try {
			binaryTree.setParent(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TreeNode<T> getChild(int childIndex) {
		return childList.get(childIndex);
	}
	
	@Override
	public void removeChild(int childIndex) {
		childList.set(childIndex, new BinaryTree<T>());
		
		try {
			childList.get(childIndex).setParent(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int childrenSize() {
		return MAX_LIMIT;
	}
	
	@Override
	public TreeNode<T> getParent() throws IllegalAccessException {
		if (parent == null) {
			throw new IllegalAccessException("current node is root,");
		}
		
		return parent;
	}

	@Override
	public void setParent(TreeNode<T> treeNode)
			throws IllegalAccessException {
		BinaryTree<T> binaryTree = (BinaryTree<T>) treeNode;
		
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
	public void removeChild(TreeNode<T> treeNode) {
		for (int i = 0; i < MAX_LIMIT; i++) {
			BinaryTree<T> elementNode = childList.get(i);
			
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
		return value != null && childList.get(LEFT_NODE).isEmpty() && childList.get(RIGHT_NODE).isEmpty();
	}
	
	// initialize
	private void init() {
		childList.set(LEFT_NODE, new BinaryTree<T>());
		childList.set(RIGHT_NODE, new BinaryTree<T>());
		
		try {
			childList.get(LEFT_NODE).setParent(this);
			childList.get(RIGHT_NODE).setParent(this);
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
		return !childList.get(LEFT_NODE).isEmpty() && !childList.get(RIGHT_NODE).isEmpty();
	}
	
	/**
	 * Is Contain Child Node
	 * 
	 * @param childNode child node
	 * @return child node index
	 */
	public int contain(BinaryTree<T> childNode) {
		int containIndex = -1;
		
		if (childList.get(LEFT_NODE).equals(childNode)) {
			containIndex = LEFT_NODE;
		} else if (childList.get(RIGHT_NODE).equals(childNode)) {
			containIndex = RIGHT_NODE;
		}
		
		return containIndex;
	}

}
