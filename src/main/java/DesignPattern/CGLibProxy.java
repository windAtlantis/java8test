package DesignPattern;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/5/2 20:41
 */
public class CGLibProxy implements MethodInterceptor {

	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls, this);
	}

	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("before");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("after");
		return result;
	}

	/**
	 * 优点：
	 * <p>实用 CGLib 动态代理的优势很明显，有了它，我们就可以为没有接口的类包装前置和后置方法了。从这点来说，它比无论是 JDK 动态代理还是静态代理都灵活的多。</p>
	 * <p>既然它比 JDK 动态代理还要灵活，那么我为什么还要在前面花那么多篇幅去介绍 JDK 动态代理呢？这就不得不提它的一个很大的缺点了。</p>
	 * 缺点：
	 * <p>我们想想，JDK 动态代理 和它在调用阶段有什么不同？对，少了接口信息。那么JDK动态代理为什么需要接口信息呢？就是因为要根据接口信息来拦截特定的方法，而CGLib动态代理并没接收接口信息，那么它又是如何拦截指定的方法呢？答案是没有做拦截。。。它拦截了被代理的所有方法（各位读者可以自己试试）</p>
	 * @param args
	 */
	public static void main(String[] args) {
		CGLibProxy cgLibProxy = new CGLibProxy();
		Subject subjectProxy = cgLibProxy.getProxy(RealSubject.class);
		subjectProxy.requset();
	}
}
