package com.weison.base.annocation;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.say();
        hero.speak();

        boolean hasAnnotation = Test.class.isAnnotationPresent(Hi.class);

        if (hasAnnotation) {
            Hi hi = Test.class.getAnnotation(Hi.class);

            System.out.println("id:" + hi.id());
            System.out.println("msg:" + hi.msg());
        }
    }
}
