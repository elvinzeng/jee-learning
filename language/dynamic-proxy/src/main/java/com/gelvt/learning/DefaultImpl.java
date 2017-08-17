package com.gelvt.learning;

/**
 * 示例接口的默认实现
 * @author: Elvin Zeng
 * @date: 17-8-17.
 */
public class DefaultImpl implements DemoInterface{
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("do something else");
    }
}
