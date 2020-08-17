package org.manna.batcher.impl.model;

import org.manna.batcher.impl.exceptions.MultipleInputException;
import org.manna.batcher.impl.exceptions.NotNumberInputException;
import org.manna.batcher.impl.exceptions.NullInputException;
import org.manna.batcher.impl.exceptions.OutOfRangeException;
import org.manna.batcher.impl.job.Job;
import org.manna.batcher.impl.validator.Validator;
/**
 *  A model to hold input related info
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class Input {
	String[] rawInput = null;
	int value = 1;
	int doneLines = 0;
	boolean notnull = false;
	boolean singleInput = false;
	boolean number = false;
	boolean validRange = false;
	boolean valid = false;

	

	public boolean hasNext() {
		return value > doneLines;
	}

	public boolean taskDone() {
		return value == doneLines;
	}

	public boolean isValid() {

		return valid;
	}

	public Input(String[] input) throws Exception {
		this.rawInput = input;
		validate();
	}

	private void validate() throws Exception {
		if (isNotnull() && isSingleInput() && isNumber()) {
			this.value = Integer.parseInt(this.rawInput[0]);
			if (isValidRange()) {
				this.valid = true;
			}
		}
	}

	boolean isNotnull() throws NullInputException {
		return Validator.notNull(rawInput);
	}

	boolean isSingleInput() throws MultipleInputException {
		return Validator.singleInput(rawInput);
	}

	boolean isNumber() throws NotNumberInputException {
		return Validator.onlyNumbers(rawInput[0]);
	}

	boolean isValidRange() throws OutOfRangeException {
		return Validator.inRange(getValue());
	}

	public int getValue() {
		return value;
	}

	public int getDoneLines() {
		return doneLines;
	}

	public void increaseDoneLines() {
		if (!taskDone()) {
			this.doneLines = doneLines + 1;
		}
	}
	public String getGeneratedText() {
		return generatedText;
	}

	public void setGeneratedText(String generatedText) {
		this.generatedText = generatedText;
	}

	String generatedText="";
}
