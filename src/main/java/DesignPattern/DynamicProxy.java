package DesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/4/28 18:46
 */
public class DynamicProxy implements InvocationHandler {

	private Object target;

	public DynamicProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Object result = method.invoke(target, args);
		System.out.println("end");
		System.out.println("proxy:"+proxy.getClass()+" target:"+target.getClass());
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/**
	 * 优点：
	 * <p>相比之前的静态代理，我们可以发现，现在的调用代码多了一行。不过相较这多出来的一行，更令人兴奋的时，我们通过实用 jdk 为我们提供的动态代理实现，达到了我们的 cook() 或者 swap() 方法可以被任意的复用的效果（只要我们在调用代码处使用这个通用代理类去包装任意想要需要包装的被代理类即可）。
	 * 当接口改变的时候，虽然被代理类需要改变，但是我们的代理类却不用改变了。</p>
	 * 缺点：
	 * <p>我们可以看到，无论是静态代理还是动态代理，它都需要一个接口。那如果我们想要包装的方法，它就没有实现接口怎么办呢？这个问题问的好，JDK为我们提供的代理实现方案确实没法解决这个问题。。。那么怎么办呢？别急，接下来就是我们的终极大杀器，CGLib动态代理登场的时候了。</p>
	 * @param args
	 */
	public static void main(String[] args) {
//		DynamicProxy dynamicProxy = new DynamicProxy(new RealSubject());
//		Subject subjectProxy = (Subject) dynamicProxy.getProxy();
//		subjectProxy.requset();

		InvocationHandler handler = new DynamicProxy(new RealSubject());
		Object standardProxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Subject.class}, handler);
		((Subject)standardProxy).requset();
	}
}
