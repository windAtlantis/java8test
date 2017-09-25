package java8.stream;

import java.util.stream.Stream;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/9/22 13:33
 */
public class StreamsAPI {

	static class Para {
		private String key;
		private String val;

		public Para(String key, String val) {
			this.key = key;
			this.val = val;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getVal() {
			return val;
		}

		public void setVal(String val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "Para{" +
					"key='" + key + '\'' +
					", val='" + val + '\'' +
					'}';
		}
	}

	public static void main(String[] args) {
//		List<Para> list = new ArrayList<>();
//		String key = "key", val = "val";
//		for (int i = 0; i < 10; i++) {
//			list.add(new Para(key+i, val+i));
//		}
//		list.stream().filter(item->"key3".equals(item.getKey())).forEach(e->e.setVal("1212"));
//		list.stream().sorted((p1,p2)->p2.getKey().compareTo(p1.getKey())).forEach(System.out::println);

		Stream<String> stream = Stream.of("a","b","c","d");
		System.out.println(stream.anyMatch(va->"b".equals(va)));
		Stream.iterate('a', item-> ((char) (item + 1))).limit(10).forEach(System.out::println);
	}
}
