package utilities;


import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
    private int size;
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;

    public MyDLL() {
        size = 0;
        this.head = this.tail = null;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
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
     * @return
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
     * @throws IndexOutOfBoundsException
     */
    public boolean append(E toAdd) {
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

    public boolean prepend(E toAdd) {
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
     * @return
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
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
                MyDLLNode<E> current = head;
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
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
     * @param toAdd Element to be appended to this list.
     * @return
     * @throws NullPointerException
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (size == 0) {
            return prepend(toAdd);
        } else {
            return append(toAdd);
        }
    }

    /**
     * @param toAdd The new sub list to be added.
     * @return
     * @throws NullPointerException
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
     * @param toAdd The new sub list to be added.
     * @return
     * @throws NullPointerException
     */


    /**
     * @param index Index of element to return.
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    /**
     * @param index The index of the element to remove.
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size || size == 0) {
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

    public E removeFirst() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty, nothing to remove");
        } else {
            return remove(0);
        }
    }

    public E removeLast() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty, nothing to remove");
        } else {
            return remove(size - 1);
        }
    }

    /**
     * @param toRemove The element to be removed from this list.
     * @return
     * @throws NullPointerException
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
     * @param index    The index of the element to replace.
     * @param toChange Element to be stored at the specified position.
     * @return
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else if (toChange == null) {
            throw new NullPointerException("The element is null, can not set it");
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            E data = current.getData();
            current.setData(toChange);
            return data;
        }
    }


    /**
     * @param toFind The element whose presence in this list is to be tested.
     * @return
     * @throws NullPointerException
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
     * @param toHold The array into which the elements of this list are to be
     *               stored, if it is big enough; otherwise, a new array of the
     *               same runtime type is allocated for this purpose.
     * @return
     * @throws NullPointerException
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
     * @return
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

    public MyDLLNode<E> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            if(index == 0){
                return head;
            }else if(index == size - 1){
                return tail;
            }else if (index < size / 2) {
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
     * @return
     */
    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            private int index = 0;

            /**
             * @return
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * @return
             * @throws NoSuchElementException
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("There is no next element");
                } else {
                    return get(index++);
                }
            }
        };

    }
}
