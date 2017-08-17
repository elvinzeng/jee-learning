package com.gelvt.learning;


import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Client
 * @author: Elvin Zeng
 * @date: 17-8-17.
 */
public class App {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            IOException {
        DemoInterface demo = new DefaultImpl();
        demo.doSomething();
        demo.doSomethingElse();

        System.out.println("-----------------------");
        //  使用动态代理插入其他逻辑
        DefaultImpl target = new DefaultImpl();
        DemoInterface proxiedDemo = (DemoInterface)Proxy.newProxyInstance(
                DemoInterface.class.getClassLoader(),
                new Class[]{DemoInterface.class},
                new DemoProxy(target));
        proxiedDemo.doSomething();
        proxiedDemo.doSomethingElse();

        System.out.println("-----------------------");
        //  另一种方式
        Class<?> clazz = Proxy.getProxyClass(DemoInterface.class.getClassLoader(),
                new Class[]{DemoInterface.class});
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        DemoInterface proxiedDemo2 = (DemoInterface) constructor.newInstance(new DemoProxy(target));
        proxiedDemo.doSomething();
        proxiedDemo.doSomethingElse();

        System.out.println("-----------------------");
        System.out.println("保存代理到文件中");
        byte[] proxyClassByteCode = ProxyGenerator.generateProxyClass(clazz
                .getSimpleName(), clazz.getInterfaces());
        File classFile = File.createTempFile("dynamic-proxy", ".class");
        try(FileOutputStream fos = new FileOutputStream(classFile)){
            fos.write(proxyClassByteCode);
        }
        System.out.println("类文件路径：" + classFile.getAbsolutePath());
    }
}
