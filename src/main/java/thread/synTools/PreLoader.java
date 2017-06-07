package thread.synTools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Karl
 * @Description
 * @date 2017/6/6 23:16
 */
public class PreLoader {

	class Info {

		Info() {
			for (int i = 0; i < 100; i++) {
				System.out.println("info:"+i);
			}
			name = "def";
		}

		String name;

		@Override
		public String toString() {
			return "name = "+name;
		}
	}

	private Info loadInfo() {
		return new Info();
	}

	private final FutureTask<Info> futureTask = new FutureTask<Info>(this::loadInfo);

	private final Thread thread = new Thread(futureTask);

	public void start() {
		thread.start();
	}

	public Info get() {
		try {
			return futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		PreLoader preLoader = new PreLoader();
		preLoader.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		long start = System.currentTimeMillis();
		System.out.println(preLoader.get());
		System.out.println("use time:"+(System.currentTimeMillis()-start));
	}
}
