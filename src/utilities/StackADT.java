package utilities;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * <p>
 * The <code>StackADT</code> interface is designed to be used as a basis for all
 * the Stack Data Structure that will be developed in assignment 2 in the CPRG
 * 311 at SAIT. The implementors of this interface will be required to add all
 * the functionality.
 * </p>
 *
 * @param <E> The type of elements this list holds.
 */
public interface StackADT<E> extends Serializable {

	/**
	 * Adds one element to the top of this stack. Precondition: The stack is not
	 * full. Postcondition: The element has been added to the top of the stack.
	 *
	 * @param element the element to be added to the top of this stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public void push(E element) throws EmptyStackException;

	/**
	 * Removes and returns the top element from this stack. Precondition: The stack
	 * is not empty. Postcondition: The top element has been return and removed from
	 * this stack.
	 * 
	 * @return the element removed from the top of this stack
	 * @throws EmptyStackException if this stack is empty
	 */
	public E pop() throws EmptyStackException;

	/**
	 * Returns without removing the top element of this stack. Precondition: The
	 * stack is not empty. Postcondition: Returns the first element in this stack.
	 * 
	 * @return the first element in this stack.
	 */
	public E peek();

	/**
	 * Returns true if this stack contains no elements. Precondition: None
	 * Postcondition: Returns true if this stack is empty and vice versa.
	 * 
	 * @return true if this stack is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this stack. Precondition: None
	 * Postcondition: Returns true if this stack is empty and vice versa.
	 * 
	 * @return the integer representation of the size of this stack
	 */
	public int size();

	/**
	 * Returns the set of elements into the Iterator stack. Precondition: At least
	 * one element exist. Postcondition: Returns the Iterator stack containing
	 * elements.
	 * 
	 * @return the Iterator stack containing elements.
	 */
	public Iterator<E> iterator();

	/**
	 * Compare to the element in the StackADT, Returns true if every element's
	 * position and values equals to each other and vice versa. Precondition: Both
	 * StackADT stack are not empty. Postcondition: Returns true if every element's
	 * position and values equals to each other and vice versa.
	 * 
	 * @param that the StackADT element to be compared.
	 * @return true if every element's position and values equals to each other and
	 *         vice versa.
	 */

	public boolean equals(StackADT<E> that);

	/**
	 * Removes all of the elements from this stack. This stack will be empty after
	 * this call returns. Precondition: None. Postcondition: The stack is empty.
	 */

	public void clear();

	/**
	 * Convert the stack into an E array and return it. Precondition: The stack is
	 * not empty. Postcondition: The stack is converted into an E array and
	 * returned.
	 * 
	 * @return converted E array.
	 */

	public E[] toArray();

	/**
	 * Copy the stack into an E[] array and return the array. Precondition: The
	 * stack is not empty, and the length of copy is greater or equals to the
	 * stack's size. Postcondition: The stack is copied into E[] and E[] is
	 * returned.
	 * 
	 * @param array E[]
	 * @return
	 */

	public E[] toArray(E[] array);

	/**
	 * Search the position of an element.
	 *
	 * @param element
	 * @return the index of the element
	 */
	public int search(E element);

	/**
	 *
	 * @param element.
	 * @return
	 */

	public boolean contains(E element);

}
