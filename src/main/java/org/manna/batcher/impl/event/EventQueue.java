package org.manna.batcher.impl.event;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.manna.batcher.impl.event.listener.EventQueueListener;
/**
 *  An  Queue for Events
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class EventQueue extends ConcurrentLinkedDeque<Event>{

	private static final long serialVersionUID = -7587203932354283620L;

	public EventQueueListener listener = new EventQueueListener();
	
	@Override
	public Event pop() {
		Event e = super.pop();
		listener.removeListener(e);
		return e;
	}
	
	@Override
	public void push(Event e) { 
		super.push(e);
		listener.addListener();
	}
}
