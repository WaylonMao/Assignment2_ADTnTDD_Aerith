package utilities;

import java.util.NoSuchElementException;

import exceptions.EmptyStackException;

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
	private MyArrayList<E> myStack;

	/**
	 * Initializes the newly created MyStack
	 */
	public MyStack() {
		myStack = new MyArrayList<E>();
		size = 0;
	}

	@Override
	public void push(E toAdd) throws NullPointerException {
		try {
			if (myStack.add(toAdd)) {
				size++;
				myStack.set(size - 1, toAdd);
			}

		} catch (NullPointerException ex) {
			System.out.println("The parameter being passed is of null value");
		}

	}

	@Override
	public E pop() throws EmptyStackException {
		E element = null;
		if (size == 0) {
			throw new EmptyStackException("Stack is empty");
		} else if (size > 0) {
			element = myStack.get(size - 1);
			myStack.remove(size - 1);
			size--;
		}

		return element;

	}

	@Override
	public E peek() throws EmptyStackException {
		E element = null;
		if (size == 0) {
			throw new EmptyStackException("Stack is empty");
		} else if (size > 0) {
			element = myStack.get(size - 1);
		}
		return element;
	}

	@Override
	public void clear() {
		myStack.clear();
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public Object[] toArray() {
		Object[] temp = new Object[size];
		int i = size - 1;
		int j = size - 1;
		while (i >= 0) {
			temp[i] = myStack.get(j);
			i--;
			j--;
		}

		return temp;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {

		int i = size - 1;
		int j = size - 1;
		try {

			while (i >= 0) {
				holder[i] = myStack.get(j);
				i--;
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
		} else if (size > 0) {
			for (int i = size - 1; i >= 0; i--) {
				if (myStack.get(i).equals(toFind)) {
					containsElement = true;
				}
			}
		}
		return containsElement;
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
		for (int i = size - 1; i >= 0; i--) {
			distance++;
			if (myStack.get(i).equals(toFind)) {
				position = distance;
			}

		}
		return position;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException("The element is not in the list");
				} else {
					return myStack.get(index++);
				}
			}
		};
	}

	@Override
	public boolean equals(StackADT<E> that) {
		boolean isEqual = true;
		if (that.size() == this.size) {
			for (int i = size - 1; i >= 0; i--) {
				if (!that.pop().equals(myStack.get(i)))
					isEqual = false;
			}
		}
		return isEqual;
	}

	@Override
	public int size() {
		return this.size;
	}

}
