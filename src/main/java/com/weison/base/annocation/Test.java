package com.weison.base.annocation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Hi(msg = "hello")
public class Test {

	@Check(value = "hi")
	int a;

	@Perform
	public void testMethod() {
	}

	@SuppressWarnings("deprecation")
	public void test1() {
		Hero hero = new Hero();
		hero.say();
		hero.speak();
	}

	public static void main(String[] args) {

		boolean hasAnnotation = Test.class.isAnnotationPresent(Hi.class);

		if (hasAnnotation) {
			Hi hi = Test.class.getAnnotation(Hi.class);
			// 获取类的注解
			System.out.println("id:" + hi.id());
			System.out.println("msg:" + hi.msg());
		}

		try {
			Field a = Test.class.getDeclaredField("a");
			a.setAccessible(true);
			// 获取一个成员变量上的注解
			Check check = a.getAnnotation(Check.class);

			if (check != null) {
				System.out.println("check value:" + check.value());
			}

			Method testMethod = Test.class.getDeclaredMethod("testMethod");

			if (testMethod != null) {
				// 获取方法中的注解
				Annotation[] ans = testMethod.getAnnotations();
				for (int i = 0; i < ans.length; i++) {
					System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
				}
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}