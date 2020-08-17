package org.manna.batcher.impl.exceptions;

/**
 *  A exception - multiple input is provided
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class MultipleInputException extends Exception {

	private static final long serialVersionUID = 4580742523880648186L;

	public MultipleInputException() {
		super("Error Code:" + ErrorCode.MULTIPLE_INPUT.value() + " MULTIPLE INPUT FOUND!");
	}

}
