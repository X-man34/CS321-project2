public interface HeapItem<E, T> extends Comparable<E> {
    public abstract void setKey(T key);

    public abstract void incrementKey();

    public abstract T getKey();

    /**
     * Set the key to a minimum value for comparison purposes.
     */
    public abstract void setKeyToMin();

}