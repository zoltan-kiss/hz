package com.kz.jg.cluster;

import org.apache.log4j.Logger;
import org.jgroups.JChannel;
import org.jgroups.blocks.atomic.Counter;
import org.jgroups.blocks.atomic.CounterService;

/**
 * Simple cluster member implementation. The cluster displays 'We're started.'
 * exactly once.
 * 
 * @author zoltan-kiss
 *
 */
public class Member {

	// JGroups cluster configuration file.
	private static final String CLUSTER_CONFIGURATION = "jg.xml";

	// Name of the cluster.
	private static final String COUNTER_NAME = "kz-cluster";

	// The atomic variable indicating if the message has already been displayed.
	private static final String ATOMIC_FLAG = "flag";

	// The logger.
	private static final Logger LOGGER = Logger.getLogger(Member.class);

	public static void main(String[] args) {

		try {
			JChannel ch = new JChannel(CLUSTER_CONFIGURATION);

			CounterService counterService = new CounterService(ch);
			ch.connect(COUNTER_NAME);
			Counter counter = counterService.getOrCreateCounter(ATOMIC_FLAG, 0);

			if (counter.compareAndSet(0, 1)) {
				System.out.println("We're started.");
			}
		} catch (Exception e) {
			LOGGER.error("Unable to establish cluster.", e);
		}

	}

}
