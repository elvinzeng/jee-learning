package com.gelvt.learning;

import java.lang.reflect.TypeVariable;

/**
 * 泛型擦除
 * @author: Elvin Zeng
 * @date: 17-8-18.
 */
public class GenericTypeErasureDemo<T> {
    //  private T[] genericArray = new T[3];  无法编译

    public void foo(T obj) throws IllegalAccessException,
            InstantiationException {
        System.out.println(obj.getClass().getName());  //  ==> java.lang.String

        //T another = new T();  // 不能编译
        T another = (T)obj.getClass().newInstance();

        for (TypeVariable<? extends Class<? extends GenericTypeErasureDemo>> classTypeVariable : this.getClass().getTypeParameters()) {
            System.out.println(classTypeVariable.getName());  //  ==> T  注意这里是输出字母T
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        GenericTypeErasureDemo<String> genericTypeErasureDemo = new GenericTypeErasureDemo<>();
        genericTypeErasureDemo.foo("hi");
    }
}
