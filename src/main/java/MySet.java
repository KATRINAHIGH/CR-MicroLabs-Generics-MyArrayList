import java.util.Arrays;
import java.util.Collection;


public class MySet<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] inputArray;
    private int size;

    public MySet() {
        this(DEFAULT_CAPACITY);
    }

    public MySet(int capacity) {
        this.inputArray = new Object[capacity];
        this.size = 0;
    }


    /**
     * Get set size
     * @return current number of elements in this list
     */
    public int size() {
        return this.size;
    }

    /**
     * Add Object o to set
     * @param element - object to be added to this set
     * @return true if this set did not already contain the specified element. false if set already contains element
     * and leaves the set unchanged
     */
    public boolean add(Object element) {
        if (element == null) {
            throw new NullPointerException("Specified element can't be null");
        }
        if (this.contains(element)) {
            return false;
        }

        this.ensureCapacity();
        this.inputArray[this.size++] = element;

        return true;
    }

    /**
     * Check if set is empty
     * @return true if this set contains no elements
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @param element to be checked
     * @return true if this set contains the specified element
     */
    public Boolean contains(Object element) {
        if (element == null) {
            throw new NullPointerException("Specified element can't be null");
        }
        for (int i = 0; i < this.size; i++) {
            if (this.inputArray[i].equals(element)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Removes the specified element from this set if it is present
     * @param element - element to be removed from this set, if present
     * @return true if this set contained the specified element
     */
    public boolean remove(Object element) {
        if (element == null) {
            throw new NullPointerException("Specified element can't be null");
        }
        boolean canRemove = false;
        int indexOf = 0;
        for (int i = 0; i < this.inputArray.length; i++) {
            if (this.inputArray[i].equals(element)) {
                indexOf = i;
                canRemove = true;
                break;
            }
        }

        if (canRemove) {
            this.inputArray[indexOf] = null;
            this.inputArray = shiftAllNullsToEnd(this.inputArray);
            this.size--;
        }

        return canRemove;
    }

    /**
     * Adds all of the elements in the specified collection to this set if they're not already present
     * returns false if ANY element could not be added.  If the specified collection is also a set, the
     * addAll operation effectively modifies this set so that its value is the union of the two sets.
     *
     * @param container collection containing elements to be added to this set
     * @return true if this set changed as a result of the call
     */
    public boolean addAll(Collection container) {
        boolean allAdded = container.size() > 0;
        for (Object o : container) {
            if (!this.add(o)) {
                allAdded = false;
            }
        }
        return allAdded;
    }

    /**
     * Removes all of the elements from this set
     * The set will be empty after this call returns.
     */
    public void clear() {
        this.inputArray = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Get array representation of set
     * @return
     */
    public Object[] toArray() {
        return  trimTrailingNull(this.inputArray);
    }

    /**
     * NullPointerException - if the specified collection contains one or more null elements
     * and this set does not permit null elements, or if the specified collection is null
     * Trim the null values from an array.
     * @param arr array to be altered assumed that all non-null values are contiguous starting at index 0
     * @return array with with trailing nulls removed
     */
    private static Object[] trimTrailingNull(Object[] arr) {
        int lastNotNull = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                lastNotNull++;
            } else {
                break;
            }
        }
        if (lastNotNull == 0) {
            return new Object[0];
        }

        Object[] trimmed = new Object[lastNotNull];
        for (int i = 0; i <= lastNotNull; i++) {
            trimmed[i] = arr[i];
        }

        return trimmed;
    }

    /**
     * Shift all null values to the end and make non-null values contiguous starting at index 0
     * @param arr array to be altered
     * @return array altered
     */
    private static Object[] shiftAllNullsToEnd(Object[] arr) {
        int j = 0;
        Object[] result = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                result[j++] = arr[i];
            }
        }

        return result;
    }

    /**
     * Increases the capacity of the backing array, if necessary,
     * to ensure that it can hold at least the number of elements
     */
    private void ensureCapacity() {
        if (this.size >= this.inputArray.length) {
            int newCapacity = this.inputArray.length + DEFAULT_CAPACITY;
            this.inputArray = Arrays.copyOf(this.inputArray, newCapacity);
        }
    }

}











