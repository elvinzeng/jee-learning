package com.gelvt.learning.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Elvin Zeng
 * @date: 17-8-18.
 */
public class Demo {
    public static void main(String[] args){
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new GreenApple());
        //apples.add(new Fruit());  不能编译

        List<? extends Apple> apples1 = apples;
        List<? extends Apple> apples2 = new ArrayList<GreenApple>();
        //List<? extends Apple> apples3 = new ArrayList<Fruit>();  不能编译
        //apples1.add(new Apple()); 不能编译。因为编译器只知道apples1持有的是Apple的某种子类的对象，但是并不知道具体哪种
        Apple apple = apples1.get(0);  //  可以编译


        List<? super Apple> list1 = apples;
        List<? super Apple> list2 = new ArrayList<Fruit>();
        //List<? super Apple> list3 = new ArrayList<GreenApple>();  不能编译
        list1.add(new Apple());  //  可以编译
        //  下面两句都不可编译，因为编译器不知道返回的对象是Apple的具体哪种超类的对象。
        //Apple apple = list1.get(0);
        //Fruit fruit = list1.get(0);


    }
}
