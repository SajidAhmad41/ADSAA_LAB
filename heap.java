import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

public class HeapExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers (comma-separated):");
        String[] input = scanner.nextLine().split(",");
        Integer[] intElements = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            intElements[i] = Integer.parseInt(input[i].trim());
        }

        System.out.println("Enter the integer to delete:");
        int deleteElement = scanner.nextInt();

        demoHeap(intElements, Integer::compare, Comparator.reverseOrder(), deleteElement);

        scanner.close();
    }

    public static void demoHeap(Integer[] elements, Comparator<Integer> minComparator, Comparator<Integer> maxComparator, Integer deleteElement) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(minComparator);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxComparator);

        for (Integer elem : elements) {
            minHeap.add(elem);
            maxHeap.add(elem);
        }

        System.out.println("Min Heap: " + minHeap);
        System.out.println("Max Heap: " + maxHeap);

        deleteFromHeap(minHeap, deleteElement);
        System.out.println("Min Heap after deleting " + deleteElement + ": " + minHeap);

        deleteFromHeap(maxHeap, deleteElement);
        System.out.println("Max Heap after deleting " + deleteElement + ": " + maxHeap);
    }

    private static void deleteFromHeap(PriorityQueue<Integer> heap, Integer element) {
        if (heap.remove(element)) {
            System.out.println("Successfully removed " + element);
        } else {
            System.out.println(element + " not found in the heap.");
        }
    }
}
