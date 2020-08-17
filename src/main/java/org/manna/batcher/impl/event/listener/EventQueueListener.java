package org.manna.batcher.impl.event.listener;

import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.EventQueue;
import org.manna.batcher.impl.job.JobContext;
/**
 *  A listener over {@link EventQueue}
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class EventQueueListener {

	public void addListener() {
		if (null == JobContext.CURRENT_EVENT) {
			JobContext.CURRENT_EVENT = JobContext.EVENT_QUEUE.pop();
		} else if (null != JobContext.CURRENT_EVENT
				&& JobContext.CURRENT_EVENT.getStatus() == Event.EventStatus.SUCCESS) {
			JobContext.CURRENT_EVENT = JobContext.EVENT_QUEUE.pop();
		}
	}

	public void removeListener(Event e) {
		e.setStatus(Event.EventStatus.READYTOCONSUME);
	}
}
