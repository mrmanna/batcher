package org.manna.batcher.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.manna.batcher.AbstractBatcher;
import org.manna.batcher.Batcher;
import org.manna.batcher.impl.event.ComposeSingleLineEvent;
import org.manna.batcher.impl.event.listener.LineComposingEventListener;
import org.manna.batcher.impl.job.ComposingJob;
import org.manna.batcher.impl.job.JobContext;
import org.manna.batcher.impl.job.MemoryWatcher;
/**
 * An example Implementation of {@link Batcher} - Generate a file with x number of lines and each line consist of a string that is unique with 100 characters long
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class DefaultBatcher extends AbstractBatcher {

	Logger log = Logger.getLogger(DefaultBatcher.class.getName());
	@Override
	public void run() {
		  
		JobContext.execute(new MemoryWatcher(null));
		clean();  
		LineComposingEventListener listener = new LineComposingEventListener();
		ComposeSingleLineEvent event = new ComposeSingleLineEvent(listener, new ComposingJob(listener), input);
		JobContext.publishEvent(event);
		log.log(Level.FINE, event.getName()+" published");
	}
	
	private void clean() {
		File file = new File("output.txt");
		if(file.exists()){
			file.delete();
		}
	}

}
