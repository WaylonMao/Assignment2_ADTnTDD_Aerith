/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilities.Iterator;
import utilities.ListADT;
import utilities.MyDLL;
import utilities.QueueADT;

/**
 * @author levan
 *
 */
public class MyDLLTests {
	private MyDLL list;
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer four;
	private Integer five;

	@Before
	public void setUp() throws Exception {
		list = new MyDLL();
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
	public void tearDown() throws Exception {
		list = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	public void testSize() {

	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	public void testClear() {
		this.list.clear();
		assertEquals("the list is not empty",0, this.list.size());
	}
	@Test
	public void testAppend(){
		this.list.append(one);
		this.list.append(two);
		this.list.append(three);
		this.list.append(four);
		/*
		 * The list should be 1,2,3,4
		 */
		// Test the size of the list
		assertEquals("The size is incorrect",4, this.list.size());
		// test the first element
		assertEquals("The first element is incorrect",one, this.list.get(0));
		// test the last element
		assertEquals("The last element is incorrect",four, this.list.get(3));
	}
	@Test
	public void testPrepend(){
		this.list.prepend(one);
		this.list.prepend(two);
		this.list.prepend(three);
		this.list.prepend(four);
		/*
		 * The list should be 4,3,2,1
		 */
		// Test the size of the list
		assertEquals("The size is incorrect",4, this.list.size());
		// test the first element
		assertEquals("The first element is incorrect",four, this.list.get(0));
		// test the last element
		assertEquals("The last element is incorrect",one, this.list.get(3));
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntObject() {
        this.list.add(0, one);
		this.list.add(1, two);
		this.list.add(2, three);
		this.list.add(3, four);
		/*
		 * The list should be 1,2,3,4
		 */
		// Test the size of the list
		assertEquals("The size is incorrect",4, this.list.size());
		// test the first element
		assertEquals("The first element is incorrect",one, this.list.get(0));
		// test the last element
		assertEquals("The last element is incorrect",four, this.list.get(3));
		//test the null element
		try {
			this.list.add(5, five);
			fail("The index is out of range");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);

		}
		//test index out of range
		try {
			this.list.add(-1, five);
			fail("The index is out of range");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);

		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddObject() {
		this.list.add(one);
		this.list.add(two);
		this.list.add(three);
		this.list.add(four);
		/*
		 * The list should be 1,2,3,4
		 */
		// Create a new list
		ListADT<Integer> list2 = new MyDLL();
		list2.add(one);
		list2.add(two);
		list2.add(three);
		list.addAll(list2);
		// Test the size of the list
		assertEquals("The size is incorrect",7, this.list.size());
		// test the first element
		assertEquals("The first element is incorrect",one, this.list.get(0));
		// test the last element
		assertEquals("The last element is incorrect",three, this.list.get(6));
		// test null element
		try {
			this.list.addAll(null);
			fail("The list is null");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		this.list.add(one);
		this.list.add(two);
		this.list.add(three);
		MyDLL list2 = new MyDLL();
		list2.add(four);
		list2.add(five);
		this.list.addAll(list2);
		/*
		 * The list should be 1,2,3,4,5
		 */
		// Test the size of the list
		assertEquals("The size is incorrect",5, this.list.size());
		// test the first element
		assertEquals("The first element is incorrect",one, this.list.get(0));
		// test the last element
		assertEquals("The last element is incorrect",five, this.list.get(4));
		// test null element
		try {
			this.list.addAll(null);
			fail("The list is null");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	public void testGet() {
		this.list.add(one);
		this.list.add(two);
		this.list.add(three);
		this.list.add(four);
		/*
		 * The list should be 1,2,3,4
		 */
		// Test get the first element
		assertEquals("The first element is incorrect",one, this.list.get(0));
		// Test get the last element
		assertEquals("The last element is incorrect",four, this.list.get(3));
		// Test get the middle element
		assertEquals("The middle element is incorrect",two, this.list.get(1));
		// Test get the null element
		try {
			this.list.get(4);
			fail("The index is out of range");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		// Test get the index out of range
		try {
			this.list.get(-1);
			fail("The index is out of range");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		this.list.append(one);
		this.list.append(two);
		this.list.append(three);
		this.list.append(four);
		this.list.append(five);
		/*
		 * The list should be 1,2,3,4
		 */
		// Test remove the first element
		assertEquals("The first element is incorrect",one, this.list.remove(0));
		// Test remove the last element
		assertEquals("The last element is incorrect",five, this.list.remove(3));
		// Test remove the middle element
		assertEquals("The middle element is incorrect",three, this.list.remove(1));
		// Test the size of the list
		assertEquals("The size is incorrect",2, this.list.size());
		// test index out of range
		try {
			this.list.remove(-1);
			fail("The index is out of range");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);

		}



	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		this.list.append(one);
		this.list.append(two);
		this.list.append(three);
		this.list.append(four);
		this.list.append(five);
		/*
		 * The list should be 1,2,3,4
		 */
		// Test remove the first element
		assertEquals("The first element is incorrect",one, this.list.remove(one));
		// Test remove the last element
		assertEquals("The last element is incorrect",five, this.list.remove(five));
		// Test remove the middle element
		assertEquals("The middle element is incorrect",three, this.list.remove(three));
		// Test the size of the list
		assertEquals("The size is incorrect",2, this.list.size());
		// Test remove the null element
		try {
			this.list.remove(null);
			fail("The element is null");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		this.list.append(one);
		this.list.append(two);
		this.list.prepend(four	);
		/*
		 * The list should be 4,1,2
		 */
		// Test set the first element
		this.list.set(0, three);
		assertEquals("The first element is incorrect",three, this.list.get(0));
		// Test set the last element
		this.list.set(2	, five);
		assertEquals("The last element is incorrect",five, this.list.get(2));
		// Test set null element
		try {
			this.list.set(0, null);
			fail("The element is null");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
		// Test set the index out of range
		try {
			this.list.set(-1, five);
			fail("The index is out of range");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}


	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(this.list.isEmpty());
		assertEquals(0, this.list.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		this.list.append(one);
		this.list.append(two);
		this.list.append(three);
		this.list.append(four);

		/*
		 * The list should be 1,2,3,4
		 */
		// Test the first element
		assertTrue(this.list.contains(one));
		// Test the last element
		assertTrue(this.list.contains(four));
		// Test the middle element
		assertTrue(this.list.contains(three));
		// Test the null element
		try{
			this.list.contains(null);
			fail("The element is null");
		}catch(NullPointerException e){
			assertTrue(true);
		}
		// Test the element not in the list
		assertFalse(this.list.contains(five));
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(java.lang.Object[])}.
	 */
	@Test
	public void testToArrayObjectArray() {
		this.list.append(one);
		this.list.prepend(two);
		this.list.append(three);
		this.list.append(four);
		/*
		 * The list should be 2,1,3,4
		 */
		Object [] expected = {2,1,3,4};
		Object [] actual = list.toArray(expected);
		assertArrayEquals("Array is not equals",expected, actual);

	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	public void testToArray() {
		this.list.append(one);
		this.list.prepend(two);
		this.list.append(three);
		this.list.append(four);
		/*
		 * The list should be 2,1,3,4
		 */
		Object [] expected = {2,1,3,4};
		Object [] actual = list.toArray();
		assertArrayEquals("Array is not equals",expected, actual);

	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	public void testIterator() {
		this.list.append(one);
		this.list.prepend(two);
		this.list.append(three);
		this.list.append(four);
		/*
		 * The list should be 2,1,3,4
		 */
		Iterator<Integer> it = this.list.iterator();
		int i = 0;
		while(it.hasNext()){
			assertEquals("The element is incorrect",this.list.get(i), it.next());
			i++;
		}
	}

}
