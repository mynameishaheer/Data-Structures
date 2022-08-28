
class CircularArrayQueue<T extends Comparable<T>> {

	T queueList[];

	int front;
	int rear;
	int size;

	CircularArrayQueue(int size) {
		queueList = (T[]) new Comparable[size];
		this.front = size - 1;
		this.rear = size - 1;
		this.size = size;

	}

	CircularArrayQueue() {
		queueList = (T[]) new Comparable[10];

	}

	public void Enqueue(T value) {

		if (this.isFull()) {
			System.out.println("Queue Full - no more additions possible ");
		} else {
			rear = (rear + 1) % queueList.length;
			queueList[rear] = value;
		}

	}

	public T Dequeue() {

		if (this.isEmpty()) {
			System.out.println("Queue Empty - nothing removed");
			return null;
		} else {
			front = (front + 1) % queueList.length;
			return queueList[front];
		}
	}

	public Boolean isEmpty() {
		if (front == rear) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isFull() {
		if ((rear + 1) % queueList.length == front) {
			return true;
		} else {
			return false;
		}
	}

	public void print() {
		for (int i = (front + 1) % queueList.length; i != rear + 1; i = (i + 1) % queueList.length) {
			System.out.print(queueList[i] + ", ");
		}
	}
}

public class QueueImplimentation {

	public static void main(String[] args) {

		CircularArrayQueue a1 = new CircularArrayQueue(5);

		a1.Enqueue("Shaheer");
		a1.Enqueue("Ahmed");
		a1.Enqueue("Moosa");
		a1.Enqueue("RG");

		a1.print();
		System.out.println();

		System.out.println(a1.Dequeue());

		a1.print();

		System.out.println(" ");
		System.out.println(a1.Dequeue());
		System.out.println("line space");
		a1.print();
	}

}
