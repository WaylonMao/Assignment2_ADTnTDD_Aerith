package utilities;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * <p>
 * The <code>StackADT</code> interface is designed to be used as a basis for all
 * the Stack Data Structure that will be developed in assignment 2 in the CPRG 311 at
 * SAIT. The implementors of this interface will be required to add all the
 * functionality.
 * </p>
 *
 * @param <E> The type of elements this list holds.
 */
public interface StackADT <E> extends Serializable {

	/**
	 * Adds one element to the top of this stack.
	 * Precondition: The stack is not full.
	 * Postcondtion: The element has been added to the top of the stack.
	 *
	 * @param element the element to be added to the top of this stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public void push (E element) throws EmptyStackException;

	/**
	 * Removes and returns the top element from this stack.
	 * precondition:
	 * postcondition:
	 * @return the element removed from the top of this stack
	 * @throws EmptyStackException if this stack is empty
	 */
	public E pop() throws EmptyStackException;

	/**
	 * Returns without removing the top element of this stack.
	 * @return the first element in this stack
	 */
	public E peek();

	/**
	 * Returns true if this stack contains no elements.
	 * @return true if this stack is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this stack.
	 * @return the integer representation of the size of this stack
	 */
	public int size();

	/**
	 *
	 * @param that
	 * @return
	 */

	public boolean equals(StackADT <E> that);

	/**
	 * Removes all of the elements from this stack. This stack will be empty after
	 * this call returns.
	 */

	public void clear();

	/**
	 *
	 * @return
	 */

	public Object[] toArray();

	/**
	 *
	 * @param copy
	 * @return
	 */

	public E[] toArray(E[] copy);

	/**
	 *
	 * @param element
	 * @return
	 */
	public int search (E element);

	/**
	 *
	 * @param element
	 * @return
	 */

	public boolean contains (E element);



}
