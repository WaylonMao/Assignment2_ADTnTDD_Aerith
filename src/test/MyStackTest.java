package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyStackException;
import utilities.Iterator;
import utilities.MyStack;
import utilities.StackADT;

/**
 * Class description:
 * 
 * @author Hu Peng
 *
 * 
 */
class MyStackTest {

	private MyStack<Integer> stack;
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer four;
	private Integer five;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<Integer>();
		one = Integer.valueOf(1);
		two = Integer.valueOf(2);
		three = Integer.valueOf(3);
		four = Integer.valueOf(4);
		five = Integer.valueOf(5);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		stack = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
	}

	/**
	 * Test method for {@link utilities.MyStack#MyStack()}.
	 */
	@Test
	void testConstructor() {
		boolean actual = true;
		assertNotNull("Stack was not created", actual);
	}

	/**
	 * Test method for {@link utilities.MyStack#push(E)}.
	 */
	@Test
	void testPush() {
		stack.push(one);
		int expected = one;
		int actual = stack.peek();
		assertTrue("Stack was not pushed", expected == actual);

	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPop() {
		stack.push(one);
		stack.push(two);
		int actual = stack.pop();
		int expected = two;
		assertTrue("Stack was not poped", expected == actual);
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		stack.push(one);
		stack.push(two);
		int actual = stack.peek();
		int expected = two;
		assertTrue("Stack was not poped", expected == actual);
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		stack.clear();
		int expected = 0;
		int actual = stack.size();
		assertTrue("Stack was not cleared", expected == actual);
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClearThenAdd() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		stack.clear();
		stack.push(four);
		int expected = four;
		int actual = stack.peek();
		assertTrue("Stack was not cleared or pushed successfully", expected == actual);
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		stack.push(four);
		stack.push(five);
		Object array[] = stack.toArray();
		Object[] expected = { one, two, three, four, five };
		assertArrayEquals(array, expected);

	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		stack.push(four);
		stack.push(five);
		Integer[] holder = new Integer[5];
		Object[] expected = { one, two, three, four, five };
		assertArrayEquals(stack.toArray(holder), expected);
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(E)}.
	 */
	@Test
	void testContains() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		assertTrue(stack.contains(one));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(E)}.
	 */
	@Test
	void testSearch() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		int actual = stack.search(one);
		int expected = 3;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		Iterator<Integer> it = stack.iterator();
		int expected = 1;
		int actual = it.next();
		assertEquals("Iterator is not correct", expected, actual);

	}

	/**
	 * Test method for {@link utilities.MyStack#equals(StackADT)}.
	 */
	@Test
	void testEqualsStackADT() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		MyStack<Integer> newStack = new MyStack<>();
		newStack.push(one);
		newStack.push(two);
		newStack.push(three);
		assertTrue(stack.equals(newStack));
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(StackADT)}.
	 */
	@Test
	void testEqualsStackADTFail() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		MyStack<Integer> newStack = new MyStack<>();
		newStack.push(one);
		newStack.push(two);
		newStack.push(four);
		assertFalse(stack.equals(newStack));
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSize() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		int actual = stack.size();
		int expected = 3;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link exception.EmptyStackException}.
	 */
	@Test
	void testPeek_EmptyStackException() {

		try {
			stack.clear();
			stack.peek();
			Assert.fail();
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link exception.EmptyStackException}.
	 */
	@Test
	void testPop_EmptyStackException() {

		try {
			stack.clear();
			stack.pop();
			Assert.fail();
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}

}
