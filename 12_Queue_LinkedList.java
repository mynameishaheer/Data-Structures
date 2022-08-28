class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	LinkedListNode() {

	}

	LinkedListNode(T data) {
		this.data = data;
	}
}

class LinkedListQueue<T> {

	LinkedListNode<T> front;
	LinkedListNode<T> rear;

	int queueSize = 0;

	public boolean isEmpty() {
		if (front == null) {
			return true;
		} else {
			return false;
		}

	}

	public void Enqueue(T data) {

		LinkedListNode<T> insert = new LinkedListNode<T>(data);
		if (isEmpty()) {
			front = insert;
		} else if (rear == null) {
			rear = insert;
			front.next = rear;
		} else {
			rear.next = insert;
			rear = insert;
		}

		queueSize++;

	}

	public T Dequeue() {
		if (isEmpty()) {

			System.out.println("Queue is empty");
			return null;
		}
		T output = front.data;
		front = front.next;
		queueSize--;
		return output;
	}

	public void print() {
		LinkedListNode<T> temp = front;

		while (temp.next != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(temp.data + " ");
	}
	public class QueueImplimentation {

	public static void main(String[] args) {

		LinkedListQueue list = new LinkedListQueue();

		System.out.println(" ");
		System.out.println("break");
		System.out.println("LinkedList used below this");

		list.Enqueue("Moosa");
		list.Enqueue("Ahmed");
		list.Enqueue("RG");
		list.Enqueue("Shaheer");
		list.Enqueue("Ebrahim");
		list.Enqueue("Turab");

		list.print();
		System.out.println(list.queueSize);
		System.out.println(list.Dequeue());

		list.print();
		System.out.println(list.queueSize);

		list.print();
		System.out.println(list.Dequeue());

	}
}

}
