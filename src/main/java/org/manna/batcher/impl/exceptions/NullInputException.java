package org.manna.batcher.impl.exceptions;

/**
 *  A exception - empty input is provided
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class NullInputException extends Exception {

	private static final long serialVersionUID = 4727482271374398465L;

	public NullInputException() {
		super("Error Code:" + ErrorCode.NULL_INPUT.value() + " NO INPUT FOUND!");
	}

}
