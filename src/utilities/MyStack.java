package utilities;

import java.util.NoSuchElementException;

import exceptions.EmptyStackException;

/**
 * Class description:
 * 
 * @author Hu Peng
 *
 */
public class MyStack<E> implements StackADT<E> {
	private static final long serialVersionUID = 1L;

	/**
	 * The stack is implemented as an array.
	 */
	private MyArrayList<E> myStack;

	/**
	 * Initializes the newly created MyStack.
	 */
	public MyStack() {
		myStack = new MyArrayList<E>();
	}

	/**
	 * Pushes an item onto the top of this stack.
	 *
	 * @param toAdd item to be pushed onto the top of the stack.
	 * @throws NullPointerException when attempting to add a null element to
	 *                              the stack.
	 */
	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd != null)
			myStack.add(toAdd);
		else
			throw new NullPointerException("The argument being passed is of null value");
	}

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 *
	 * @return the item popped off the top of the stack.
	 * @throws java.util.EmptyStackException
	 *             if there are not items in the stack.
	 */
	@Override
	public E pop() throws EmptyStackException {
		if (myStack.size() <= 0) {
			throw new EmptyStackException("Stack is empty");
		}
		return myStack.remove(myStack.size() - 1);
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 *
	 * @return the object at the top of this stack.
	 * @throws java.util.EmptyStackException
	 */
	@Override
	public E peek() throws EmptyStackException {
		if (myStack.size() <= 0) {
			throw new EmptyStackException("Stack is empty");
		}
		return myStack.get(myStack.size() - 1);
	}

	/**
	 * Clears all the items from this Stack. This method returns, unless there
	 * is an Exception (Runtime) thrown.
	 */
	@Override
	public void clear() {
		myStack.clear();
	}

	/**
	 * Returns <code>true</code> if this Stack contains no items.
	 *
	 * @return <code>true</code> if this Stack contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return myStack.isEmpty();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 *
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public E[] toArray() {
		return myStack.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[])
	 * method.
	 *
	 * @return an array containing the elements of this stack.
	 * @throws NullPointerException
	 *             if the specified array is null.
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return myStack.toArray(holder);
	}

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e
	 * such that (o==null ? e==null : o.equals(e)).
	 *
	 * @param toFind
	 *            element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException
	 *             if the specified element is null and this list does not
	 *             support null elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return myStack.contains(toFind);
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the
	 * object o occurs as an item in this stack, this method returns the
	 * distance from the top of the stack of the occurrence nearest the top of
	 * the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare o to the items in this stack.
	 *
	 * @param toFind
	 *            the desired object.
	 * @return the 1-based position from the top of the stack where the object
	 *         is located; the return value -1 indicates that the object is not
	 *         on the stack.
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

	/**
	 * Returns an iterator over the elements in this stack in proper sequence.
	 *
	 * @return an iterator over the elements in this stack in proper sequence.
	 */
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

	/**
	 * Used to compare two Stack ADT's. To be equal two stacks must contain
	 * equal items appearing in the same order.
	 *
	 * @param that the Stack ADT to be compared to this stack.
	 * @return <code>true</code> if the stacks are equal.
	 */
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

	/**
	 * Returns the depth of the current stack as an integer value.
	 * @return the current size to the stack as an integer.
	 */
	@Override
	public int size() {
		return myStack.size();
	}
}
