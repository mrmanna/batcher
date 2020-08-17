package org.manna.batcher.impl.exceptions;

/**
 *  A class to declare error codes
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public enum ErrorCode {

	NULL_INPUT("100"), MULTIPLE_INPUT("101"), WRONG_TYPE("102"), WRONG_RANGE("103");

	private String value;

	private ErrorCode(String value) {
		this.value = value;
	}
  public String value() {
	  return value;
  }
}
