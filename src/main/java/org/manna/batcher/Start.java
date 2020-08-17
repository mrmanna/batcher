package org.manna.batcher;

/**
 * Main Class to start the application
 * @author manna
 * @version 0.1
*  @since   August 18, 2020
 */
public class Start {
 
	public static void main(String[] args) {	
	     try {
			BatcherFactory.DEFAULT.batchrun(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
