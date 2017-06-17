package ThreadRelevant;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Karl
 * @Description
 * @date 2017/6/5 22:55
 */
public class CurrentException {

	static List<String> list = new CopyOnWriteArrayList<>();//ArrayList<>();

	static {
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("11");
		list.add("12");
		list.add("13");
		list.add("14");
		list.add("15");
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CurrentException instance = new CurrentException();
		pool.execute(instance.new dos());
		pool.execute(instance.new dels());
	}

	public void dosome() {
		for (String s : list) {
			System.out.println(s);
		}
//		Iterator<String> iterator = list.iterator();
//		if (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
	}

	public void deletesome() {
		list.remove(0);
		System.out.println("removed");
	}

	public void modifysome() {
		/*
			非同步容器类，由于"及时失败"机制，会抛出ConcurrentModificationException
			ArrayList详见checkForComodification
		*/
		list.remove(1);
//		list.iterator().remove();
		System.out.println("size:"+list.size());
	}

	class dos implements Runnable {

		@Override
		public void run() {
			dosome();
		}
	}

	class dels implements Runnable {

		@Override
		public void run() {
//			deletesome();
			modifysome();
		}
	}
}
