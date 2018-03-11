import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMySet {

    //---------------test MySet constructor

    @Test
    public void testConstructorDefaultSize() {
        int expectedElementCount = 0;
        MySet<Integer> testSet = new MySet<>();

        int actualElementCount = testSet.size();

        Assert.assertEquals(expectedElementCount, actualElementCount);
    }

    @Test
    public void testConstructorSizeIncrease() {
        int expectedSize = 3;
        MySet<String> testSet = new MySet<>();
        testSet.add("this");
        testSet.add("that");
        testSet.add("andTheOtherThing");

        int actualLength = testSet.size();

        Assert.assertEquals(expectedSize, actualLength);
    }

    @Test
    public void testConstructoreIngnoreDup() {
        MySet<Integer> testSet = new MySet<>();

        boolean unique = testSet.add(10);
        boolean dup = testSet.add(10);

        Assert.assertTrue(unique);
        Assert.assertFalse(dup);
        Assert.assertEquals(1, testSet.size());
    }

    @Test
    public void testConstructorIgnoresMultipleDups() {
        MySet<Integer> testSet = new MySet<>();
        testSet.add(10);
        testSet.add(20);

        boolean dup = testSet.add(10);
        boolean dup2 = testSet.add(20);
        boolean dup3 = testSet.add(20);

        Assert.assertFalse(dup);
        Assert.assertFalse(dup2);
        Assert.assertFalse(dup3);
        Assert.assertEquals(2, testSet.size());
    }


    //------------>What I'm trying to do here is test that the constructor assigns correct type to generic object.
    //not sure if I'm testing this correctly. Come back to it.
    @Test
    public void testConstructorLongArray() {
        MySet<Long> testSet = new MySet<>();
        testSet.add(50L);
        testSet.add(60L);
        testSet.add(70L);
        int expected = 3;

        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorStringArray() {
        MySet<String> testSet = new MySet<>();
        testSet.add("this");
        testSet.add("that");
        testSet.add("andTheOtherThing");
        int expected = 3;

        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorObjectArray() {
        MySet<Object> testSet = new MySet<>();
        testSet.add("this");
        testSet.add("that");
        testSet.add("andTheOtherThing");
        int expected = 3;

        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }


    //---------------test MySet size()

    @Test
    public void testSizeReturnsElementCountIfLessThanCapacity() {
        MySet<Integer> testSet = new MySet<>(20);
        testSet.add("this");
        testSet.add("that");
        testSet.add("andTheOtherThing");
        int expected = 3;

        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSizeReturnsElementCountIfMaxCapacity() {
        MySet<Integer> testSet = new MySet<>(5);
        testSet.add("this");
        testSet.add("that");
        testSet.add("andTheOtherThing");
        testSet.add("allTheThings");
        testSet.add("SomeThings");
        int expected = 5;

        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }


    //---------------test MySet isEmpty()
    @Test
    public void testIsEmptyReturnsFalse() {
        MySet<Integer> testSet = new MySet<>(5);
        testSet.add("this");
        testSet.add("that");
        testSet.add("andTheOtherThing");

        Boolean actualElements = testSet.isEmpty();

        Assert.assertEquals(false, actualElements);
    }

    @Test
    public void testIsEmptyReturnsTrue() {
        MySet<Integer> testSet = new MySet<>(0);

        Boolean actualElements = testSet.isEmpty();

        Assert.assertEquals(true, actualElements);
    }

    //---------------test MySet contains()
    @Test
    public void testContainsTrue() {
        MySet<Integer> testSet = new MySet<>(5);
        testSet.add("thisThing");
        testSet.add("thatThing");
        testSet.add("something");
        testSet.add("theOtherThing");

        Boolean actual = testSet.contains("something");

        Assert.assertEquals(true, actual);

    }

    @Test
    public void testContainsFalse() {
        MySet<Integer> testSet = new MySet<>(5);
        testSet.add("thisThing");
        testSet.add("thatThing");
        testSet.add("theOtherThing");

        Boolean actual = testSet.contains("SoManyThings");

        Assert.assertEquals(false, actual);

    }


    @Test(expected = NullPointerException.class)
    public void testContainsThrowsExceptionIfElementSpecifiedNull() {
        MySet<Integer> testSet = new MySet<>();
        testSet.contains(null);
    }

    //------------test Myset Bool add(E e)
    @Test //Check that element is in list after adding
    public void testAdd_SetContainsElementAfterAdd_True() {
        MySet<Integer> testSet = new MySet<>();
        testSet.add(10);

        Boolean actual = testSet.contains(10);

        Assert.assertEquals(true, actual);
    }

//    @Test
//    public void testAddAppendsAtEndOfList() {
//        MySet<String> testSet = new MySet<>();
//        String expected = "andTheOtherThing";
//        testSet.add("this");
//        testSet.add("that");
//        testSet.add(expected);
//        String actual = testSet.get(2);
//        Assert.assertEquals(expected, actual);
//    }

    @Test //return true if set did not contain the specified element
    public void testAdd_DoesNotContainElement_True() {
        MySet<String> testSet = new MySet<>();
        testSet.add("thisThing");
        testSet.add("thatThing");
        testSet.add("theOtherThing");

        Boolean actual = testSet.add("something");

        Assert.assertEquals(true, actual);
    }

    @Test//return false if set already contains element
    public void testAdd_AlreadyContainsElement_False() {
        MySet<String> testSet = new MySet<>();
        testSet.add("thisThing");
        testSet.add("thatThing");
        testSet.add("theOtherThing");

        Boolean actual = testSet.add("thatThing");

        Assert.assertEquals(false, actual);
    }

//    @Test //returns false if set already contains element make sure leaves set unchanged
//    public void testAdd_AlreadyContainsElement_AddDoesNotAlterSet_True() {
//        MySet<String> testSet = new MySet<>();
//        testSet.add(10);
//        testSet.add(20);
//        testSet.add(30);
//        Boolean actual = testSet.add(20);
//        Assert.assertEquals(false, actual);
//    }

    @Test //make sure you can't add duplicates
    public void testAdd_MultipleDuplicates_False() {
        MySet<Integer> testSet = new MySet<>(5);
        boolean unique1 = testSet.add(10);
        boolean dup1 = testSet.add(10);
        boolean unique2 = testSet.add(20);
        boolean dup2 = testSet.add(10);
        boolean dup3 = testSet.add(20);

        Assert.assertTrue(unique1);
        Assert.assertFalse(dup1);
        Assert.assertTrue(unique2);
        Assert.assertFalse(dup2);
        Assert.assertFalse(dup3);
        Assert.assertEquals(2, testSet.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAdd_ThrowsExceptionIfElementSpecifiedNull() {
        MySet<String> testObject = new MySet<>();
        testObject.add(null);
    }


    //------------test Myset Bool remove(Object o)

    @Test //remove returns false when the element does not exist
    public void testRemove_DoesNotContainElementAndRemoves_False() {
        MySet<Integer> testSet = new MySet<>();
        testSet.add(10);
        testSet.add(20);
        testSet.add(30);

        Boolean actual = testSet.remove(400);

        Assert.assertEquals(false, actual);
    }

    @Test //removes element from list and returns true
    public void testRemove_ContainsElementAndRemoves_True() {
        MySet<Integer> testObject = new MySet<>();
        testObject.add(10);
        testObject.add(20);
        testObject.add(30);

        Boolean actual = testObject.remove(20);

        Assert.assertEquals(true, actual);

    }

    @Test //remove element from list and check to see if it contains that element
    public void testRemove_SetNoLongerContainsElement_False() {

        MySet<String> testSet = new MySet<>();
        testSet.add("this");
        testSet.add("that");
        testSet.add("theOtherThing");

        testSet.remove("that");
        Boolean actual = testSet.contains("that");

        Assert.assertEquals(false, actual);

    }

    @Test(expected = NullPointerException.class)
    public void testRemove_ThrowsExceptionIfElementSpecifiedNull() {
        MySet<String> testSet = new MySet<>();
        testSet.remove(null);
    }

    //------------test Myset void clear()
    @Test
    public void testClearSetsSizeToZero() {
        MySet<Integer> testSet = new MySet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
        testSet.add(3);
        testSet.add(4);

        testSet.clear();
        int actual = testSet.size();

        Assert.assertEquals(0, actual);

    }
//---------------test MySet toArray() Object[] toArray()
    /**
     * Returns an array containing all of the elements in this set
     * the returned array will be "safe" in that no references to it are maintained by this set
     * meaning this method must allocate a new array if if this set is backed by an array
     * user should be free to modify the returned array
     */

    //--------------test Myset toArray() <T> T[] toArray(T[] a)


    //------------test Myset Bool containsAll(Collection<?> c)
    /**  Returns true if this set contains all of the elements of the specified collection.
     If the specified collection is also a set, this method returns true if it is a subset of this set.
     c - collection to be checked for containment in this set
     Returns:
     true if this set contains all of the elements of the specified collection
     NullPointerException - if the specified collection contains one or more null elements and
     this set does not permit null elements (optional), or if the specified collection is null*/


    //------------test Myset Bool addAll(Collection<? extends E> c)
//    @Test
//    public void testAddAll_Union2Sets() {
//        Integer[] array1 = {10, 20, 30, 40};
//        Integer[] array2 = {50, 60, 70, 80};
//        MySet<Integer> testOb = new MySet<>();
//        testOb.addAll(array1);
//        testOb.addAll(array2);
//
//        Integer[] expected = {10, 20, 30, 40, 50, 60, 70, 80};
//        Integer[] actual = testOb.toArray(new Integer[0]);
//        Assert.assertArrayEquals(expected, actual);
//    }


    //------------test Myset boolean retainAll(Collection<?> c)
    /**Retains only the elements in this set that are contained in the specified collection
     (optional operation). In other words, removes from this set all of its elements that are not
     contained in the specified collection. If the specified collection is also a set, this operation
     effectively modifies this set so that its value is the intersection of the two sets.
     Parameters:
     c - collection containing elements to be retained in this set
     Returns:
     true if this set changed as a result of the call
     NullPointerException - if this set contains a null element and the specified
     collection does not permit null elements (optional), or if the specified collection is null
     */


    //------------test Myset boolean removeAll(Collection<?> c)
    /** Removes from this set all of its elements that are contained in the specified collection (optional operation).
     If the specified collection is also a set, this operation effectively modifies this set so that its value is
     the asymmetric set difference of the two sets.
     Parameters:
     c - collection containing elements to be removed from this set
     Returns:
     true if this set changed as a result of the call
     NullPointerException - if this set contains a null element and the specified collection does not permit null
     elements (optional), or if the specified collection is null
     See Also:
     remove(Object), contains(Object)*/


    //------------test boolean equals(Object o)
    /**Compares the specified object with this set for equality.
     Returns true if the specified object is also a set, the two sets have the same size,
     and every member of the specified set is contained in this set (or equivalently, every member
     of this set is contained in the specified set). This definition ensures that the equals method
     works properly across different implementations of the set interface.
     Overrides:
     equals in class Object
     Parameters:
     o - object to be compared for equality with this set
     Returns:
     true if the specified object is equal to this set
     See Also:
     Object.hashCode(), HashMap*/


    //------------test int hashCode()
    /**Returns the hash code value for this set. The hash code of a set is defined to be the sum of the
     hash codes of the elements in the set, where the hash code of a null element is defined to be zero.
     This ensures that s1.equals(s2) implies that s1.hashCode()==s2.hashCode() for any two sets s1 and s2, as
     required by the general contract of Object.hashCode().
     Overrides:
     hashCode in class Object
     Returns:
     the hash code value for this set
     See Also:
     Object.equals(Object), equals(Object)*/

}




