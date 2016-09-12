import java.util.Random;

class SortedBTree {
	SortedBTree left, right;
	int d;

	public SortedBTree() {
		left = null;
		right = null;
		d = 0;
	}

	public SortedBTree(int n) {
		left = null;
		right = null;
		d = n;
	}

	public SortedBTree getLeft() {
		return left;
	}

	public void setLeft(SortedBTree left) {
		this.left = left;
	}

	public SortedBTree getRight() {
		return right;
	}

	public void setRight(SortedBTree right) {
		this.right = right;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

}

class BTreeNodes {
	private SortedBTree root;

	public BTreeNodes() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int d) {
		root = insert(root, d);
	}

	public SortedBTree insert(SortedBTree node, int d) {
		if (node == null)
			node = new SortedBTree(d);
		else {
			if (d <= node.getD())
				node.left = insert(node.left, d);
			else
				node.right = insert(node.right, d);
		}
		return node;
	}

	public void delete(int k) {
		if (isEmpty())
			System.out.println("Tree is Empty");
		else if (search(k) == false)
			System.out.println("Sorry" + k + "is not there");
		else {
			root = delete(root, k);
			System.out.println(k + "deleted successfully from the tree");
		}
	}

	private SortedBTree delete(SortedBTree root, int k) {
		SortedBTree p, p2, n;
		if (root.getD() == k) {
			SortedBTree lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (k < root.getD()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), k);
			root.setRight(n);
		}
		return root;
	}

	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(SortedBTree r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	public boolean search(int val) {
		return search(root, val);
	}

	private boolean search(SortedBTree r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.getD();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(SortedBTree r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getD() + " ");
			inorder(r.getRight());
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(SortedBTree r) {
		if (r != null) {
			System.out.print(r.getD() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(SortedBTree r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getD() + " ");
		}
	}

}

public class Sort_BTree {
	public static int N = 20;

	public static void main(String args[]) {
		Random random = new Random();
		BTreeNodes bt = new BTreeNodes();

		System.out.println("Sorting of randomly generated numbers using B TREE");

		for (int i = 0; i < N; i++)
			bt.insert(Math.abs(random.nextInt(100)));

		System.out.println("The elements of the tree: ");
		bt.preorder();

		System.out.println("\nThe sorted sequence is: ");
		bt.inorder();
	}
}