package org.manna.batcher.impl.job;

import org.manna.batcher.impl.event.listener.EventListener;

/**
 *  A memory watcher job
 *  <p><b>TODO:</b> needs improvement </p>
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class MemoryWatcher extends Job {
	private static final long MEGABYTE = 1024L * 1024L;

	public MemoryWatcher(EventListener eventListener) {
		super(eventListener);
	}

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	@Override
	public void perform() {

		
		while (true) {
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();
			long memory = runtime.totalMemory() - runtime.freeMemory();
			long memInMega =  bytesToMegabytes(memory);
			System.out.println("Used memory is megabytes: " +memInMega);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
