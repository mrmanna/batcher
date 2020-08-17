package org.manna.batcher.impl.job;

import org.manna.batcher.impl.event.listener.EventListener;

public abstract class Job implements Runnable {

	public EventListener listener;
	public Job(EventListener event) {
		this.listener = event;
	}
	@Override
	public void run() {		
		 perform();
	}
	public abstract  void perform();
}
