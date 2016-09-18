package com.rxjava;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangjie on 16/9/18.
 */
public class IntervalOperator {

    public static void main(String[] args) {

        /**
         * 每隔一段时间从0开始发射数字
         * interval比较特殊，在computation Scheduler中运行的
         * 所以如果要进行演示，需要制定Scheduler为immediate(当前线程）
         * 要不会一闪而过。
         */
        Observable.interval(1, TimeUnit.SECONDS, Schedulers.immediate())
            .subscribe(i -> System.out.println("" + i));

        /**
         * 初始延迟时间
         * 2次发送之间间隔多长时间
         * 执行调度线程
         */
//        Observable.interval(5, 1, TimeUnit.SECONDS, Schedulers.immediate())
//            .subscribe(i -> System.out.println("" + i));

    }

}
