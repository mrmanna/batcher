package org.manna.batcher.impl.event.listener;

import org.manna.batcher.impl.event.ComposeSingleLineEvent;
import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.WriteSingleLineEvent;
import org.manna.batcher.impl.job.ComposingJob;

/**
 *  An  concrete  implementation of {@link EventListener} to consume {@link WriteSingleLineEvent}
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class LineWritingEventListener extends EventListener {

	@Override
	public void postSuccess() {
		getEvent().getInput().increaseDoneLines();
	}

	@Override
	public Event chain() {
		LineComposingEventListener listener = new LineComposingEventListener();
		return new ComposeSingleLineEvent(listener, new ComposingJob(listener), this.getEvent().getInput());
	}
}
