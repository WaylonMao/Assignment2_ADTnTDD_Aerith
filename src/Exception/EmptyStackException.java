/**
 * Class Clarification:
 *
 * @ Author:  EmtyQueueException
 * Date  :  2022-10-12
 */

package Exception;

/**
 * @author Hu
 * 
 * @Date 2022-10-12
 * 
 */
public class EmptyStackException extends Exception {
	public EmptyStackException() {
		super("The stack is empty");
	}

	public EmptyStackException(String message) {
		super(message);
	}
}
