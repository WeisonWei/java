package com.weison.java8.functionalInterface;

public interface CommonInterface1 {

    //抽象方法
    public void doSomthing();

    //默认方法
    default void defaultMehtod() {
        System.out.println("CommonInterface1's default method is running...");
    }

    //默认方法可以有多个
    default void anotherDefaultMehtod() {
        System.out.println("CommonInterface1's second default method is running...");
    }

    //静态方法
    static void staticMethod() {
        System.out.println("CommonInterface1's static method is running...");
    }

    //静态方法也可以有多个
    static void anotherStaticMethod() {
        System.out.println("CommonInterface1's second static method is running...");
    }
}
