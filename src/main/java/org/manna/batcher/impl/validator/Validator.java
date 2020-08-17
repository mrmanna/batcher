package org.manna.batcher.impl.validator;

import java.util.regex.Pattern;

import org.manna.batcher.AbstractBatcher;
import org.manna.batcher.impl.exceptions.MultipleInputException;
import org.manna.batcher.impl.exceptions.NotNumberInputException;
import org.manna.batcher.impl.exceptions.NullInputException;
import org.manna.batcher.impl.exceptions.OutOfRangeException;
import org.manna.batcher.impl.job.Job;
/**
 *  A util class to validate inputs
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class Validator {

	public static boolean notNull(String[] args) throws NullInputException {
		if (null != args && args.length >= 1) {
			return true;
		} else {
			throw new NullInputException();
		}
	}

	public static boolean singleInput(String[] args) throws MultipleInputException {
		if (args.length == 1) {
			return true;
		} else {
			throw new MultipleInputException();
		}
	}

	public static boolean onlyNumbers(String arg) throws NotNumberInputException {
		Pattern pattern = Pattern.compile("[0-9]+");
		if (pattern.matcher(arg).matches()) {
			return true;
		} else {
			throw new NotNumberInputException();
		}
	}
	public static boolean inRange(int arg) throws OutOfRangeException {
		if (arg >= AbstractBatcher.MIN_RANGE && arg <= AbstractBatcher.MAX_RANGE) {
			return true;
		}else {
			throw new OutOfRangeException();
		}
	}
}
