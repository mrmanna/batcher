package org.manna.batcher.impl.job;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.manna.batcher.impl.event.Event;
import org.manna.batcher.impl.event.listener.EventListener;
/**
 *  A {@link Job} to write generated text in file
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class WritingJob extends Job {

	public WritingJob(EventListener eventListener) {
		super(eventListener);
	}

	@Override
	public void perform() {
		OutputStream os = null;
		String data = this.listener.getEvent().getInput().getGeneratedText()+"\n";
		try {
			// below true flag tells OutputStream to append
			os = new FileOutputStream(new File("output.txt"), true);
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.listener.getEvent().getInput().setGeneratedText("");
		this.listener.getEvent().setStatus(Event.EventStatus.SUCCESS);

	}
}
