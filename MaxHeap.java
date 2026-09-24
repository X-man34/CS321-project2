import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MaxHeap
 * 
 * @param <E> The type of object to be stored
 * @param <T> The type of the key that the object has.
 */
public class MaxHeap<E extends HeapItem<E, T>, T> {

    protected ArrayList<E> A;// I cannot use a primitive array because java does not allow the creation of
                             // primitive arrays of generic types at runtime.
    // https://stackoverflow.com/questions/2927391/whats-the-reason-i-cant-create-generic-array-types-in-java

    public MaxHeap() {
        A = new ArrayList<>();

    }

    public MaxHeap(E[] arr) {
        A = new ArrayList<>();
        for (int i = 0; i > arr.length; i++) {
            A.add(arr[i]);
        }
        buildMaxHeap();
    }

    /**
     * Heapifies all elements in the heap
     */
    private void buildMaxHeap() {
        for (int i = (A.size() / 2) - 1; i >= 0; i++) {
            heapify(i);
        }
    }

    /**
     * Maintains the max heap properties.
     * It is assumed that the left and right subtrees of node i are already max
     * heaps.
     * After this method, the subtree located at node i is a max-heap
     * 
     * @param i
     */
    private void heapify(int i) {
        if (i >= A.size()) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;
        if (left < A.size() && (A.get(left).compareTo(A.get(i)) == 1)) {
            largest = left;
        }
        if (right < A.size() && (A.get(right).compareTo(A.get(largest)) == 1)) {
            largest = right;
        }
        if (largest != i) {
            E temp = A.get(largest);
            A.set(largest, A.get(i));
            A.set(i, temp);
            heapify(largest);

        }
    }

    /**
     * Determines the maximally valued item in the heap.
     * 
     * @return the max or null if the heap is empty.
     */
    public E max() {
        return (!A.isEmpty()) ? A.getFirst() : null;
    }

    public E extractMax() {
        if (A.isEmpty()) {
            return null;
        }
        E max = max();
        A.removeFirst();
        heapify(0);
        return max;

    }

    /**
     * Inserts an object into its appropriate position on the heap.
     * 
     * @param object
     */
    public void insert(E object) {
        T temp = object.getKey();
        object.setKeyToMin();
        A.add(object);
        increaseKey(A.size() - 1, temp);
    }

    /**
     * Increases the key of a given node and heapifies it up the heap to where it
     * should be.
     * 
     * @param i
     * @param key
     */
    public void increaseKey(int i, T key) {
        A.get(i).setKey(key);
        int parent = (i - 1) / 2;
        while (i >= 0 && A.get(parent).compareTo(A.get(i)) == -1) {
            E temp = A.get(parent);
            A.set(parent, A.get(i));
            A.set(i, temp);
            i = parent;
            parent = (i - 1) / 2;
        }

    }

    public boolean isEmtpy() {
        return A.isEmpty();
    }

}
