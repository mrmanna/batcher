package org.manna.batcher.impl.event.listener;

import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.Event.EventStatus;
import org.manna.batcher.impl.job.JobContext;
/**
 *  An  abstract implementation of {@link Event} consuming
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public abstract class EventListener {
	private EventStatus status;
	private Event event;

	 EventStatus getCurrentEventStatus() {
		return status;
	}

	 public void updateCurrentEventStatus(EventStatus status) {
		switch (status) {
		case SUCCESS:
			next();
			break;
		case READYTOCONSUME:
			consume();
			break;
		default:
			break;
		}

	}

	 void next() {
		postSuccess();
		if (getEvent().getInput().hasNext()) {
			JobContext.publishEvent(chain());
		}
		if (getEvent().getInput().taskDone()) {
			shutdown();
		}
	};

	private void shutdown() {
		System.out.println("##### GOOD-BYE ######");
		System.exit(0);
	}
	/**
	 * if any listener specific things please override this one;
	 */
	public void postSuccess() {
    
	}
	public abstract Event chain();

	 void consume() {
		JobContext.execute(this.getEvent().getJob());
	}

	public void setEvent(Event e) {
		this.event = e;
	}

	public Event getEvent() {
		return event;
	}
}
