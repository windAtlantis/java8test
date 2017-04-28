package DesignPattern;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/4/28 18:44
 */
public class Demo {

//	public static void main(String[] args) {
//		Subject realSubject = new RealSubject();
//		Proxy p = new Proxy(realSubject);
//		p.requset();
//	}

	public static void main(String[] args) {
		Subject subject = new RealSubject();
		MyInvocatioHandler handler = new MyInvocatioHandler(subject);
		Subject subjectProxy = (Subject) handler.getProxy();
		subjectProxy.requset();
	}
}
