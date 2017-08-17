package com.gelvt.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于jdk的动态代理
 *
 * @author: Elvin Zeng
 * @date: 17-8-17.
 */
public class DemoProxy implements InvocationHandler {
    private DefaultImpl target;

    public DemoProxy(DefaultImpl target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在调用方法" + method.getName());
        System.out.println("前置通处理");
        Object result = method.invoke(target, args);
        System.out.println("后置处理");
        return result;
    }
}
