import java.util.PriorityQueue;

public class HeapExample {
    
    public static void main(String[] args) {
        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int[] elements = {3, 1, 6, 5, 2, 4};

        // Insert elements into Min Heap
        for (int elem : elements) {
            minHeap.add(elem);
        }

        // Insert elements into Max Heap
        for (int elem : elements) {
            maxHeap.add(elem);
        }

        System.out.println("Min Heap: " + minHeap);
        System.out.println("Max Heap: " + maxHeap);

        // Delete an element (e.g., 3) from Min Heap
        deleteElement(minHeap, 3);
        System.out.println("Min Heap after deleting 3: " + minHeap);

        // Delete an element (e.g., 3) from Max Heap
        deleteElement(maxHeap, 3);
        System.out.println("Max Heap after deleting 3: " + maxHeap);
    }

    // Function to delete an element from the Heap
    private static void deleteElement(PriorityQueue<Integer> heap, int element) {
        heap.remove(element);
    }
}
