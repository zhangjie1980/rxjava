package com.rxjava;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by zhangjie on 16/9/18.
 *
 * defer的意思是延迟创建对象，当调用subscribe后生成新的一个Observable
 * 所以每一次的值是不一样的。
 *
 * defer接受的是一个Observable对象，当defer被subscribe后，回去调用这个
 * Observable对象来完成工作，所以看起来每一次都是不一样的。
 *
 * 和just进行对比后发现，just一旦设置好了以后，那么调用subscribe后每次
 * 打印的值是一样的。
 *
 */
public class DeferOperator {

    public static void main(String[] args) {

        /**
         * 去看下是否每一次打印出来的数据是否一致
         * 和just对比一下
         */
        for (int i = 0 ; i < 5 ; ++i) {
            Observable.defer(new Func0<Observable<Long>>() {
                @Override
                public Observable<Long> call() {
                    return Observable.just(System.currentTimeMillis());
                }
            }).subscribe(value -> System.out.println("current time = " + value));

            //lambda表达式写法
            Observable.defer(() -> Observable.just(System.currentTimeMillis()))
                .subscribe(value -> System.out.println("lambda current time = " + value));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
