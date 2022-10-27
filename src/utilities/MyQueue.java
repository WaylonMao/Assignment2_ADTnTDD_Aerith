package utilities;

import exceptions.EmptyQueueException;

/**
 * @author Chris Wang
 * @date 2022-10-26
 */
public class MyQueue<E> implements QueueADT<E>{

    private static final long serialVersionUID = 1L;
    private int size;
    private MyDLL<E> queue;

    public MyQueue(){
        queue = new MyDLL<>();
        size = 0;
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        queue.add(toAdd);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (queue.size() == 0) throw new EmptyQueueException();
        return queue.removeFirst();


    }

    @Override
    public E peek() throws EmptyQueueException {
        if (queue.size() == 0) throw new EmptyQueueException();
        return queue.get(0);
    }

    @Override
    public void dequeueAll() {
        queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        Iterator<E> listIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (listIterator.hasNext()) {
            if (listIterator.next() != thatIterator.next()) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queue.toArray(holder);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return queue.size();
    }
}
