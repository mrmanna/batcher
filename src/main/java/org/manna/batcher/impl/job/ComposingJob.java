package org.manna.batcher.impl.job;

import java.util.Random;

import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.listener.EventListener;

/**
 *  A {@link Job} to  generate text
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class ComposingJob extends Job {

	public ComposingJob(EventListener eventListener) {
		super(eventListener);
	}

	@Override
	public void perform() {
		int leftLimit = 98; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 100;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		this.listener.getEvent().getInput().setGeneratedText(generatedString);
		this.listener.getEvent().setStatus(Event.EventStatus.SUCCESS);
	}

}
