
import java.util.Random;

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        next = null;
    }
}

class circularLinkedList {
    Node head;
    Node tail;

    public void insert(String name) {
        Node newNode = new Node(name);

        if (head == null) {

            head = newNode;
            tail = newNode;
            newNode.next = newNode;

        }

        else {

            Node temp = head;
            newNode.next = temp;
            head = newNode;
            tail.next = head;

        }
    }

    public String toString() {
        String str = "";
        Node temp = head;
        while (temp != null) {
            str += temp.name + " ";
            temp = temp.next;

        }
        return str;
    }

    public void removeName(String checkname) {

        Node temp = head;
        Node previous = null;

        if (temp != null && temp.name.equals(checkname)) {
            head = temp.next;
            return;
        }

        while (temp.next != head && !temp.name.equals(checkname)) {
            previous = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        else {
            previous.next = temp.next;
        }

    }

    public int length() {

        Node temp = head;
        int count = 0;

        if (head != null) {
            do {
                temp = temp.next;
                count++;
            } while (temp != head);
        }

        return count;
    }

    public void playGame(int length) {
        int lengthoflist = 0;
        int remove = 0;
        Node temp = head;
        while (head != head.next && length > 1) {

            Random rand = new Random();
            remove = rand.nextInt(length + 1);
            length--;

            for (int i = 0; i < remove; i++) {
                temp = temp.next;
            }
            removeName(temp.name);
        }

        System.out.println("The person remaining is " + head.name + " !");

    }

}

public class JosephusProblem {

    public static void main(String[] args) {

        circularLinkedList list1 = new circularLinkedList();

        list1.insert("RG");
        list1.insert("Moosa");
        list1.insert("Shaheer");
        list1.insert("Sameer");
        list1.insert("Ammar");
        list1.insert("Rakhman");

        list1.playGame(list1.length());

    }

}
