package org.manna.batcher.impl.job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.EventQueue;

/**
 *  A context to publish and execute jobs
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public final class JobContext {

	public static final EventQueue EVENT_QUEUE = new EventQueue();
	private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
	public static Event CURRENT_EVENT;

	public static void publishEvent(Event e) {		
		EVENT_QUEUE.push(e);
		
	}
	public static void execute(Job job) {
		EXECUTOR.execute(job);
	}
}
