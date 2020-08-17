package org.manna.batcher;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.manna.batcher.impl.model.Input;

/**
 * This is an abstract class to ensure some common
 * requirements like initialization, input validation implemented here so concrete
 *  implementation can be extended independently.
 * @author manna 
 * @version 0.1
 *  @since   August 18, 2020
 * 
 */
public abstract class AbstractBatcher implements Batcher {

	public static int MIN_RANGE = 1;
	public static int MAX_RANGE = 229;
	public Input input = null;
	
	Logger log = Logger.getLogger(AbstractBatcher.class.getName());

	@Override
	public void batchrun(String[] x) throws Exception {
		init(x);
	}

	private void init(String[] x) throws Exception {
		Properties config = new Properties();
		config.load(AbstractBatcher.class.getResourceAsStream("config.properties"));
		MIN_RANGE = Integer.parseInt(String.valueOf(config.get(Configs.MIN_VALUE)));
		MAX_RANGE = Integer.parseInt(String.valueOf(config.get(Configs.MAX_VALUE)));
		this.input = new Input(x);
		log.log(Level.INFO, "======Batcher Initialized===");
		run();
	}

	abstract public void run();

}
