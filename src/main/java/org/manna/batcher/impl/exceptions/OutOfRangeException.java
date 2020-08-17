package org.manna.batcher.impl.exceptions;

/**
 *  A exception -  input is out of given range
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class OutOfRangeException extends Exception {

	private static final long serialVersionUID = 225284957475523540L;

	public OutOfRangeException() {
		super("Error Code:: " + ErrorCode.WRONG_RANGE.value() + " INVALID INPUT FOUND!");
	}

}
