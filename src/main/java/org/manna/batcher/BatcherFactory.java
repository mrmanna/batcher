package org.manna.batcher;

import org.manna.batcher.impl.DefaultBatcher;
/**
 *  A factory of  {@link Batcher} with an example implemantation @link {@link DefaultBatcher}
 * @author manna 
 * @version 0.1
*  @since   August 18, 2020
 */
public class BatcherFactory {

	public static final Batcher DEFAULT = new DefaultBatcher();
}
