import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
            } else if (datum < 0) {
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
