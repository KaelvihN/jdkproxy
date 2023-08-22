package com.example.jdkproxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : KaelvihN
 * @date : 2023/8/22 15:29
 */
public class TestMethodInvoke {
    public static void main(String[] args) throws Throwable {
        Method method = TestMethodInvoke.class.getMethod("foo",int.class);
        for (int i = 1; i <= 17; i++) {
            show(i, method);
            method.invoke(null, i);
        }
        System.in.read();
    }

    public static void foo(int times) {
        System.out.println("times = " + times + ",foo");
    }

    public static void show(int times, Method method) throws Throwable {
        Method getMethodAccessor = Method.class.getDeclaredMethod("getMethodAccessor");
        getMethodAccessor.setAccessible(true);
        Object invoke = getMethodAccessor.invoke(method);
        if (invoke == null) {
            System.out.println(times + ":" + null);
            return;
        }
        // DelegatingMethodAccessorImpl 的全限定类名（不同版本的 JDK 存在差异）sun.reflect.DelegatingMethodAccessorImpl
        Field delegate = Class
                .forName("sun.reflect.DelegatingMethodAccessorImpl")
                .getDeclaredField("delegate");
        delegate.setAccessible(true);
        System.out.println(times + ": " + delegate.get(invoke));

    }
}
