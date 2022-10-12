package utilities;

/**
 * <p>
 * The <code>QueueADT</code> interface is designed to be used as a basis for all
 * the Linear data structures that will be developed in the CPRG 311 class at
 * SAIT. The implementors of this interface will be required to add all the
 * functionality.
 * </p>
 *
 * @param <E> The type of elements this list holds.
 */
public interface QueueADT<E> {

    public E peek();

    public void enqueue(E e);

    public E dequeue();

    public int size();

    public Iterator<E> iterator();

    public boolean isEmpty();

    public void dequeueAll();

    public boolean equals(StackADT<E> that);

    public E[] toArray();

    public E[] toArray(E[] copy);
}
