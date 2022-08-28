public class BankLL {

	static String Bankname = "";
	Account head;

	BankLL(String a) {
		Bankname = a;
	}

	static class Account {
		TransNode head;
		Account next;
		int i = 0;
		String Name = Bankname;

		Account(String a) {
			Name = Bankname + a;

			head = new TransNode();
			TransNode temp = head;

			int rndm = (int) (Math.random() * 6 + 3);
			i = 0;

			while (i < rndm) {

				while (temp.next != null) {
					temp = temp.next;
				}

				temp.data = temp.data + i;
				temp.next = new TransNode();
				i++;
			}

		}

		void printDetails() {

			TransNode temp = head;

			while (temp.next != null) {
				System.out.print(temp.data);
				System.out.println();
				temp = temp.next;
			}

		}

	}

	static class TransNode {

		TransNode next;
		String data = "Transaction Number: ";
		int counter = 0;

		TransNode() {
			data = data + counter;
			counter++;
		}

	}

	void add(String a) {

		if (head == null) {
			this.head = new Account(a);
		}

		else {
			Account temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Account(a);
		}

	}

	void printDetails() {

		Account temp = head;

		while (temp != null) {
			System.out.println();
			System.out.println(temp.Name);
			temp.printDetails();
			temp = temp.next;
		}

	}

	void search(String a) {

		System.out.println();
		System.out.println("Printing account: " + a);
		Account temp = head;
		a = Bankname + a;

		while (temp.next != null) {

			if (a.equals(temp.Name)) {
				temp.printDetails();
				break;
			}
			temp = temp.next;
		}
	}

	void delete(String a) {

		System.out.println();
		System.out.println("Deleting Account: " + a);
		Account temp = head;
		a = Bankname + a;

		Account temp1;
		Account temp2;

		while (temp.next != null) {

			if (a.equals(head.Name)) {
				head = head.next;
				break;
			}

			if (a.equals(temp.next.Name)) {

				temp2 = temp.next;

				if (temp2.next == null) {

					temp.next = null;
					break;

				}

			}

			if (a.equals(temp.next.Name)) {

				temp1 = temp.next;
				temp1 = temp1.next;
				temp.next = temp1;
				break;

			}
			temp = temp.next;
		}

	}

	public static void main(String[] args) {

		BankLL[] A = new BankLL[10];

		for (int i = 0; i < 5; i++) {
			A[i] = new BankLL("SCBL" + i);
			A[i].add("0000011111222" + i);
			A[i].add("9876512345172" + i);
			A[i].add("1010126262837" + i);
			A[i].printDetails();
			A[i].search("0000011111222" + i);
			A[i].delete("0000011111222" + i);
			A[i].printDetails();
		}

	}

}
