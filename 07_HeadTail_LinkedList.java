class Nodee {

	int data;
	Nodee prev;
	Nodee next;

	Nodee() {
	}

	Nodee(int d) {
		data = d;
	}
}

class DoublyLinkedList {

	Nodee head;

	public void insertInOrder(int data) {
		Nodee newnode = new Nodee();
		newnode.data = data;
		Nodee current;

		if (head == null || head.data >= newnode.data) {
			this.addAsHead(data);
		} else {

			current = head;

			while (current.next != null && current.next.data < newnode.data)
				current = current.next;
			if (current.next != null) {
				newnode.next = current.next;
				newnode.prev = current;
				current.next.prev = newnode;
				current.next = newnode;
			} else
				this.addAsTail(data);
		}
	}

	public Nodee find(int value) {

		Nodee temp = head;
		while (temp.next != null) {
			if (temp.data == value) {
				return temp;
			}

			temp = temp.next;
		}
		if (temp.data == value)
			return temp;
		return null;
	}

	public void output() {

		Nodee n = head;
		System.out.print("{");
		while (n.next != null) {
			System.out.print(n.data + ", ");
			n = n.next;
		}
		System.out.println(n.data + "}");
	}

	public void removeFirst(int value) {

		Nodee temp = head;
		Nodee prev = null;

		if (temp != null && temp.data == value) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != value) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null)
			return;
		else {
			prev.next = temp.next;
		}

	}

	public int length() {
		if (this.isEmpty())
			return 0;
		int counter = 1;
		Nodee n = head;
		while (n.next != null) {
			counter++;
			n = n.next;
		}
		return counter;
	}

	public void listReverse() {

		Nodee pointer = head;
		Nodee previous = null;
		Nodee current = null;
		while (pointer != null) {
			current = pointer;
			pointer = pointer.next;

			current.next = previous;
			previous = current;
			head = current;
		}

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
			if (temp == null)
				return;

			prev.next = temp.next;
			temp = prev.next;
		}
	}

	public int Head() {
		Nodee temp;
		if (head == null) {
			return -1;
		} else {
			temp = head;
			head = temp.next;
			return temp.data;
		}

	}

	public void addAsHead(int data) {
		Nodee n = new Nodee(data);

		if (head == null)
			head = n;
		else {
			head.prev = n;
			n.next = head;
			head = n;
		}

	}

	public void addAsTail(int data) {
		Nodee n = new Nodee(data);
		Nodee temp = head;

		if (head == null) {
			head = n;
			return;
		}

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = n;
		n.prev = temp;

	}

	public void addList(DoublyLinkedList b) {

		Nodee glue = b.head;
		Nodee current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = glue;
	}

	public Boolean isEmpty() {

		if (this.head == null) {
			return true;
		} else {
			return false;
		}
	}

}

public class question_3 {

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();

		list.insertInOrder(50);
		list.insertInOrder(70);
		list.insertInOrder(30);
		list.insertInOrder(35);
		list.insertInOrder(900);

		list.output();

		list.removeFirst(4);
		list.addAsHead(1);
		list.addAsHead(1);
		list.addAsTail(1);

		list.output();
		list.removeAll(100);
		list.listReverse();

		list.output();
		list.addAsTail(101);
		list.listReverse();
		list.output();

	}

}
