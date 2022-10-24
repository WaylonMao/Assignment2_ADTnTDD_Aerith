package utilities;

public class MyDLLNode <E> {
    private E data;
    private MyDLLNode<E> next;
    private MyDLLNode<E> previous;

    public MyDLLNode(E data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public MyDLLNode(E data, MyDLLNode<E> next, MyDLLNode<E> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    public MyDLLNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(MyDLLNode<E> previous) {
        this.previous = previous;
    }

    public String toString() {
        return data.toString();
    }
}
