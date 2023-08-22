package com.example.jdkproxy;

import com.example.jdkproxy.JDKProxyDemo.Foo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author : KaelvihN
 * @date : 2023/8/21 18:50
 */
public class $Proxy0 extends Proxy implements Foo {

//    private InvocationHandler handler;

//    public $Proxy0(InvocationHandler handler) {
//        this.handler = handler;
//    }

    /**
     * 使用静态代码块，防止重复创建方法对象
     */
    static Method foo;

    static Method bar;

    static Method hub;

    static {
        try {
            foo = Foo.class.getMethod("foo");
            bar = Foo.class.getMethod("bar");
            hub = Foo.class.getMethod("hub");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    protected $Proxy0(InvocationHandler h) {
        super(h);
    }


    @Override
    public void foo() {
//        //功能增强
//        System.out.println("before...");
//        //调用目标
//        new Target().foo();

        try {
            //获取方法对象
//            Method method = Foo.class.getMethod("foo");
            h.invoke(this, foo, new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public void bar() {
        try {
//            //获取方法对象
//            Method method = Foo.class.getMethod("bar");
            h.invoke(this, bar, new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public int hub() {
        try {
//            //获取方法对象
//            Method method = Foo.class.getMethod("hub");
            int result = (int) h.invoke(this, hub, new Object[0]);
            return result;
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
