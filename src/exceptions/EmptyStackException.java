package exceptions;

/**
 * Class description: This class is an exception class that is thrown when the stack is empty.
 *
 * @author Hoa Le, Weilong Mao, Chris Wang, Hu Peng
 */
public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("The stack is empty");
    }
    public EmptyStackException(String message) {
        super(message);
    }
}
