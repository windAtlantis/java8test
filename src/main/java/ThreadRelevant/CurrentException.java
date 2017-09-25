package ThreadRelevant;

import java.util.ArrayList;
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

	static List<String> list = new CopyOnWriteArrayList<>();
	static List<String> list2 = new ArrayList<>();

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
		list.add("21");
		list.add("22");
		list.add("23");
		list.add("24");
		list.add("25");
		list2.addAll(list);
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(new dos());
		pool.execute(new dels());
	}

	public static void dosome() {
		for (String s : list2) {
			System.out.println(s);
		}
//		Iterator<String> iterator = list.iterator();
//		if (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
	}

	public static void deletesome() {
		list.remove(1);
		System.out.println("removed and size:"+list.size());
	}

	public static void modifysome() {
		/*
			非同步容器类，由于"及时失败"机制，会抛出ConcurrentModificationException
			ArrayList详见checkForComodification
		*/
		list2.remove(1);
		System.out.println("size:"+list2.size());
	}

	static class dos implements Runnable {

		@Override
		public void run() {
			dosome();
		}
	}

	static class dels implements Runnable {

		@Override
		public void run() {
//			deletesome();
			modifysome();
		}
	}
}
