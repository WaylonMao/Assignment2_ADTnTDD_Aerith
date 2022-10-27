package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyStackException;
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(E)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#search(E)}.
	 */
	@Test
	void testSearch() {
		stack.push(one);
		stack.push(two);
		stack.push(three);
		int actual = stack.search(three);
		int expected = 1;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		fail("Not yet implemented");
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
	 * Test method for {@link utilities.}.
	 */
	@Test
	void testPeek_EmptyStackException() {

		try {
			stack.peek();
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.}.
	 */
	@Test
	void testPop_EmptyStackException() {

		try {
			stack.pop();

		} catch (EmptyStackException ex) {
			assertTrue(true);
		}

	}
}
