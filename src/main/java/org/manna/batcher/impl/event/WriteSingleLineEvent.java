package org.manna.batcher.impl.event;

import org.manna.batcher.impl.event.listener.EventListener;
import org.manna.batcher.impl.job.Job;
import org.manna.batcher.impl.model.Input;
/**
 *  An event to write generated text in file
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class WriteSingleLineEvent extends BaseEvent {

	public WriteSingleLineEvent(EventListener listener, Job job,Input input) {
		super(listener,job,input);
	}

	private static final String name = WriteSingleLineEvent.class.getName();

	@Override
	public String getName() {
		return name;
	}

}
