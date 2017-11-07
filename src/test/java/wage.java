import java.util.Scanner;

/**
 * @author Karl
 * @Description
 * @date 2017/11/7 20:57
 */
public class wage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = "";
		while (!"q".equals(s)) {
			s = scanner.nextLine();
			Integer integer = Integer.valueOf(s);
			int head = (integer / 100) * 100;
			for (int i = head; i <= 100000; i+=100) {
				int temp = deal(i);
				if (integer == temp) {
					System.out.println(i);
					break;
				} else if (temp > integer) {
					System.out.println("temp: "+temp);
					break;
				}
			}
		}
	}

	public static int deal(int input) {
		Double fee;
		int del = input - 3500;
		if (del > 0 && del <= 1500) {
			fee = del * 0.03;
		} else if (del > 1500 && del <= 4500) {
			fee = 1500 * 0.03 + (del-1500) * 0.1;
		} else if (del > 4500 && del <= 9000) {
			fee = 1500 * 0.03 + 3000 * 0.1 + (del-4500) * 0.2;
		} else if (del > 9000 && del <= 35000) {
			fee = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + (del-9000) * 0.25;
		} else if (del > 35000 && del <= 55000) {
			fee = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + (del-35000) * 0.3;
		} else if (del > 55000 && del <= 80000) {
			fee = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + 20000 * 0.3 + (del-55000) * 0.35;
		} else {
			fee = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + 20000 * 0.3 + 25000 * 0.35 + (del-80000) * 0.45;
		}
		return input - fee.intValue();
	}
}
