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
			myStack[size++] = toAdd;

		} catch (NullPointerException ex) {
			System.out.println("This parameter is null");
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
			element = myStack[size - 1];
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
			element = myStack[size - 1];

		} catch (EmptyStackException ex) {
			System.out.println("This stack is empty");
		}
		return element;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			myStack[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		for (int i = 0; i < size; i++) {
			if (myStack[i] != null)
				empty = false;
		}

		return empty;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int search(E toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
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
