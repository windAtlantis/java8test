package ThreadRelevant.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author wangzengjian
 * @Description
 * @date 2018/4/2 20:30
 */
public class TestSynchronousQueue {

	/**
	 * 阻塞队列，容量为1
	 */
//	private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
	/**
	 * 同步队列，容量为0
	 */
	private static SynchronousQueue<String> queue = new SynchronousQueue<>();

	public static void main(String[] args) {
		new Thread(new Productor("1")).start();
		new Thread(new Productor("2")).start();
		System.out.println("=======================");
//		new Thread(new Consumer("c")).start();
	}

	/**
	 * 生产者
	 */
	static class Productor implements Runnable {
		private String name;

		public Productor(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			String s = "productor "+name;
			System.out.println("produce start "+s);
			try {
				queue.put(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("produce end "+s);
		}
	}

	/**
	 * 消费者
	 */
	static class Consumer implements Runnable {
		private String name;

		public Consumer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("consume start "+name);
			String take = null;
			try {
				take = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("consume end "+name+" and take: "+take);
		}
	}
}
