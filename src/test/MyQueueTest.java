package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;
import utilities.MyQueue;




/**
 * @author Chris Wang
 * @date 2022-10-26
 */
public class MyQueueTest<E> {

    private MyQueue<Integer> queue = new MyQueue<>();
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;

    @BeforeEach
    void setUp() throws Exception {
        queue = new MyQueue<>();
        one = Integer.valueOf(1);
        two = Integer.valueOf(2);
        three = Integer.valueOf(3);
        four = Integer.valueOf(4);
        five = Integer.valueOf(5);
    }

    @AfterEach
    void tearDown() throws Exception {
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
    void testConstructor() {
        boolean expected = true;
        boolean actual = queue != null;
        Assertions.assertEquals(expected, actual, "Queue was not created");

    }

    /**
     * Test method for {@link utilities.MyQueue#enqueue<E>}.
     */
    @Test
    void testEnqueue() {
        queue.enqueue(one);
        int expected = queue.peek();
        int actual = one;
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Test method for {@link MyQueue#dequeue()}.
     */
    @Test
    void testDequeue() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        int expected = queue.dequeue();
        int actual = one;
        int expectedSize = 4;
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedSize, queue.size());
    }

    /**
     * Test method for {@link utilities.MyQueue#peek()}.
     */
    @Test
    void testPeek() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        int expected = queue.peek();
        int actual = one;
        Assertions.assertEquals(expected, actual);

    }

    /**
     * Test method for {@link MyQueue#dequeueAll()}.
     */
    @Test
    void testDequeueAll() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        queue.dequeueAll();
        boolean expected = queue.isEmpty();
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Test method for {@link utilities.MyQueue#isEmpty()}.
     */
    @Test
    void testIsEmpty() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        queue.dequeueAll();
        boolean expected = queue.isEmpty();
        boolean actual = true;
        Assertions.assertEquals(expected, actual);

    }

    /**
     * Test method for {@link utilities.MyQueue#toArray()}.
     */
    @Test
    void testToArray() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        Object[] expected = queue.toArray();
        Object[] actual = new Object[]{one, two, three, four, five};
        Assertions.assertArrayEquals(expected, actual);
    }


    /**
     * Test method for {@link utilities.MyQueue#toArray(E[])}.
     */
    @Test
    void testToArrayEArray() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        Integer[] expected = queue.toArray(new Integer[queue.size()]);
        Integer[] actual = new Integer[]{one, two, three, four, five};
        Assertions.assertArrayEquals(expected, actual);

    }


    /**
     * Test method for {@link MyQueue#iterator()}.
     */
    @Test
    void testIterator() {
        Iterator<Integer> iterator = queue.iterator();
        boolean expected = iterator != null;
        boolean actual = true;
        Assertions.assertEquals(expected, actual);


    }

    /**
     * Test method for {@link utilities.MyQueue#size()}.
     */
    @Test
    void testSize() {
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        int expected = queue.size();
        int actual = 5;
        Assertions.assertEquals(expected, actual);
    }
}
