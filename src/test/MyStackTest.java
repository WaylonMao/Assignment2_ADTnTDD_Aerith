package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		boolean expected = true;
		boolean actual = stack != null;
		assertEquals("Stack was not created", expected, actual);

	}

	/**
	 * Test method for {@link utilities.MyStack#push(E)}.
	 */
	@Test
	void testPush() {
		stack.push(one);
		int expected = stack.peek();
		int actual = one;
		assertEquals("List was not create", expected, actual);

	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPop() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
