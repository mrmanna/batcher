package org.manna.batcher.impl.exceptions;
/**
 *  A exception -input is not number
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class NotNumberInputException extends Exception {

	private static final long serialVersionUID = -4133642517845412944L;

	public NotNumberInputException() {
		super("Error Code:" + ErrorCode.WRONG_TYPE.value()+ " NOT NUMBER INPUT FOUND!");
	}

}
