package utilities;


/**
 * 
 * Class description: 
 *
 * @author Weilong Mao
 *
 */
public interface StackADT<E> {

	public E peek();

	public void push(E e);

	public E pop();

	public int size();

	public Iterator<E> iterator();

	public boolean isEmpty();

	public void clear();

	public boolean equals(StackADT<E> that);

	public E[] toArray();

	public E[] toArray(E[] copy);
}
