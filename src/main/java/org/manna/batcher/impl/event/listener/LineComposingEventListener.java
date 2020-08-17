package org.manna.batcher.impl.event.listener;

import org.manna.batcher.impl.event.ComposeSingleLineEvent;
import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.WriteSingleLineEvent;
import org.manna.batcher.impl.job.WritingJob;
/**
 *  An  concrete  implementation of {@link EventListener} to consume {@link ComposeSingleLineEvent}
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class LineComposingEventListener extends EventListener {

	@Override
	public Event chain() {
		LineWritingEventListener listener = new LineWritingEventListener();
		return new WriteSingleLineEvent(listener, new WritingJob(listener), this.getEvent().getInput());
	}

}
