package utilities;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Class description:
 * 
 * @author Hu Peng
 *
 * 
 */
public class MyStack<E> implements StackADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int size;
	private E[] myStack;
	private final int DEFAULT_CAPACITY = 10;
	private int stackSize = DEFAULT_CAPACITY;
	private boolean integrityOK = false;

	/**
	 * Initializes the newly created MyStack
	 */
	public MyStack() {
		size = 0;
		myStack = (E[]) (new Object[stackSize]);

	}

	@Override
	public void push(E toAdd) throws NullPointerException {
		try {
			ensureCapacity();
			myStack[size + 1] = toAdd;
			size++;

		} catch (NullPointerException ex) {
			System.out.println("The parameter being passed is of null value");
		}

	}

	private void ensureCapacity() {

		int capacity = myStack.length - 1;
		if (size >= capacity) {
			int newCapacity = 2 * capacity;
			myStack = Arrays.copyOf(myStack, newCapacity + 1);
		}

	}

	@Override
	public E pop() throws EmptyStackException {
		E element = null;
		try {
			element = myStack[size];
			size--;
		} catch (EmptyStackException ex) {
			System.out.println("This stack is empty");
		}
		return element;

	}

	@Override
	public E peek() throws EmptyStackException {
		E element = null;
		try {
			element = myStack[size];
		} catch (EmptyStackException ex) {
			System.out.println("This stack is empty");
		}
		return element;
	}

	@Override
	public void clear() {
		for (int i = 1; i <= size; i++) {
			myStack[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		for (int i = size; i >= 1; i--) {
			if (myStack[i] != null)
				empty = false;
		}

		return empty;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[size];
		int i = 0;
		int j = size;
		while (i < size) {
			newArray[i] = myStack[j];
			i++;
			j--;
		}

		return newArray;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {

		int i = 0;
		int j = size;
		try {

			while (i < size) {
				holder[i] = myStack[j];
				i++;
				j--;
			}
		} catch (NullPointerException ex) {
			System.out.println("This holder is null");
		}
		return holder;
	}

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param toFind element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not support null elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean containsElement = false;
		if (toFind == null) {
			throw new NullPointerException("The parameter being passed is of null value");
		} else {
			for (int i = size; i >= 1; i--) {
				if (myStack[i].equals(toFind)) {
					containsElement = true;
				}
			}

			return containsElement;
		}

	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the object
	 * o occurs as an item in this stack, this method returns the distance from the
	 * top of the stack of the occurrence nearest the top of the stack; the topmost
	 * item on the stack is considered to be at distance 1. The equals method is
	 * used to compare o to the items in this stack.
	 * 
	 * @param toFind the desired object.
	 * @return the 1-based position from the top of the stack where the object is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack.
	 */
	@Override

	public int search(E toFind) {
		int distance = 0;
		int position = -1;
		for (int i = size; i >= 1; i--) {
			distance++;
			if (myStack[i].equals(toFind)) {
				position = distance;
			}

		}
		return position;
	}

	@Override
	public Iterator<E> iterator() {

		return null;
	}

	@Override
	public boolean equals(StackADT<E> that) {
		boolean isEqual = false;

		return isEqual;
	}

	@Override
	public int size() {
		return this.size;
	}

}
