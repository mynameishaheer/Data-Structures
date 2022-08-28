package priorityqueueimplementation;

class ArrayQueue<T extends Comparable<T>> {

    T[] arrayList;
    int front = -1;
    int rear = -1;

    ArrayQueue() {

        arrayList = (T[]) new Comparable[10];
    }

    ArrayQueue(int x) {

        arrayList = (T[]) new Comparable[x];
    }

   public void enqueueInOrder(T value) {

        if (isFull()) {
            
        } 
        else if (rear == -1) {
            
            front++;
            rear++;
            arrayList[rear] = value;
            
        } 
        
        else if (rear == arrayList.length - 1 && arrayList[0] == null) {

            rear = 0;
            arrayList[rear] = value;

        } 
        
        else {
            
            arrayList[++rear] = value;
            
        }

    }

    public void Dequeue() {

        if (front == arrayList.length - 1) {

            arrayList[front] = null;
            front = 0;
        } 
        
        else {
            
            arrayList[front++] = null;

        }

    }

    public void dequeuePriority() {

        if (rear < 0 || rear >= arrayList.length) {
            
            rear = 0;
        }

        if (front < 0 || front >= arrayList.length) {
            
            front = 0;
        }

        T make = arrayList[0];

        for (int i = 0; i < arrayList.length; i++) {
            
            if (arrayList[i] != null) {
                make = arrayList[i];
                break;
            }

        }

        int temp = 0;
        int count = 0;

        for (int i = front; i < arrayList.length; i++) {

            if (arrayList[i] == null) {
                
            } 
            
            else if (make.compareTo(arrayList[i]) >= 0) {

                make = arrayList[i];
                temp = i;

            }

        }

        if (rear < front) {
            for (int i = rear; i > -1; i--) {
                if (arrayList[i] == null) {
                } else if (make.compareTo(arrayList[i]) >= 0) {

                    make = arrayList[i];
                    temp = i;

                }

            }
        }

        front = temp;
        rear = temp - 1;
        System.out.println(temp + " " + (temp - 1));

       
        
        arrayList[front] = null;

        while (arrayList[front] == null) {
            front++;

            if (front == arrayList.length) {
                front = 0;

            }
        }

        System.out.println();
        System.out.println(front);
        System.out.println(rear);

    }

    public void Compare (T x, T y) {
        
        System.out.println(x.compareTo(y));
        
    }

    public boolean isEmpty() {

        return ( front < 0 );
        
    }

    public boolean isFull() {

        if (front > rear && front - 1 == rear) {

            return true;
            
        } 
        
        else if (rear == arrayList.length - 1 && arrayList[0] != null) {
            
            return true;
        } 
        
        else {
            
            return false;
        }
    }

    public void print() {

        int temp = front;
        front = 0;

        while (front < arrayList.length) {

            if (front == -1) {
                System.out.println("The list is already empty");
                break;
            }

            System.out.print(arrayList[front] + ", ");
            front++;
        }

        front = temp;
    }
}

public class PriorityQueueImplementation {

    public static void main(String[] args) {
        ArrayQueue<String> arr = new ArrayQueue<String>(8);
        arr.enqueueInOrder("P");
        arr.enqueueInOrder("U");
        arr.enqueueInOrder("Z");
        arr.enqueueInOrder("F");
        arr.enqueueInOrder("X");
        arr.enqueueInOrder("U");
        arr.enqueueInOrder("Z");
        arr.print();
        
        arr.dequeuePriority();
        arr.print();
        
        arr.dequeuePriority();
        arr.print();
        
        
        arr.enqueueInOrder("MoosaHaseem");
        
        System.out.println();
        
        arr.enqueueInOrder("69");
        arr.print();

    }
}
