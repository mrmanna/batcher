package org.manna.batcher.impl.event;

import java.util.Date;
import org.manna.batcher.impl.job.Job;
import org.manna.batcher.impl.model.Input;
/**
 *  An Interface for event 
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public interface Event {

	enum EventStatus{
		ONQUEUE,
		READYTOCONSUME,
		SUCCESS,
		FAILED;
	}
	public void setStatus(EventStatus status);
	public EventStatus getStatus();
	public String getName();
	public Date getStartTime();
	public Date getEndTime();
	public Input getInput();
	public Job getJob();
	
}
