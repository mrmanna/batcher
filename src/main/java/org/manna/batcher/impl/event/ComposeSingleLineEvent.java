package org.manna.batcher.impl.event;

import org.manna.batcher.impl.event.listener.EventListener;
import org.manna.batcher.impl.job.Job;
import org.manna.batcher.impl.model.Input;
/**
 *  An  event to generate text
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class ComposeSingleLineEvent extends BaseEvent {

	public ComposeSingleLineEvent(EventListener listener, Job job,Input input) {
		super(listener,job,input);
	}



	private static final String name = ComposeSingleLineEvent.class.getName();



	@Override
	public String getName() {
		return name;
	}






}
