package DesignPattern;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/4/28 18:41
 */
public class RealSubject implements Subject {
	@Override
	public void requset() {
		System.out.println("RealSubject");
	}
}
