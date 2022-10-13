package exceptions;

/**
 * Class description: This class is an exception class that is thrown when the queue is empty.
 *
 * @author Hoa Le, Weilong Mao, Chris Wang, Hu Peng
 */
public class EmptyQueueException  extends RuntimeException{
    public EmptyQueueException() {
        super("The queue is empty");
    }
    public EmptyQueueException(String message) {
        super(message);
    }
}
