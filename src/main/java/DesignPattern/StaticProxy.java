package DesignPattern;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/4/28 18:42
 */
public class StaticProxy implements Subject {

	private Subject subject;

	public StaticProxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void requset() {
		System.out.println("begin");
		subject.requset();
		System.out.println("end");
	}

	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		StaticProxy p = new StaticProxy(realSubject);
		p.requset();
	}
}
