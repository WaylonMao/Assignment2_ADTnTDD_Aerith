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
	private MyArrayList<E> myStack;

	/**
	 * Initializes the newly created MyStack
	 */
	public MyStack() {
		myStack = new MyArrayList<E>();
	}

	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd != null)
			myStack.add(toAdd);
		else
			throw new NullPointerException("The argument being passed is of null value");
	}

	@Override
	public E pop() throws EmptyStackException {
		if (myStack.size() <= 0) {
			throw new EmptyStackException("Stack is empty");
		}
		return myStack.remove(myStack.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (myStack.size() <= 0) {
			throw new EmptyStackException("Stack is empty");
		}
		return myStack.get(myStack.size() - 1);
	}

	@Override
	public void clear() {
		myStack.clear();
	}

	@Override
	public boolean isEmpty() {
		return myStack.isEmpty();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public E[] toArray() {
		return myStack.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return myStack.toArray(holder);
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
		return myStack.contains(toFind);
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
		for (int i = myStack.size() - 1; i >= 0; i--) {
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
			private int index = myStack.size() - 1;

			@Override
			public boolean hasNext() {
				return index > 0;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException("No more elements");
				} else {
					return myStack.get(index--);
				}
			}
		};
	}

	@Override
	public boolean equals(StackADT<E> that) {
		if (this.size() != that.size()) {
			return false;
		}
		Iterator<E> thisIterator = this.iterator();
		Iterator<E> thatIterator = that.iterator();
		while (thisIterator.hasNext() && thatIterator.hasNext()) {
			if (!thisIterator.next().equals(thatIterator.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int size() {
		return myStack.size();
	}
}
