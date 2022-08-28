package javaapplication1;

public class JavaApplication1 {

    public static boolean LinearSearch(int arr[], int num) {
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            count = count + 2;
            if (arr[i] == num) {
                return true;
            }
        }
        System.out.println("Linear Search Count:" + (count++));
        return false;
    }

    public static boolean BinarySearch(int arr[], int num) {
        int first = 0;
        int last = arr.length - 1;
        int mid = 0;
        int count = 4;

        while (first < last) {
            mid = (first + last) / 2;
            if (num < arr[mid]) {
                last = mid - 1;
            } else if (num > arr[mid]) {
                first = mid + 1;
            } else {
                return true;
            }

            count = count + 5;
        }
        System.out.println("Binary Search Count: " + count++);
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        long start = System.nanoTime();
        System.out.println(LinearSearch(arr, -2));
        long end = System.nanoTime();
        System.out.println("Linear search time:" + (end - start));

        System.out.println("");

        long startB = System.nanoTime();
        System.out.println(BinarySearch(arr, -2));
        long endB = System.nanoTime();
        System.out.println("Binary search time:" + (endB - startB));
    }

}
