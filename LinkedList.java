public class LList {

	static class node {

		int data;
		node pointer;

		node(int d) {
			data = d;
			pointer = null;
		}
	}

	static class LinkedList {

		node start;

		public void insert(int d) {
			node n = new node(d);

			if (start == null) {
				start = n;
				System.out.println("Item Inserted: " + d);
			} else {
				node temp = start;
				while (temp.pointer != null) {
					temp = temp.pointer;
				}

				temp.pointer = n;
				System.out.println("Item Inserted: " + d);
			}
		}

		public Boolean find(int d) {
			node temp = start;

			while (temp != null) {
				if (temp.data == d) {
					System.out.println("Item Found: " + d);
					return true;
				}

				temp = temp.pointer;
			}

			System.out.println("Item Not Found");
			return false;
		}

		public void clear() {
			start = null;
			System.out.println("List Cleared");
		}

		public void delete(int d) {
			node temp = start;
			node prev = start;

			if (temp != null && temp.data == d) {
				start = temp.pointer;
			}

			while (temp != null && temp.data != d) {
				prev = temp;
				temp = temp.pointer;
			}

			if (temp == null) {
				temp = temp.pointer;
			}

			prev.pointer = temp.pointer;
			System.out.println("Item Deleted: " + d);
		}

		public String toString() {
			String str = "";
			node temp = start;

			while (temp != null) {
				str = str + temp.data;
				System.out.println();
				temp = temp.pointer;
			}

			return str;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.insert(1);
		list.insert(3);
		list.insert(4);
		list.insert(6);
		list.insert(7);

		System.out.println();
		list.find(1);
		System.out.println();
		list.delete(6);

		// list.clear();

		System.out.print(list);
	}
}
