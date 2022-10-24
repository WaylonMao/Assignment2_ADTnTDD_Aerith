package utilities;


import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT <E> {
    private int size;
    private MyDLLNode head;
    private MyDLLNode tail;

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
        for(MyDLLNode current = head; current != null; current = current.getNext()) {
            current.setData(null);
            current.setNext(null);
            current.setPrevious(null);
        }
        head = null;
        tail = null;
        size = 0;
    }
    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     *
     * Method used to add an element to the end of the list
     * @param toAdd the element to add
     * @return  true if the element was added
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    public boolean append(E toAdd) {
        if(toAdd == null) {
            throw new NullPointerException("The element is null");
        } else {
            MyDLLNode newNode = new MyDLLNode(toAdd);
            if(isEmpty()) {
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
          if(toAdd == null) {
              throw new NullPointerException("The element is null");
          } else {
              MyDLLNode newNode = new MyDLLNode(toAdd);
              if(isEmpty()) {
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
        if(index == 0) {
           prepend(toAdd);
        } else if(index == size) {
           append(toAdd);
        } else if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            if(toAdd == null){
                throw new NullPointerException("The element is null");
            } else {
                MyDLLNode newNode = new MyDLLNode(toAdd);
                MyDLLNode current = head;
                for(int i = 0; i < index; i++) {
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
        if(size == 0) {
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
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        if(toAdd == null) {
            throw new NullPointerException("The list is null");
        } else {
            for(int i = 0; i < toAdd.size(); i++) {
                add((E) toAdd.get(i));
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
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else {
            MyDLLNode current = head;
            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return (E) current.getData();
        }
    }

    /**
     * @param index The index of the element to remove.
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        }else if (index == 0) {
            return (E) removeFirst();
        } else if (index == size - 1) {
            return (E) removeLast();
        } else {
            MyDLLNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            size--;
            return (E) current.getData();
        }
    }

    public E removeFirst() throws IndexOutOfBoundsException {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty, nothing to remove");
        } else {
            E data = (E) head.getData();
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return (E) data;
        }
    }
    public E removeLast() throws IndexOutOfBoundsException {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty, nothing to remove");
        } else {
            E data = (E) tail.getData();
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return (E) data;
        }
    }

    /**
     * @param toRemove The element to be removed from this list.
     * @return
     * @throws NullPointerException
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if(toRemove == null) {
            throw new NullPointerException("The element is null");
        } else {
            MyDLLNode current = head;
            for(int i = 0; i < size; i++) {
                if(current.getData().equals(toRemove)) {
                    if(i == 0) {
                        return removeFirst();
                    } else if(i == size - 1) {
                        return removeLast();
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                        size--;
                        return (E) current.getData();
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
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is out of range");
        } else if(toChange == null) {
            throw new NullPointerException("The element is null, can not set it");
        } else {
            MyDLLNode current = head;
            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }
            E data = (E) current.getData();
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
        if(toFind == null){
            throw new NullPointerException("The element is null");
        } else if (size == 0) {
            return false;

        }else{
            MyDLLNode current = head;
            while(current != null) {
                if(current.getData().equals(toFind)) {
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
        if(toHold == null){
            throw new NullPointerException("The array is null");
        } else {
            if(toHold.length < size) {
                toHold = (E[]) new Object[size];
            }
            MyDLLNode current = head;
            for(int i = 0; i < size; i++) {
                toHold[i] = (E) current.getData();
                current = current.getNext();
            }
            return toHold;
        }
      }

    /**
     * @return
     */
    @Override
    public E [] toArray() {
        E[] toHold = (E[]) new Object[size];
        MyDLLNode current = head;
        for(int i = 0; i < size; i++) {
            toHold[i] = (E) current.getData();
            current = current.getNext();
        }
        return toHold;
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
            public E next()  {
                if(!hasNext()) {
                    throw new NoSuchElementException("There is no next element");
                } else {
                    return get(index++);
                }
            }
        };

    }
}
