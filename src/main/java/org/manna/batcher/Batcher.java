package org.manna.batcher;

/**
 * <b> Batcher</b> is to run batch jobs in a non-blocking way with event driven architecture
 *  <ul>
 * <h4>TODO: </h4>
 *   <li>XML mapper of Events and Jobs and Event chaining </li>
 *  <li>Netty based server and client introducing to run batch jobs in network</li>
 *  <li>EventQueue as a Server</li>
 *  <li>Thread configuration options</li>
 *  <li>Web view to trace progress  </li>
 *  <li>Proper Logger implementation </li>
 *  <li>More test cases</li>
 * </ul>
 * @author manna 
 * @version 0.1
*  @since   August 18, 2020
 */
public interface Batcher {

	public void batchrun(String[] x) throws Exception;
}
