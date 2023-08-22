package com.example.jdkproxy;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author : KaelvihN
 * @date : 2023/8/21 17:55
 */
public class JDKProxyDemo {
    interface Foo {
        void foo();

        void bar();

        int hub();
    }

    static final class Target implements Foo {

        @Override
        public void foo() {
            System.out.println(this.getClass() + ">>> foo");
        }

        @Override
        public void bar() {
            System.out.println(this.getClass() + ">>> bar");
        }

        @Override
        public int hub() {
            System.out.println(this.getClass() + ">>> hub");
            return 100;
        }
    }

//    interface InvocationHandler {
//        Object invoke(Method method, Objects[] params, Object proxy) throws Throwable;
//    }

    public static void main(String[] args) throws IOException {
        /**
         * 简单使用
         */
//        //目标对象
//        Target target = new Target();
//        //用于加载运行期间动态生成的字节码
//        ClassLoader classLoader = JDKProxyDemo.class.getClassLoader();
//        Foo proxyInstance =
//                (Foo) Proxy.newProxyInstance(classLoader, new Class[]{Foo.class},
//                        ((proxy, method, param) -> {
//                            System.out.println("before...");
//                            // 反射调用target的方法
//                            Object result = method.invoke(target, param);
//                            System.out.println("after...");
//                            //结果返回
//                            return result;
//                        }));
//        proxyInstance.foo();
        /**
         * 尝试实现
         */
//        new $Proxy0().foo();
        /**
         * 通过InvocationHandler动态实现
         */
//        $Proxy0 proxyInstance = new $Proxy0(new InvocationHandler() {
//            @Override
//            public void invoke() {
//                //功能增强
//                System.out.println("before...");
//                //调用目标
//                new Target().foo();
//            }
//        });
//        proxyInstance.foo();
//        proxyInstance.bar();
        /**
         * 增加invoke参数
         */
//        $Proxy0 proxyInstance = new $Proxy0((method, params) -> {
//            System.out.println("before...");
//            method.invoke(new Target(), params);
//        });
//        proxyInstance.foo();
//        proxyInstance.bar();
        /**
         * 增加返回值
         */
//        $Proxy0 proxyInstance = new $Proxy0(((method, params) -> {
//            System.out.println("before...");
//            Object result = method.invoke(new Target(), params);
//            return result;
//        }));
//        proxyInstance.foo();
//        proxyInstance.bar();
//        int result = proxyInstance.hub();
//        System.out.println("result = " + result);
        /**
         * 在静态代码块里创建Method实例
         */
//        $Proxy0 proxyInstance = new $Proxy0(((method, params, proxy) -> {
//            //功能增强
//            System.out.println("before...");
//            //调用目标
//            Object result = method.invoke(new Target(), params);
//            return result;
//        }));
//        proxyInstance.foo();
//        proxyInstance.bar();
//        System.out.println(proxyInstance.hub());
        /**
         * 用jdk的InvocationHandle
         */
//        $Proxy0 proxyInstance = new $Proxy0(((proxy, method, params) -> {
//            //功能增强
//            System.out.println("before...");
//            //调用目标
//            Object result = method.invoke(new Target(), params);
//            return result;
//        }));
//        proxyInstance.foo();
//        proxyInstance.bar();
//        System.out.println(proxyInstance.hub());
        /**
         * 查看JDK代理类的源码
         */
        ClassLoader classLoader = JDKProxyDemo.class.getClassLoader();
        Class[] classes = {Foo.class};
        Foo proxyInstance = (Foo) Proxy.newProxyInstance(classLoader, classes, ((proxy, method, args1) -> {
            System.out.println("before...");
            Object result = method.invoke(new Target(), args1);
            return result;
        }));
        proxyInstance.foo();
        proxyInstance.bar();
        System.out.println(proxyInstance.hub());
        // 打印代理类的全限定类名
        System.out.println(proxyInstance.getClass());
        // 只要不在控制台上输入并回车，程序就不会终端
        System.in.read();
    }
}

