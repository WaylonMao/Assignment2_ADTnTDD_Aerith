/**
 * Class Clarification:
 *
 * @ Author:  EmtyQueueException
 * Date  :  2022-10-12
 */

package Exception;

/**
 * @author levan

 * @Date 2022-10-12 

 */
public class EmptyQueueException  extends Exception{
    public EmptyQueueException() {
        super("The queue is empty");
    }
    public EmptyQueueException(String message) {
        super(message);
    }
}
