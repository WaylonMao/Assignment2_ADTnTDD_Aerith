package utilities;

import exceptions.EmptyQueueException;

/**
 * <p>
 * The <code>QueueADT</code> interface is designed to be used as a basis for all
 * the Stack Data Structure that will be developed in assignment 2 in the CPRG 311 at
 * SAIT. The implementors of this interface will be required to add all the
 * functionality.
 * </p>
 *
 * @param <E> The type of elements this list holds.
 * @author Hoa Le, Weilong Mao, Chris Wang, Hu Peng
 */
public interface QueueADT<E> {


    /**
     * Retrieves, but does not remove, the head of this queue.
     * Precondition  : The queue is not empty.
     * Postcondition : The element at the head of the queue is returned.
     *
     * @return the element at the front of the queue
     * Null if the queue is empty
     * @throws EmptyQueueException if the queue is empty
     */
    public E peek() throws EmptyQueueException;

    /**
     * Add one element to the rear of this queue.
     * Precondition  : The queue is not full.
     * Postcondition : the element has been added to the rear (tail/back) of the queue.
     *
     * @param e the element to be added to the rear of this queue
     */
    public void enqueue(E e);

    /**
     * Remove and return the element at the front of this queue.
     * Precondition  : The queue is not empty.
     * Postcondition : The element at the front of the queue is removed and returned.
     *
     * @return the element at the front of this queue
     * @throws EmptyQueueException Throws an exception if
     *                             the queue is empty before the operation.
     */
    public E dequeue() throws EmptyQueueException;

    /**
     * Return number of element from this queue.
     * Precondition  : None.
     * Postcondition : return the number of elements in the queue.
     *
     * @return the number of elements in this queue
     */
    public int size();

    /**
     * Return an iterator over the elements in this queue, in proper sequence.
     * Precondition  : None.
     * Postcondition : return an iterator over the elements in this queue, in proper sequence.
     *
     * @return An iterator over the elements in this queue, in proper sequence.
     * NB: The return is of type
     * <code>linearUtilities.Iterator<E></code>,
     * not <code>java.util.Iterator</code>.
     */
    public Iterator<E> iterator();

    public boolean isEmpty();

    public void dequeueAll();

    public boolean equals(StackADT<E> that);

    public E[] toArray();

    public E[] toArray(E[] copy);
}
