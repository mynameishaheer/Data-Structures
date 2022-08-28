public class Poly {

	Node head;

	static class Node {

		Node next;
		int power, co_eff;

		Node(int x, int y) {
			power = y;
			co_eff = x;
			next = null;
		}
	}

	void add(int x, int y) {

		if (head == null) {
			head = new Node(x, y);
		}

		else {
			Node temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Node(x, y);
		}

	}

	void print() {

		String a = "";
		Node temp = head;

		while (temp.next != null) {

			a = a + temp.co_eff + "x^" + temp.power + " + ";
			temp = temp.next;

		}

		a = a + temp.co_eff;
		System.out.println(a);

	}

	static Poly add(Poly A, Poly B) {

		int a = 1;
		int b = 1;
		Node TempA = A.head;
		Node TempB = B.head;

		while (TempA.next != null) {
			a++;
			TempA = TempA.next;
		}

		while (TempB.next != null) {
			b++;
			TempB = TempB.next;
		}

		TempA = A.head;
		TempB = B.head;

		int max = Math.max(a, b);

		int[][] adder = new int[2][max];

		for (int i = 0; i < max; i++) {

			if (TempA.power == max - 1 - i) {
				adder[0][i] = TempA.co_eff;
				TempA = TempA.next;
			}

			if (TempB.power == max - 1 - i) {
				adder[1][i] = TempB.co_eff;
				TempB = TempB.next;
			}

		}

		int[] newpoly = new int[max];

		Poly C = new Poly();

		for (int i = 0; i < max; i++) {

			newpoly[i] = adder[0][i] + adder[1][i];

			C.add(newpoly[i], max - 1 - i);

		}

		return C;

	}

	public static void main(String[] args) {

		Poly A = new Poly();
		Poly B = new Poly();
		Poly C = new Poly();

		A.add(7, 3);
		A.add(4, 2);
		A.add(3, 1);
		A.add(6, 0);
		System.out.print("Polynomial A: ");
		A.print();
		System.out.println();

		B.add(3, 4);
		B.add(7, 3);
		B.add(2, 2);
		B.add(10, 1);
		B.add(7, 0);
		System.out.print("Polynomial B: ");
		B.print();
		System.out.println();

		C = add(A, B);
		System.out.print("Adding A and B: ");
		C.print();
		System.out.println();
	}

}
