/**
 *
 */
package utilities;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author levan
 * @param <E>
 *
 */
public class MyArrayList<E> implements ListADT<E> {
    private int size;
    private E[] myArrayList;
    private final int DEFAULT_CAPACITY = 10;
    private int arraySize = DEFAULT_CAPACITY;
    private boolean integrityOK = false;


    //Constructor
    public MyArrayList() {
        size = 0;
        myArrayList = (E[]) (new Object[arraySize]);
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            myArrayList[i] = null;
        }
        size = 0;

    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(toAdd == null) {
            throw new NullPointerException("The element is null");
        }else if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }else {
            if(size == arraySize) {
                arraySize = arraySize * 2;
                myArrayList = Arrays.copyOf(myArrayList, arraySize);
            }
            for(int i = size; i > index; i--) {
                myArrayList[i] = myArrayList[i-1];
            }
            myArrayList[index] = toAdd;
            size++;
            return true;
        }


    }

    /**
     * Appends the specified element to the end of this list.
     * @param toAdd
     * 			Element to be appended to this list.
     * @return
     * @throws NullPointerException
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if(toAdd == null) {
            throw new NullPointerException("The element is null");
        }else {
            ensureCapacity();
            myArrayList[size++] = toAdd;
            return true;
        }
    }

    private void ensureCapacity() {
        int capacity = myArrayList.length -1;
        if(size >= capacity) {
            int newCapacity = 2 * capacity;
            myArrayList = Arrays.copyOf(myArrayList, newCapacity +1);
        }
    }


    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

        return false;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }else {
            return myArrayList[index];
        }

    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
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
    public E[] toArray(E[] toHold) throws NullPointerException {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
