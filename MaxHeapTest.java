import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import javax.naming.NameAlreadyBoundException;

/**
 * Black-box unit tests for the MaxHeap class.
 *
 * @author Caleb Hottes
 */
class MaxHeapTest {

    /**
     * Test if the Heap is empty
     */
    @Test
    void testIsEmpty() {

        MaxHeap<TestItem, Integer> emptyHeap = new MaxHeap<TestItem, Integer>();
        assertTrue(emptyHeap.isEmtpy());

        MaxHeap<TestItem, Integer> nonEmptyHeap = new MaxHeap<TestItem, Integer>();
        nonEmptyHeap.insert(new TestItem(0));
        assertFalse(nonEmptyHeap.isEmtpy());

    }

    @Test
    void testInsert() {

        MaxHeap<TestItem, Integer> heap = new MaxHeap<TestItem, Integer>();
        heap.insert(new TestItem(0));
        assertTrue(heap.A.get(0).datum == 0);
        heap.insert(new TestItem(1));
        assertTrue(heap.A.get(0).datum == 1);
        heap = new MaxHeap<>();
        for (int i = 5; i > -5; i--) {
            heap.insert(new TestItem(i));
        }
        assertTrue(heap.A.size() == 10);
        assertTrue(heap.A.get(0).datum == 5);
        assertTrue(heap.A.get(1).datum == 4);
        assertTrue(heap.A.get(2).datum == 3);
        assertTrue(heap.A.get(3).datum == 2);
        assertTrue(heap.A.get(4).datum == 1);
        assertTrue(heap.A.get(5).datum == 0);
        assertTrue(heap.A.get(6).datum == -1);
        assertTrue(heap.A.get(7).datum == -2);
        assertTrue(heap.A.get(8).datum == -3);
        assertTrue(heap.A.get(9).datum == -4);
        assertTrue(validateHeap(heap));

        heap = new MaxHeap<>();
        Random r = new Random(568114);// make tests deterministic
        for (int i = 0; i < 1000; i++) {
            if (i == 14) {
                System.out.println();
            }
            heap.insert(new TestItem(r.nextInt()));
        }
        assertTrue(validateHeap(heap));

    }

    private boolean validateHeap(MaxHeap<TestItem, Integer> testHeap) {
        if (testHeap.A.size() < 1) {
            return true;
        }
        for (int i = 1; i < testHeap.A.size(); i++) {
            int parent = (i - 1) / 2;
            assertTrue(
                    testHeap.A.get(parent).compareTo(testHeap.A.get(i)) >= 0,

                    "Invalid heap! node " + i + " Is not less than its parent! Parent index: " + parent
                            + " child index: " + i + " parent value: " + testHeap.A.get(parent).datum + " Child value: "
                            + testHeap.A.get(i).datum);
        }
        return true;
    }

    protected class TestItem implements HeapItem<TestItem, Integer> {

        private int datum;

        public TestItem(int datum) {
            this.datum = datum;
        }

        public void setData(int toSet) {
            this.datum = toSet;
        }

        public int getData() {
            return datum;
        }

        @Override
        public int compareTo(TestItem o) {
            if (datum > o.getKey()) {
                return 1;
            } else if (datum < o.getKey()) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public void setKey(Integer key) {
            this.datum = key;
        }

        @Override
        public void incrementKey() {
            this.datum += 1;
        }

        @Override
        public Integer getKey() {
            return datum;
        }

        @Override
        public void setKeyToMin() {
            this.datum = Integer.MIN_VALUE;
        }

    }
}
