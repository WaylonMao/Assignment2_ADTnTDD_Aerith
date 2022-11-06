package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.Iterator;
import utilities.MyQueue;

import static org.junit.Assert.*;

/**
 * This class is used to test the MyQueue class.
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 */
public class MyQueueTest<E> {

    private MyQueue<Integer> queue = new MyQueue<>();
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;

    @Before
    public void setUp() throws Exception {
        queue = new MyQueue<>();
        one = Integer.valueOf(1);
        two = Integer.valueOf(2);
        three = Integer.valueOf(3);
        four = Integer.valueOf(4);
        five = Integer.valueOf(5);
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
        one = null;
        two = null;
        three = null;
        four = null;
        five = null;
    }



    /**
     * Test method for {@link utilities.MyQueue#MyQueue()}.
     */
    @Test
    public void testConstructor() {
        boolean expected = true;
        boolean actual = queue != null;
        assertEquals("Queue was not created", expected, actual);

    }

    /**
     * Test method for {@link utilities.MyQueue#enqueue<E>}.
     */
    @Test
    public void testEnqueue() {
        queue.enqueue(one);
        int expected = queue.peek();
        int actual = one;
        // test if the element is added to the queue
        assertEquals(expected, actual);
        // test if the size of the queue is increased
        assertEquals(1, queue.size());
        // test null element
        try {
            queue.enqueue(null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link MyQueue#dequeue()}.
     */
    @Test
    public void testDequeue() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        int expected = queue.dequeue();
        int actual = one;
        int expectedSize = 4;
        // test if the element is removed from the queue
        assertEquals(expected, actual);
        // test if the size of the queue is decreased
        assertEquals(expectedSize, queue.size());
        // test empty queue exception
        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link utilities.MyQueue#peek()}.
     */
    @Test
    public void testPeek() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        int expected = queue.peek();
        int actual = one;
        // test if the element is returned from the queue
        assertEquals(expected, actual);
        // test empty queue exception
        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.peek();
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    /**
     * Test method for {@link MyQueue#dequeueAll()}.
     */
    @Test
    public void testDequeueAll() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        queue.dequeueAll();
        boolean expected = queue.isEmpty();
        boolean actual = true;
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link utilities.MyQueue#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        queue.dequeueAll();
        boolean expected = queue.isEmpty();
        boolean actual = true;
       assertEquals(expected, actual);

    }

    /**
     * Test method for {@link utilities.MyQueue#toArray()}.
     */
    @Test
    public void testToArray() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        Object[] expected = queue.toArray();
        Object[] actual = new Object[]{one, two, three, four, five};
        // test if the array is returned
        assertArrayEquals(expected, actual);
        // test order of the array
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);
        assertEquals(expected[3], actual[3]);
        assertEquals(expected[4], actual[4]);
    }


    /**
     * Test method for {@link utilities.MyQueue#toArray(E[])}.
     */
    @Test
    public void testToArrayEArray() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        Integer[] expected = queue.toArray(new Integer[queue.size()]);
        Integer[] actual = new Integer[]{one, two, three, four, five};
        assertArrayEquals(expected, actual);

    }


    /**
     * Test method for {@link MyQueue#iterator()}.
     */
    @Test
    public void testIterator() {
        Iterator<Integer> iterator = queue.iterator();
        boolean expected = iterator != null;
        boolean actual = true;
        assertEquals(expected, actual);


    }

    /**
     * Test method for {@link utilities.MyQueue#size()}.
     */
    @Test
    public void testSize() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        int expected = queue.size();
        int actual = 5;
        assertEquals(expected, actual);
    }
    @Test
    public  void  testIsFull(){
        int size = 5;
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        boolean expected = queue.isFull();
        boolean actual = true;
        assertEquals(expected, actual);
    }
}
