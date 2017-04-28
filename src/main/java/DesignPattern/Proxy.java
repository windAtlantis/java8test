package DesignPattern;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/4/28 18:42
 */
public class Proxy implements Subject {

	private Subject subject;

	public Proxy (Subject subject) {
		this.subject = subject;
	}

	@Override
	public void requset() {
		System.out.println("begin");
		subject.requset();
		System.out.println("end");
	}
}
