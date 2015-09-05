import org.jgroups.JChannel;
import org.jgroups.blocks.atomic.Counter;
import org.jgroups.blocks.atomic.CounterService;

public class Node {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		JChannel ch = new JChannel("c:\\java\\eclipse-workspace\\hz\\jg.xml");

		CounterService counterService = new CounterService(ch);
		ch.connect("counter-cluster");
		Counter counter = counterService.getOrCreateCounter("counter", 0);

		if (counter.compareAndSet(0, 1)) {
			System.out.println("We're started.");
		} 
	}

}
