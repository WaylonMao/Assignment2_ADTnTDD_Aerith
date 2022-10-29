/**
 *
 */
package test;

import static org.junit.Assert.*;

import org.junit.*;

import utilities.Iterator;
import utilities.MyArrayList;


/**
 * @author Hoa Le
 */
public class MyArrayListTest {

    // attributes
    private MyArrayList<Integer> list;
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;


    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUpBeforeClass() throws Exception {
        list = new MyArrayList<Integer>();
        one = Integer.valueOf(1);
        two = Integer.valueOf(2);
        three = Integer.valueOf(3);
        four = Integer.valueOf(4);
        five = Integer.valueOf(5);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDownAfterClass() throws Exception {
        list = null;
        one = null;
        two = null;
        three = null;
        four = null;
        five = null;
    }

    @Test
    public void testConstructor() {
        boolean expected = true;
        list = new MyArrayList<Integer>();
        boolean actual = list != null;
        assertEquals("List was not create", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#size()}.
     */
    @Test
    public void testSize() {
        list.add(one);
        list.add(two);

        int expected = 2;
        int actual = list.size();
        assertEquals("Size was not create", expected, actual);
    }

    /**
     * S
     * Test method for {@link utilities.MyArrayList#clear()}.
     */
    @Test
    public void testClear() {
        int expected = 0;
        list.add(one);
        list.add(two);
        list.add(three);
        list.clear();
        int actual = list.size();
        assertEquals("The list was not clear after using Clear method", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
     */
    @Test
    public void testAddIntE_returnTrue() {
        int expected = 3;
        list.add(one);
        list.add(three);
        list.add(1, two);
        int actual = list.get(2);
        assertEquals("Element not added to the correct position in the list", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
     */
    @Test
    public void testAddIntE_NullPointerException() {
        list.add(two);
        list.add(three);
        one = null;
        try {
            list.add(0, one);
            fail("NullPointerException was not thrown");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddIntE_IndexOutOfBoundsException() {
        list.add(0, one);
        list.add(1, two);
        list.add(2, three);
        try {
            list.add(4, four);
            fail("IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddIntE_ItemAddedCorrectly_Empty() {
        int expected = 1;
        list.add(0, one);
        int actual = list.get(0);
        assertEquals("Element added was not correct position", expected, actual);
    }

    @Test
    public void testAddIntE_ItemAddedCorrectly_Tail() {
        int expected = 2;
        list.add(0, one);
        list.add(1, two);
        list.add(1, three);
        //Expected: 1 3 2
        int actual = list.get(2);
        assertEquals("Element added was not correct position", expected, actual);
    }

    @Test
    public void testAddIntE_ItemAddedCorrectly_Head() {
        int expected = 3;
        list.add(0, one);
        list.add(1, two);
        list.add(0, three);
        //Expected 3 1 2
        int actual = list.get(0);
        assertEquals("Element added was not correct position", expected, actual);
    }

    @Test
    public void testAddIntE_ItemAddedCorrectly_Order() {
        Integer[] expected = new Integer[]{1, 2, 3};
        list.add(0, three);
        list.add(0, two);
        list.add(0, one);
        // Expected: 1,2,3
        Integer[] actual = new Integer[list.size()];
        actual = list.toArray(actual);
        assertArrayEquals("Element added was not correct position", expected,actual);
    }

    @Test
    public void testIntAddE_ResizeArray() {
        int expected = 11;
        list.add(0, one);
        list.add(1, two);
        list.add(2, three);
        list.add(3, four);
        list.add(4, five);
        list.add(0, one);
        list.add(1, two);
        list.add(2, three);
        list.add(3, four);
        list.add(4, five);

        // default size is 10
        // after adding 10 elements, the size should be 20
        list.add(0, one);
        // Expected: 1,2,4,3,5,1,2,4,3,5,1
        int actual = list.size();
        assertEquals("ArrayList was not resize properly", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
     */
    @Test
    public void testAddE_ReturnArrayTrue() {
        list.add(one);
        list.add(two);
        list.add(three);
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(four);
        list2.add(five);
        list.addAll(list2);
        int expected = 5;
        int actual = list.size();
        assertEquals("Array was not added to the list", expected, actual);
    }

    @Test
    public void testAddE_NullPointerException() {
        list.add(one);
        list.add(two);
        try {
            list.addAll(null);
            fail("NullPointerException was not thrown");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddE_ItemAddedCorrectly_OneElement() {
        int expected = 4;
        list.add(one);
        list.add(two);
        list.add(three);
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(four);
        list.addAll(list2);
        // Test element added to the end of the list
        int actual = list.get(3);
        assertEquals("Element added was not correct position", expected, actual);
    }

    @Test
    public void testAddE_ItemAddedCorrectly_MultipleItemsAndResize() {
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        //default size is 10
        //after adding 10 elements, the size should be 20
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(four);
        list.addAll(list2);
        int expected = 11;
        int actual = list.size();
        assertEquals("Element added was not correct position", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
     */
    @Test
    public void testAddAll_ItemsAddedCorrectlyHead() {
        int expected = 2;
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(one);
        list.addAll(list2);
        int actual = list.get(0);
        assertEquals("Element added was not correct position", expected, actual);
    }

    @Test
    public void testAddAll_ItemsAddedCorrectlyTail() {
        int expected = 1;
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(one);
        list.addAll(list2);
        int actual = list.get(4);
        assertEquals("Element added was not correct position", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
     */
    @Test
    public void testContains_returnTrue() {
        list.add(one);
        list.add(two);
        list.add(three);
        //expected: 1,2,3
        int expected = 3;
        assertTrue("Element added was not included in the list", list.contains(expected));
    }

    /**
     * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
     */
    @Test
    public void testContains_returnFalse() {
        list.add(one);
        list.add(two);
        list.add(three);
        //expected: 1,2,3
        int expected = 4;
        assertFalse("Element added was not included in the list", list.contains(expected));
    }


    /**
     * Test method for {@link utilities.MyArrayList#get(int)}.
     */
    @Test
    public void testGetInt_One() {
        list.add(one);
        list.add(two);
        list.add(three);
        int expected = 2;
        int actual = list.get(1);
        assertEquals("Element added was not correct position", expected, actual);
    }

    @Test
    public void testGetInt_Head() {
        list.add(one);
        list.add(two);
        list.add(three);
        int expected = 1;
        int actual = list.get(0);
        System.out.println(actual);
        assertEquals("Element added was not correct position", expected, actual);

    }

    @Test
    public void testGetInt_Tail() {
        list.add(one);
        list.add(two);
        list.add(three);
        int expected = 3;
        int actual = list.get(2);
        assertEquals("Element added was not correct position", expected, actual);

    }

    @Test
    public void testGetInt_IndexOutOfBoundsException_greaterThanSize() {
        list.add(one);
        list.add(two);
        list.add(three);
        try {
            list.get(3);
            fail("IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetInt_IndexOutOfBoundsException_lessThanZero() {
        list.add(one);
        list.add(two);
        list.add(three);
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(-1));
    }

    /**
     * Test method for {@link utilities.MyArrayList#remove(int)}.
     */
    @Test
    public void testRemoveInt_Correct() {
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        //expected: 1,2,3,4,5
        int expected = 3;
        int actual = list.remove(2);
        assertEquals("Element removed was not correct position", expected, actual);
    }

    @Test
    public void testRemoveInt_CorrectHead() {
        list.add(one);
        list.add(two);
        //expected: 1,2
        int expected = 1;
        int actual = list.remove(0);
        assertEquals("Element removed was not correct position", expected, actual);
    }

    @Test
    public void testRemoveInt_CorrectTail() {
        list.add(one);
        list.add(two);
        //expected: 1,2
        int expected = 2;
        int actual = list.remove(1);
        assertEquals("Element removed was not correct position", expected, actual);

    }

    @Test
    public void testRemoveInt_IndexOutOfBoundsException_greaterThanSize() {
        list.add(one);
        list.add(two);
        list.add(three);
        try {
            list.remove(3);
            fail("IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRemoveInt_IndexOutOfBoundsException_lessThanZero() {
        list.add(one);
        list.add(two);
        list.add(three);
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.remove(-1));
    }

    /**
     * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveE() {
        list.add(three);
        list.add(two);

        //expected: 3,2
        int expected = 3;
        int actual = list.remove(three);
        assertEquals("Element removed was not correct position", expected, actual);
    }

    @Test
    public void testRemoveE_Head() {
        list.add(one);
        list.add(two);
        //expected: 1,2
        int expected = 1;
        int actual = list.remove(one);
        assertEquals("Element removed was not correct position", expected, actual);

    }

    @Test
    public void testRemoveE_Tail() {
        list.add(one);
        list.add(two);
        //expected: 1,2
        int expected = 2;
        int actual = list.remove(two);
        assertEquals("Element removed was not correct position", expected, actual);

    }

    @Test
    public void testRemoveE_Null() {
        list.add(one);
        list.add(two);
        list.add(three);
        //expected: 1,2,3
        try {
            list.remove(null);
            fail("NullPointerException was not thrown");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
     */
    @Test
    public void testSet() {
        int expected = 4;
        list.add(one);
        list.add(two);
        list.set(1, 4);
        int actual = list.get(1);
        assertEquals("Element added was not correct position", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#isEmpty()}.
     */
    @Test
    public void testIsEmpty_True() {
        assertTrue("List is not empty", list.isEmpty());
    }

    @Test
    public void testIsEmpty_False() {
        list.add(one);
        assertFalse("List is empty", list.isEmpty());
    }


    /**
     * Test method for {@link utilities.MyArrayList#toArray()}.
     */
    @Test
    public void testToArrayEArray() {
        list.add(one);
        list.add(two);
        list.add(three);
        Object[] expected = {1, 2, 3};
        Object[] actual = list.toArray();
        assertArrayEquals("Array is not correct", expected, actual);
    }

    @Test
    public void testToArrayEArray_Null() {
        try {
            Integer[] nullArray = null;
            list.toArray(nullArray);
            fail("NullPointerException was not thrown");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link utilities.MyArrayList#toArray()}.
     */
    @Test
    public void testToArray() {
        list.add(one);
        list.add(two);
        list.add(three);
        Object[] expected = {1, 2, 3};
        Object[] actual = list.toArray();
        assertArrayEquals("Array is not correct", expected, actual);
    }

    /**
     * Test method for {@link utilities.MyArrayList#iterator()}.
     */
    @Test
    public void testIterator() {
        list.add(one);
        list.add(two);
        list.add(three);
        Iterator<Integer> it = list.iterator();
        Integer[] expected = {1, 2, 3};
        Integer[] actual = new Integer[list.size()];
        while (it.hasNext()) {
            for (int i = 0; i < actual.length; i++) {
                actual[i] = it.next();
            }
        }
        assertArrayEquals("Iterator is not correct", expected, actual);
    }


}
