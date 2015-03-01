package h2hyun37.study.tree;


public class BinaryTree {

	int data;
	BinaryTree left = null, right = null;


	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static BinaryTree makeTreeRoot(int data) {
		BinaryTree node = new BinaryTree();
		node.setData(data);
		return node;
	}

	public BinaryTree add(BinaryTree root, int data) {

		if (root == null) {
			BinaryTree node = new BinaryTree();
			node.setData(data);
			return node;

		} else {

			// recursive call : leftnode
			// newData < nodeData
			if (data < root.getData()) {
				BinaryTree node;
				node = add(root.left, data);
				root.left = node;
				return root;

			// recursive call : rightnode
			// nodeData < newData
			} else if (root.getData() < data) {
				BinaryTree node;
				node = add(root.right, data);
				root.right = node;
				return root;

			// error : already existing value
			// nodeData == newData
			} else {
				return root;
			}
		}
	}


	public void print(BinaryTree root, int level) {

		for (int i = 0; i < level; i++) {
			System.out.print("\t\t");
		}
		System.out.println(root.data + "(level:" + level + ")" + "\n");

		if (root.left != null) {
			print(root.left, level - 2);
		}

		if (root.right != null) {
			print(root.right, level + 1);
		}

	}

	public static void main(String[] args) {

		BinaryTree root = null;

		for (int idx = 0; idx < 100; idx++) {

			// make random data
			int data = (int) (Math.random() * 10000);

			if (idx == 0) {
				root = makeTreeRoot(data);
			} else {
				root = root.add(root, data);
			}

		}

		root.print(root, 200);
	}

}
