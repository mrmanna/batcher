package org.manna.batcher.impl.event;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.manna.batcher.impl.DefaultBatcher;
import org.manna.batcher.impl.event.listener.EventListener;
import org.manna.batcher.impl.job.Job;
import org.manna.batcher.impl.model.Input;
/**
 *  An abstract implementation of  {@link Event} interface, mapping event with abstract consumer/listener {@link EventListener}, job {@link Job} and data {@link Input} 
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public abstract class BaseEvent implements Event {

	private Date startTime;
	private Date endTime;
	private EventStatus status;
	private EventListener listener;
	private Input input;
	private Job job;
	
	Logger log = Logger.getLogger(BaseEvent.class.getName());
	
	public BaseEvent(EventListener listener,Job job,Input input) {
		 
         this.listener = listener;
         this.input = input;
         this.listener.setEvent(this);
         this.job=job;
         this.setStatus(EventStatus.ONQUEUE);
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setStatus(EventStatus status) {
		this.status = status;
		log.log(Level.FINE, getName()+" status changed to: "+ status.name());
		listener.updateCurrentEventStatus(status);
	}
	
	@Override
	public EventStatus getStatus() {
		return status;
	}

	@Override
	public abstract String getName();

	@Override
	public Date getStartTime() {
		return startTime;
	}

	@Override
	public Date getEndTime() {
		return endTime;
	}
	@Override
	public Input getInput() {
		return input;
	}
	@Override
	public Job getJob() {
		return job;
	}
}
