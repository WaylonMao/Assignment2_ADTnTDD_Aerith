package utilities;

import java.util.NoSuchElementException;
/**
 * Class description:   This class is the implementation of the MyDLL
 *
 * @author Hoa Le, Weilong Mao, Hu Peng, Chris Wang
 *
 *
 */

public class MyDLL<E> implements ListADT<E> {
    private int size;
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;

    /**
     * Initializes the newly created MyDLL
     */
    public MyDLL() {
        size = 0;
        this.head = this.tail = null;
    }

    /**
     * This method is used to get the size of the MyDLL
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method is used to clear the MyDLL
     */
    @Override
    public void clear() {
        for (MyDLLNode<E> current = head; current != null; current = current.getNext()) {
            current.setData(null);
            current.setNext(null);
            current.setPrevious(null);
        }
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * This method is used to check the MyDLL is empty or not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method used to add an element to the end of the list
     *
     * @param toAdd the element to add
     * @return true if the element was added
     * @throws NullPointerException
     */
    public boolean append(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The element is null");
        } else {
            MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
            if (isEmpty()) {
                head = newNode;
            } else { // add to the end of the list
                tail.setNext(newNode);
                newNode.setPrevious(tail);
            }
            tail = newNode;
            size++;
            return true;
        }
    }

    /**
     * Method used to add an element to the beginning of the list
     *
     * @param toAdd the element to add
     * @return true if the element was added successfully
     * @throws NullPointerException if the element is null
     */
    public boolean prepend(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The element is null");
        } else {
            MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
            if (isEmpty()) {
                tail = newNode;
            } else { // add to the beginning of the list
                head.setPrevious(newNode);
                newNode.setNext(head);
            }
            head = newNode;
            size++;
            return true;
        }
    }

    /**
     * @param index The index at which the specified element is to be inserted.
     *              The element is inserted before the existing element at [index],
     *              or at the end if index is equal to the
     *              size (<code>size()</code>).
     * @param toAdd The element to be inserted.
     * @return true if the element was added successfully at the specified index.
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index == 0) {
            prepend(toAdd);
        } else if (index == size) {
            append(toAdd);
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            if (toAdd == null) {
                throw new NullPointerException("The element is null");
            } else {
                MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
                MyDLLNode<E> current = getNode(index);
                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());
                current.getPrevious().setNext(newNode);
                current.setPrevious(newNode);
                size++;
                return true;
            }
        }
        return true;
    }

    /**
     * Method uses to add an element to the end of the list
     * @param toAdd Element to be appended to this list.
     * @return true if the element was added successfully
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("The element is null");
        else {
            if (size == 0) prepend(toAdd);
            else append(toAdd);
            return true;
        }
    }


    /**
     * Method uses to add all elements of the specified collection to the end of this list.
     * @param toAdd The new sub list to be added.
     * @return true if the elements were added successfully
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The list is null");
        } else {
            for (int i = 0; i < toAdd.size(); i++) {
                add(toAdd.get(i));
            }
            return true;
        }
    }

    /**
     * Method uses to get the element at the specified index.
     * @param index Index of element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            MyDLLNode<E> current = getNode(index);
            return current.getData();
        }
    }

    /**
     * This method is used to remove the element at the specified index
     *
     * @param index The index of the element to remove.
     * @return the element that was removed from the list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }
        MyDLLNode<E> current = getNode(index);
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            if (index == 0) {
                head = current.getNext();
                head.setPrevious(null);
            } else if (index == size - 1) {
                tail = current.getPrevious();
                tail.setNext(null);
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        }
        size--;
        return current.getData();
    }

    /**
     * This method is used to remove the first occurrence of the specified element
     *
     * @return the element at the head of DLL .
     * @throws NullPointerException if the element is null
     */
    public E removeFirst() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty, nothing to remove");
        } else {
            return remove(0);
        }
    }

    /**
     * This method is used to remove the last occurrence of the specified element
     *
     * @return the element at the tail of DLL .
     * @throws NullPointerException if the element is null
     */
    public E removeLast() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty, nothing to remove");
        } else {
            return remove(size - 1);
        }
    }

    /**
     * This method is used to remove the first occurrence of the specified element
     *
     * @param toRemove The element to be removed from this list.
     * @return the element that was removed from the list.
     * @throws NullPointerException if the element is null
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("The element is null");
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < size; i++) {
                if (current.getData().equals(toRemove)) {
                    if (i == 0) {
                        return removeFirst();
                    } else if (i == size - 1) {
                        return removeLast();
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                        size--;
                        return current.getData();
                    }
                }
                current = current.getNext();
            }
            return null;
        }
    }

    /**
     * Method uses to set the element at the specified index.
     * @param index    The index of the element to replace.
     * @param toChange Element to be stored at the specified position.
     * @return the element previously at the specified position.
     * @throws NullPointerException    if the element is null
     * @throws IndexOutOfBoundsException    if the index is out of range
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else if (toChange == null) {
            throw new NullPointerException("The element is null, can not set it");
        } else {
            MyDLLNode<E> current = getNode(index);
            E data = current.getData();
            current.setData(toChange);
            return data;
        }
    }


    /**
     * This method is used to find the element in the DLL
     *
     * @param toFind The element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The element is null");
        } else if (size == 0) {
            return false;
        } else {
            MyDLLNode<E> current = head;
            while (current != null) {
                if (current.getData().equals(toFind)) {
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }
    }

    /**
     * This method is sued to transfer the elements of the DLL to an array
     *
     * @param toHold The array into which the elements of this list are to be
     *               stored, if it is big enough; otherwise, a new array of the
     *               same runtime type is allocated for this purpose.
     * @return the array containing the elements of the DLL.
     * @throws NullPointerException if the array is null
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("The array is null");
        } else {
            if (toHold.length < size) {
                toHold = (E[]) new Object[size];
            }
            MyDLLNode<E> current = head;
            for (int i = 0; i < size; i++) {
                toHold[i] = current.getData();
                current = current.getNext();
            }
            return toHold;
        }
    }

    /**
     * This method is used to transfer the elements of the DLL to an array in proper sequence
     *
     * @return the array containing the elements of the DLL in proper sequence.
     */
    @Override
    public E[] toArray() {
        E[] toHold = (E[]) new Object[size];
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            toHold[i] = current.getData();
            current = current.getNext();
        }
        return toHold;
    }

    /**
     * This method is used to get the element at the specified position in the DLL
     *
     * @param index The index of the element to return.
     * @return the element at the specified position in the DLL.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public MyDLLNode<E> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            if (index == 0) {
                return head;
            } else if (index == size - 1) {
                return tail;
            } else if (index < size / 2) {
                MyDLLNode<E> current = head;
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
                return current;
            } else {
                MyDLLNode<E> current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.getPrevious();
                }
                return current;
            }
        }
    }

    /**
     * This method will provide an mono-directional iterator for any of the
     * data structures that are specified in this package.
     * <p>
     * This iterator makes a copy of the collection of elements and performs a
     * complete walk through the data structure. Note that the copy must be a
     * deep copy, so methods such as clone() should not be used.
     */
    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private MyDLLNode<E> current = head;

            /**
             * This method is used to check if there is a next element in the DLL
             * @return true if there is a next element in the DLL
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * This method is used to get the next element in the DLL
             * @return the next element in the DLL
             *
             * @throws NoSuchElementException if there is no next element in the DLL
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("There is no next element");
                } else {
                    E data = current.getData();
                    current = current.getNext();
                    index++;
                    return data;
                }
            }
        };
    }
}
