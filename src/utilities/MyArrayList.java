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

    // resize the array

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("Array is not initialized properly");
        }
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
        ensureCapacity();
        myArrayList	[size + 1] = toAdd;
        size++;
        return false;
    }

    private void ensureCapacity() {
        int capacity = myArrayList.length -1;
        if(size >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            myArrayList = Arrays.copyOf(myArrayList, newCapacity +1);
        }
    }

    private void checkCapacity(int newCapacity) {
        if(newCapacity > DEFAULT_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum of " + DEFAULT_CAPACITY);
        }
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if(toAdd == null) {
            throw new NullPointerException("The list is null");
        }else {
            for(int i = 0; i < toAdd.size(); i++) {
                add(toAdd.get(i));
            }
            return true;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }else {
            return myArrayList[index];
        }

    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }else {
            E result = myArrayList[index];
            for(int i = index; i < size; i++) {
                myArrayList[i] = myArrayList[i+1];
            }
            size--;
            return result;
        }
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if(toRemove == null) {
            throw new NullPointerException("The element is null");
        }else {
            int index = 0;
            while(index < size && !toRemove.equals(myArrayList[index])) {
                index++;
            }
            if(index < size) {
                E result = myArrayList[index];
                for(int i = index; i < size; i++) {
                    myArrayList[i] = myArrayList[i+1];
                }
                size--;
                return result;
            }else {
                throw new NoSuchElementException("The element is not in the list");
            }
        }
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if(toChange == null) {
            throw new NullPointerException("The element is null");
        }else if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }else {
            E result = myArrayList[index];
            myArrayList[index] = toChange;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }


}
