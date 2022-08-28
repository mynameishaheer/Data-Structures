
class Nodee {
	int data;
	Nodee next;

	Nodee(int d) {
		data = d;
		next = null;
	}
}

class LinkedList {

	Nodee head;

	public boolean isEmpty() {

		if (head == null) {
			return true;
		}
		return false;

	}

	public int length() {

		int length = 0;
		Nodee temp = head;
		if (head == null) {
			return 0;
		}

		else {
			while (temp != null) {
				length++;
				temp = temp.next;
			}
			return length;

		}
	}

	public void addAsHead(int data) {
		Nodee temp = new Nodee(data);

		temp.next = head;
		head = temp;

	}

	public void addAsTail(int data) {
		Nodee insert = new Nodee(data);

		if (head == null) {
			head = insert;
			return;
		}
		insert.next = null;
		Nodee last = head;

		while (last.next != null) {
			last = last.next;
		}

		last.next = insert;

	}

	public void insertInOrder(int data) {
		Nodee insert = new Nodee(data);
		Nodee temp;
		if (head == null || head.data > insert.data) {
			insert.next = head;
			head = insert;
		}

		else {
			temp = head;
			while (temp.next != null && temp.next.data < insert.data) {
				temp = temp.next;
			}

			insert.next = temp.next;
			temp.next = insert;
		}
	}

	public boolean find(int data) {
		Nodee temp = head;

		while (temp != null) {
			if (temp.data == data) {
				System.out.println("\n" + "Item Found " + data);
				return true;
			}
			temp = temp.next;
		}
		System.out.println("\n" + "Item Not Found");
		return false;
	}

	public void reverseList() {
		Nodee temp = head;
		Nodee previous = null;
		Nodee current = null;

		while (temp != null) {
			current = temp;
			temp = temp.next;
			current.next = previous;
			previous = current;
			head = current;
		}

	}

	public int head() {
		Nodee temp;
		if (head == null) {
			return -1;
		} else {
			temp = head;
			head = temp.next;
			return temp.data;
		}

	}

	public void removeFirst(int value) {
		Nodee temp = head;
		Nodee previous = null;

		if (temp != null && temp.data == value) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != value) {
			previous = temp;
			temp = temp.next;
		}

		if (temp == null) {
			return;
		}

		previous.next = temp.next;

	}

	public void removeAll(int value) {
		Nodee temp = head;
		Nodee prev = null;

		while (temp != null && temp.data == value) {
			head = temp.next;
			temp = head;
		}

		while (temp != null) {

			while (temp != null && temp.data != value) {
				prev = temp;
				temp = temp.next;
			}

			if (temp == null) {
				return;
			}

			prev.next = temp.next;

			temp = prev.next;
		}
	}

	public void addList(LinkedList b) {

		Nodee glue = b.head;
		Nodee current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = glue;
	}

	public String toString() {
		String str = "";
		Nodee temp = head;
		while (temp != null) {
			str += temp.data + " ";
			temp = temp.next;

		}
		return str;
	}

}

public class question_2 {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.insertInOrder(5);
		list.insertInOrder(245);
		list.insertInOrder(34);
		list.insertInOrder(69);
		list.insertInOrder(5);
		list.insertInOrder(5);
		list.insertInOrder(420);
		list.insertInOrder(-50);
		list.insertInOrder(-3);
		System.out.println("Length is " + list.length());
		System.out.println(list);

		list.find(5);
		list.find(4);

		list.removeFirst(5);
		System.out.println(list);
		list.removeAll(5);
		System.out.println(list);

		list.reverseList();
		System.out.println(list);

		list.addAsHead(69);
		list.addAsTail(69);

		System.out.println(list);

		list.head();
		System.out.println(list);

		System.out.println("");

		LinkedList list2 = new LinkedList();

		list2.insertInOrder(24);
		list2.insertInOrder(59);
		list2.insertInOrder(25);

		list.addList(list2);

		System.out.println(list);

	}

}
