/**
 *
 */
package utilities;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @param <E>
 * @author levan
 */
public class MyArrayList<E> implements ListADT<E> {
    private int size;
    private E[] myArrayList;
    private final int DEFAULT_CAPACITY = 10;
    private int arraySize = DEFAULT_CAPACITY;



    //Constructor
    public MyArrayList() {
        size = 0;
        myArrayList = (E[]) new Object[arraySize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        myArrayList = (E[]) new Object[arraySize];
        size = 0;
    }

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
     *
     * @param toAdd Element to be appended to this list.
     * @return
     * @throws NullPointerException
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

    private void ensureCapacity() {
        if (size == arraySize) {
            arraySize = arraySize * 2;
            myArrayList = Arrays.copyOf(myArrayList, arraySize);
        }
    }


    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            return myArrayList[index];
        }
    }

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

    private int indexOf(E toRemove) {
        for (int i = 0; i < size; i++) {
            if (myArrayList[i].equals(toRemove)) {
                return i;
            }
        }
        return -1;
    }

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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The element is null");
        } else if (size == 0) {
            throw new NoSuchElementException("The element is not in the list");
        } else {
            for (int i = 0; i < size; i++) {
                if (myArrayList[i].equals(toFind)) {
                    return true;
                }
            }
            return false;
        }
    }

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

    @Override
    public E[] toArray() {
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = myArrayList[i];
        }
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("The element is not in the list");
                } else {
                    return myArrayList[index++];
                }
            }
        };
    }


}
