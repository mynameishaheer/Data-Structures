class Node<T> {
	T data;
	Node prev;
	Node next;

	Node(T d) {
		data = d;
	}
}

class DoublyLinkedList<T extends Comparable<T>> {
	Node<T> head;

	public Node Find(T value) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == value)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	public void insertInorder(T value) {
		Node<T> n = new Node(value);
		if (head == null) {
			head = n;
		}

		else {
			Node<T> temp = head;
			while (temp.next != null && temp.data.compareTo(value) < 0) {
				temp = temp.next;
			}
			if (temp == head && value.compareTo(temp.data) < 0) {
				temp.prev = n;
				n.next = temp;
				head = n;
			} else if (temp.next == null && temp.data.compareTo(value) < 0) {
				temp.next = n;
				n.prev = temp;
			} else {
				n.next = temp;
				n.prev = temp.prev;
				temp.prev.next = n;
				temp.prev = n;
			}
		}

	}

	public void Delete(T value) {
		Node<T> temp = head;
		while (temp != null) {
			if (temp.data == value) {
				if (temp == head) {
					head = temp.next;
					temp.next.prev = null;
				}

				else {
					if (temp.next == null) {
						temp.prev.next = null;
					} else {
						temp.prev.next = temp.next;
						temp.next.prev = temp.prev;
					}

				}

			}
			temp = temp.next;
		}
	}

	public String toString() {
		String str = "";
		Node temp = head;
		while (temp != null) {
			str += temp.data + " ";
			temp = temp.next;

		}
		return str;
	}

	public void ListClear() {
		head = null;
		head.next = null;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public int length() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	public void ListReverse() {
		Node temp = head;
		Node previous = head;
		while (temp != null) {
			previous = temp.prev;
			temp.prev = temp.next;
			temp.next = previous;
			if (temp.prev == null)
				head = temp;
			temp = temp.prev;
		}

	}
}

public class DoublyLList {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> list = new DoublyLinkedList();
		list.insertInorder(5);
		list.insertInorder(420);
		list.insertInorder(43);
		list.insertInorder(69);
		list.insertInorder(222);
		list.insertInorder(-30);
		list.insertInorder(-5);

		System.out.println(list);
		list.ListReverse();

		System.out.println(list);

		list.insertInorder(-24);
		System.out.println(list);

	}

}
