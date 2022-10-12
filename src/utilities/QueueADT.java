package utilities;

/**
 * Class description: 
 *
 * @author Weilong Mao
 *
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
