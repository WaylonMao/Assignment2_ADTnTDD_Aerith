/**
 *
 */
package utilities;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This is MyArrayList class implements from ListADT interface.
 *
 * Class description: This class is the implementation of the MyArrayList
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 */
public class MyArrayList<E> implements ListADT<E>, Iterator<E> {
    /**
     * The size of MyArrayList.
     */
    private int size;
    /**
     * The index of MyArrayList.
     */
    private int index;
    /**
     * The array of MyArrayList.
     */
    private E[] myArrayList;
    /**
     * The default capacity of MyArrayList.
     */
    private final int DEFAULT_CAPACITY = 10;
    /**
     * The capacity of MyArrayList.
     */
    private int arraySize = DEFAULT_CAPACITY;


    /**
     * Constructor for MyArrayList.
     */
    public MyArrayList() {
        size = 0;
        index = 0;
        myArrayList = (E[]) new Object[arraySize];
    }

    /**
     * The size method will return the current element count contained
     * in the list.
     *
     * @return The current element count.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the elements from this list. This list will be empty after
     * this call returns.
     */
    @Override
    public void clear() {
        myArrayList = (E[]) new Object[arraySize];
        size = 0;
        index = 0;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index
     * 			The index at which the specified element is to be inserted.
     * 			The element is inserted before the existing element at [index],
     * 			or at the end if index is equal to the
     * 			size (<code>size()</code>).
     * @param toAdd
     * 			The element to be inserted.
     * @return <code>true</code> if the element is added successfully.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the
     * 			list implementation does not support having
     * 			<code>null</code> elements.
     * @throws IndexOutOfBoundsException
     * 			If the index is out of range:
     * 			i.e. (<code>index < 0 || index > size()</code>).
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("The element is null");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            if (size == arraySize) {
                arraySize = arraySize * 2;
                myArrayList = Arrays.copyOf(myArrayList, arraySize);
            }
            for (int i = size; i > index; i--) {
                myArrayList[i] = myArrayList[i - 1];
            }
            myArrayList[index] = toAdd;
            size++;
            return true;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * Implementations that support this operation may place limitations
     * on what elements may be added to this list. In particular, some
     * implementations will refuse to add <code>null</code> elements.
     * List classes should clearly specify in their
     * documentation any restrictions on what elements may be added.
     *
     * @param toAdd
     * 			Element to be appended to this list.
     * @return true if element is appended successfully.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the list
     * 			implementation does not support having <code>null</code>
     * 			elements.
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The element is null");
        } else {
            ensureCapacity();
            myArrayList[size++] = toAdd;
            return true;
        }
    }

    /**
     * Ensures that the capacity of the array is enough to add a new element.
     * If the array is full, it will double the size of the array.
     */
    private void ensureCapacity() {
        if (size == arraySize) {
            arraySize = arraySize * 2;
            myArrayList = Arrays.copyOf(myArrayList, arraySize);
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index
     * 			Index of element to return.
     * @return The element at the specified position in this list.
     * @throws IndexOutOfBoundsException
     * 			If the index is out of range:
     * 			i.e. (<code>index < 0 || index >= size()</code>).
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            return myArrayList[index];
        }
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index
     * 			The index of the element to remove.
     * @return The removed element.
     * @throws IndexOutOfBoundsException
     * 			If the index is out of range:
     * 			i.e. (<code>index < 0 || index >= size()</code>).
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            E temp = myArrayList[index];
            for (int i = index; i < size - 1; i++) {
                myArrayList[i] = myArrayList[i + 1];
            }
            size--;
            return temp;
        }
    }

    /**
     * Removes the first occurrence in this list of the specified element. If
     * this list does not contain the element, it is unchanged. More formally,
     * removes the element with the lowest index <code>i</code> such that
     * <code>o.equals(get(i))</code> (if such an element exists).
     *
     * @param toRemove
     * 			The element to be removed from this list.
     * @return The element which is being removed, or null if the list does
     * 			not contain the element.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the
     * 			list implementation does not support having
     * 			<code>null</code> elements.
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("The element is null");
        } else {
            int index = indexOf(toRemove);
            if (index == -1) {
                throw new NoSuchElementException("The element is not in the list");
            } else {
                return remove(index);
            }
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index <code>i</code> such that
     * <code>o.equals(get(i))</code>, or -1 if there is no such index.
     *
     * @param toFind
     * 			The element to search for.
     * @return The index of the first occurrence of the specified element in
     * 			this list, or -1 if this list does not contain the element.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the
     * 			list implementation does not support having
     * 			<code>null</code> elements.
     */
    private int indexOf(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The element is null");
        } else if(size == 0){
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if (myArrayList[i].equals(toFind)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index
     * 			The index of the element to replace.
     * @param toChange
     * 			Element to be stored at the specified position.
     * @return The element previously at the specified position.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the
     * 			list implementation does not support having
     * 			<code>null</code> elements.
     * @throws IndexOutOfBoundsException
     * 			If the index is out of range:
     * 			i.e. (<code>index < 0 || index >= size()</code>).
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else if (toChange == null) {
            throw new NullPointerException("The element is null");
        } else {
            E temp = myArrayList[index];
            myArrayList[index] = toChange;
            return temp;
        }
    }

    /**
     * Returns <code>true</code> if this list contains no elements.
     *
     * @return <code>true</code> if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one
     * element <code>e</code> such that <code>toFind.equals(e)</code>.
     *
     * @param toFind
     * 			The element whose presence in this list is to be tested.
     * @return <code>true</code> if this list contains the specified element.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the
     * 			list implementation does not support having
     * 			<code>null</code> elements.
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The element is null");
        } else if (size == 0) {
            return false;
        } else {
            if(indexOf(toFind) == -1){
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Appends all of the elements in the specified
     * <code>java.utilCollection</code> to the end of
     * this list, in the order that they are returned by the specified
     * collection's <code>Iterator</code>. The behaviour of this operation
     * is unspecified if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param toAdd
     * 			The new sub list to be added.
     * @return true
     * 			If the operation is successful.
     * @throws NullPointerException
     * 			If the specified element is <code>null</code> and the
     * 			list implementation does not support having
     * 			<code>null</code> elements.
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The element is null");
        } else {
            for (int i = 0; i < toAdd.size(); i++) {
                add(toAdd.get(i));
            }
            return true;
        }
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array. Obeys the general contract of the
     * <code>java.util.Collection.toArray(Object [])</code> method.
     *
     * @param toHold
     *			The array into which the elements of this list are to be
     * 			stored, if it is big enough; otherwise, a new array of the
     * 			same runtime type is allocated for this purpose.
     * @return An array containing the elements of this list.
     * @throws NullPointerException
     * 			If the specified array is <code>null</code>.
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("The element is null");
        } else {
            if (toHold.length < size) {
                toHold = (E[]) new Object[size];
            }
            for (int i = 0; i < size; i++) {
                toHold[i] = myArrayList[i];
            }
            return toHold;
        }
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the
     * <code>java.util.Collection.toArray()</code> method.
     *
     * @return An array containing all of the elements in this list in proper
     * 			sequence.
     */
    @Override
    public E[] toArray() {
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = myArrayList[i];
        }
        return temp;
    }

    /**
     * Returns an iterator over the elements in this list, in proper sequence.
     *
     * @return An iterator over the elements in this list, in proper sequence.
     * 			NB: The return is of type
     * 			<code>linearUtilities.Iterator<E></code>,
     * 			not <code>java.util.Iterator</code>.
     */
    @Override
    public Iterator<E> iterator() {
        return this;
    }

    /**
     * Returns <code>true</code> if the iteration has more elements.
     * (In other words, returns <code>true</code> if <code>next()</code>
     * would return an element rather than throwing an exception.)
     *
     * @return <code>true</code> if the iterator has more elements.
     */
    @Override
    public boolean hasNext() {
        return (index < size && myArrayList[index] != null);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return The next element in the iteration.
     * @throws NoSuchElementException
     * 			If the iteration has no more elements.
     */
    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("The element is not in the list");
        } else {
            return myArrayList[index++];
        }
    }
}
