package utilities;

import exceptions.EmptyQueueException;

/**
 * Class description:   This class is the implementation of the MyQueue
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 *
 *
 */
public class MyQueue<E> implements QueueADT<E>{

    private static final long serialVersionUID = 1L;
    private int size;
    private MyDLL<E> queue;

    /**
     * Constructor to create a new MyQueue object.
     */

    public MyQueue(){
        queue = new MyDLL<>();
        size = 0;
    }

    /**
     * Method to add an element to the rear of the queue.
     * @param toAdd the item to be added to the Queue.
     * @throws NullPointerException if the element to be added is null.
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        queue.add(toAdd);
    }

    /**
     * Method to remove an element from the front of the queue.
     * @return the element removed from the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if (queue.size() == 0) throw new EmptyQueueException();
        return queue.removeFirst();
    }

    /**
     * Method to get the element at the front of the queue.
     * @return the element at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public E peek() throws EmptyQueueException {
        if (queue.size() == 0) throw new EmptyQueueException();
        return queue.get(0);
    }
    /**
     * Method remove all elements from the queue.
     *
     *
     */
    @Override
    public void dequeueAll() {
        queue.clear();
    }

    /**
     * Method to check if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     *
     * @return an iterator over the elements in this queue in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    /**
     * Method to compare two MyQueue objects.
     * @param that the Queue ADT to be compared to this queue.
     * @return true if the two queues are equal, false otherwise.
     */
    @Override
    public boolean equals(QueueADT<E> that) {
        Iterator<E> listIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (listIterator.hasNext()) {
            if (listIterator.next() != thatIterator.next()) return false;
        }
        return true;
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
        return queue.toArray();
    }
    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array. Obeys the general contract of the Collection.toArray(Object[])
     * method.
     *
     * @param holder
     *            the array into which the elements of this queue are to be
     *            stored, if it is big enough; otherwise, a new array of the
     *            same runtime type is allocated for this purpose.
     * @return an array containing the elements of this queue.
     * @throws NullPointerException
     *          if the specified array is null.
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queue.toArray(holder);
    }
    /**
     * (Optional Method) Returns true if the number of items in the queue
     * equals the length.  This operation is only implement when a fixed length
     * queue is required.
     * @return <code>true</code> if queue is at capacity.
     */
    @Override
    public boolean isFull() {
        return true;
    }
    /**
     * Returns the length of the current queue as an integer value.
     * @return the current size to the queue as an integer.
     */
    @Override
    public int size() {
        return queue.size();
    }
}
