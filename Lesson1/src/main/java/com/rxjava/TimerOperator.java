package com.rxjava;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangjie on 16/9/18.
 *
 * 和Interval很类似，不过只发送一次
 *
 */
public class TimerOperator {

    public static void main(String[] args) {

        Observable.timer(5, TimeUnit.SECONDS, Schedulers.immediate())
            .subscribe(new Action1<Long>() {
                @Override
                public void call(Long aLong) {
                    System.out.println("" + aLong);
                }
            });
    }

}
