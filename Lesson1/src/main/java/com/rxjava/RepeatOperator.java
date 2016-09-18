package com.rxjava;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by zhangjie on 16/9/18.
 *
 * repeat会将一个Observable对象重复发送，并且可以指定
 * 发送的次数以及发送的线程
 *
 */
public class RepeatOperator {

    public static void main(String[] args) {

        /**
         * 首先需要构造一个Observable，然后调用一次repeat进行发送
         * 线程同Interval
         */
        Observable.just(1).repeat(5, Schedulers.immediate())
            .subscribe(i -> System.out.println("" + i));

    }

}
