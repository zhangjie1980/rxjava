package com.rxjava;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by zhangjie on 16/9/18.
 *
 * just是最常用的一个操作符，它的目的是构建一个Observable然后发射出去
 * 使用起来非常简单
 *
 */
public class JustOperator {

    public static void main(String[] args) {

        //字符串
        Observable.just("Hello World")
            .subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    System.out.println(s);
                }
            });

        //lambda写法
        //long型数据
        Observable.just(System.currentTimeMillis())
            .subscribe(i -> System.out.println("current time = " + i));

        //数组
        Observable.just(new String[] {"Hello", "World"})
            .subscribe(array -> {
                for(String s : array) {
                    System.out.println(s);
                }
            });

    }

}
