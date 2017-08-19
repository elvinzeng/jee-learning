package com.gelvt.learning;


import java.lang.reflect.Method;

/**
 * Client
 *
 * @author: Elvin Zeng
 * @date: 17-8-19.
 */
@Description
public class App {

    @Description("main method")
    public static void main(String[] args) throws NoSuchMethodException {
        Description classDescription = App.class.getDeclaredAnnotation(Description.class);
        if (null != classDescription){
            System.out.println(classDescription.value());
        }else{
            System.out.println("没有Description注解");
        }

        Method mainMethod = App.class.getMethod("main", new Class[]{String[].class});
        Description mainMethodclassDescription = mainMethod.getDeclaredAnnotation(Description.class);
        if (null != mainMethodclassDescription){
            System.out.println(mainMethodclassDescription.value());
        }else{
            System.out.println("没有Description注解");
        }
    }
}
