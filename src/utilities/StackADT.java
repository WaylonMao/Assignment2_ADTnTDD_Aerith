package utilities;

import exceptions.EmptyStackException;

/**
 * <p>
 * The <code>StackADT</code> interface is designed to be used as a basis for all
 * the Stack Data Structure that will be developed in assignment 2 in the CPRG
 * 311 at SAIT. The implementors of this interface will be required to add all
 * the functionality.
 * </p>
 *
 * @param <E> The type of elements this list holds.
 * @author Hoa Le, Weilong Mao, Chris Wang, Hu Peng
 */
public interface StackADT<E> {

    /**
     * Adds one element to the top of this stack.
     * Precondition: The stack is not full.
     * Postcondition: The element has been added to the top of the stack.
     *
     * @param element The element to be added to the top of this stack.
     * @throws NullPointerException Throws an exception if the element is null.
     */
    public void push(E element) throws NullPointerException;

    /**
     * Removes and returns the top element from this stack.
     * Precondition: The stack is not empty.
     * Postcondition: The top element has been return and removed from this stack.
     *
     * @return The element removed from the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public E pop() throws EmptyStackException;

    /**
     * Returns without removing the top element of this stack.
     * Precondition: The stack is not empty.
     * Postcondition: Returns the first element in this stack.
     *
     * @return The first element in this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public E peek() throws EmptyStackException;

    /**
     * Returns true if this stack contains no elements.
     * Precondition: None
     * Postcondition: Return true if the stack is empty.
     *
     * @return True if this stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     * Precondition: None.
     * Postcondition: Return the number of elements in the stack.
     *
     * @return The integer representation of the size of this stack.
     */
    public int size();

    /**
     * Returns the set of elements into the Iterator stack.
     * Precondition: None.
     * Postcondition: Returns the Iterator stack containing elements.
     *
     * @return The Iterator stack containing elements.
     */
    public Iterator<E> iterator();

    /**
     * Compare to the element in the StackADT, Returns true if every element's
     * position and values equals to each other and vice versa.
     * Precondition: None.
     * Postcondition: Returns true if every element's position
     * and values equals to each other and vice versa.
     *
     * @param that The StackADT element to be compared.
     * @return True if every element's position and values equals to each other and vice versa.
     */
    public boolean equals(StackADT<E> that);

    /**
     * Removes all the elements from this stack. This stack will be empty after this call returns.
     * Precondition: None.
     * Postcondition: The stack is empty.
     */
    public void clear();

    /**
     * Convert all the elements in the stack into an array and return it in proper
     * sequence (from top to bottom of the stack).
     * Precondition: None.
     * Postcondition: The stack is converted into an array and returned.
     *
     * @return An array with the elements of the stack.
     */
    public E[] toArray();

    /**
     * Returns an array containing all the elements in this stack in proper sequence
     * (from top to bottom of the stack). If the stack fits in the specified array,
     * it is returned therein. Otherwise, a new array will be returned with the size
     * of this stack.
     * Precondition: None.
     * Postcondition: Return an array with the elements of the stack.
     *
     * @param copy The array which the elements of the stack are to be stored in.
     * @return An array with the elements of the stack.
     * @throws NullPointerException If the specified array is null.
     */
    public E[] toArray(E[] copy) throws NullPointerException;

    /**
     * Search the stack for the element and return the position of the element. The
     * top of the stack is position 1.
     * Precondition: None.
     * Postcondition: Return the position of the element in the stack.
     *
     * @param element The element to be searched.
     * @return The position of the element in the stack.
     * @throws NullPointerException Throws an exception if the element is null.
     */
    public int search(E element) throws NullPointerException;

    /**
     * Search the stack for the element, if there is an element in the stack that is
     * equals to the element passed as parameter then return true.
     * Precondition: None.
     * Postcondition: Return true if the element is in the stack.
     *
     * @param element The element to be searched.
     * @return True if the element is in the stack.
     * @throws NullPointerException Throws an exception if the element is null.
     */
    public boolean contains(E element) throws NullPointerException;

}
