/**
 *
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.MyArrayList;

/**
 * @author levan
 *
 */
public class MyArrayListTest {

    private static MyArrayList<String> list;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        list = new MyArrayList<String>();
        list.add("harry");
        list.add("ron");

    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Test method for {@link utilities.MyArrayList#size()}.
     */
    @Test
    public void testSize() {
        int expected = 2;
        int actual = list.size();
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#clear()}.
     */
    @Test
    public void testClear() {
        int expected = 0;
        list.clear();
        int actual = list.size();
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
     */
    @Test
    public void testAddIntE() {

    }



    /**
     * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
     */
    @Test
    public void testAddE() {
        list.add("last");
        int expected = 3;
        int actual = list.size();
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
     */
    @Test
    public void testAddAll() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#get(int)}.
     */
    @Test
    public void testGet() {
        list.add(1, "hermione");
        String expected = "hermione";
        String actual = list.get(1);
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#remove(int)}.
     */
    @Test
    public void testRemoveInt() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveE() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
     */
    @Test
    public void testSet() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
     */
    @Test
    public void testContains() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#toArray()}.
     */
    @Test
    public void testToArrayEArray() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#toArray()}.
     */
    @Test
    public void testToArray() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link utilities.MyArrayList#iterator()}.
     */
    @Test
    public void testIterator() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
     */
    @Test
    public void testEquals() {
        fail("Not yet implemented"); // TODO
    }

}
