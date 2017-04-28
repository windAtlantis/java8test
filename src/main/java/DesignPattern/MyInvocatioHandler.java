package DesignPattern;

import java.lang.reflect.*;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/4/28 18:46
 */
public class MyInvocatioHandler implements InvocationHandler {

	private Object target;

	public MyInvocatioHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Object result = method.invoke(target, args);
		System.out.println("end");
		return result;
	}

	public Object getProxy() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		return java.lang.reflect.Proxy.newProxyInstance(loader, interfaces, this);
	}
}
