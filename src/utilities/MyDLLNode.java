package utilities;

/**
 * The MyDLLNode class is a node for a doubly linked list.
 * @param <E> the type of data stored in the node
 */
public class MyDLLNode <E> {
    /**
     * The data stored in the node
     */
    private E data;
    /**
     * The next node in the list
     */
    private MyDLLNode<E> next;
    /**
     * The previous node in the list
     */
    private MyDLLNode<E> previous;
    /**
     * Constructs a node with the given data and next node.
     * @param data the data to be stored in the node
     */
    public MyDLLNode(E data) {
        this.data = data;
        next = null;
        previous = null;
    }
    /**
     * The Constructor for the MyDLLNode class
     * @param data the data to be stored in the node
     * @param next the next node in the list
     * @param previous the previous node in the list
     * @return the data stored in the node
     */
    public MyDLLNode(E data, MyDLLNode<E> next, MyDLLNode<E> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    /**
     * Returns the data stored in the node.
     * @return the data stored in the node
     */
    public E getData() {
        return data;
    }
    /**
     * Sets the data stored in the node.
     * @param data the data to be stored in the node
     */
    public void setData(E data) {
        this.data = data;
    }
    /**
     * Returns the next node in the list.
     * @return the next node in the list
     */
    public MyDLLNode<E> getNext() {
        return next;
    }
    /**
     * Sets the next node in the list.
     * @param next the next node in the list
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
    /**
     * Get the previous node in the list.
     * @return the previous node in the list
     */
    public MyDLLNode<E> getPrevious() {
        return previous;
    }
    /**
     * Sets the previous node in the list.
     * @param previous the previous node in the list
     */
    public void setPrevious(MyDLLNode<E> previous) {
        this.previous = previous;
    }
    /**
     * Returns a string representation of the node.
     * @return a string representation of the node
     */
    public String toString() {
        return data.toString();
    }
}
