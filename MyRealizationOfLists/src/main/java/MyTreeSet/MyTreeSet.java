package MyTreeSet;

public class MyTreeSet<E extends Comparable<E>> {

	private int size;
	Node<E> root;

	// TreeSet
	private static class Node<E> {
		E item;
		Node<E> left;
		Node<E> right;

		Node(E element, Node<E> left, Node<E> right) {
			this.item = element;
			this.right = right;
			this.left = left;
		}

		Node(E element) {
			this.item = element;

		}
	}

	public int size() {
		return size;

	}

	public boolean contains(E value) {
		if (root == null) {
			return false;
		}
		Node<E> temp = root;
		while (true) {
			if (temp.item.compareTo(value) == 0) {
				return true;
			} else {
				if (temp.item.compareTo(value) > 0) {
					if (temp.left == null) {
						return false;
					} else {
						temp = temp.left;
					}
				} else {
					if (temp.right == null) {
						return false;
					} else {
						temp = temp.right;
					}
				}
			}
		}
	}

	public boolean add(E value) {
		if (contains(value)) {
			return false;
		} else {
			if (root == null) {
				root = new Node(value);
				size++;
				return true;
			}
			Node<E> temp = root;
			while (true) {

				if (temp.item.compareTo(value) > 0) {
					if (temp.left == null) {
						temp.left = new Node(value);
						size++;
						return true;
					} else {
						temp = temp.left;
					}
				} else {
					if (temp.right == null) {
						temp.right = new Node(value);
						size++;
						return true;
					} else {
						temp = temp.right;
					}
				}
			}
		}
	}

	private E findMaxElement(Node<E> root) {
		if (root.left == null && root.right == null) {
			return root.item;
		} else {
			if (root.left != null) {
				Node<E> maxValue = root.left;
				Node<E> parent = root;
				while (true) {
					if (maxValue.right != null) {
						parent = maxValue;
						maxValue = maxValue.right;
					} else {
						E value = maxValue.item;
						parent.right = null;
						return value;
					}

				}
			} else {
				Node<E> minValue = root.left;
				Node<E> parent = root;
				while (true) {
					if (minValue.left != null) {
						parent = minValue;
						minValue = minValue.left;
					} else {
						parent.left = null;
						return minValue.item;
					}

				}
			}
		}
	}

	public boolean remove(E value) {
		if (!contains(value)) {
			return false;
		} else {
			if (root == null) {
				return false;
			}
			Node<E> temp = root;
			Node<E> parent = root;
			while (true) {

				if (temp.item.compareTo(value) == 0) {
					if (findMaxElement(temp).compareTo(temp.item) == 0) {
						if (parent.right != null && parent.right.item == value) {
							parent.right = null;
						} else if (parent.left != null && parent.left.item == value) {
							parent.left = null;
						}
						size--;
						return true;
					} else {
						size--;
						temp.item = findMaxElement(temp);
						return true;
					}

				} else {
					if (temp.item.compareTo(value) > 0) {
						parent = temp;
						temp = temp.left;

					} else {
						parent = temp;
						temp = temp.right;

					}
				}
			}
		}
	}

}
