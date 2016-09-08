package com.rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.Random;

/**
 * Created by zhangjie on 16/9/7.
 * <p>
 * 1. Create操作符主要是用来创建一个简单的Observable对象
 * 2. new Observable.OnSubscribe创建了一个观察者，在call方法内去调用subscriber的
 * 方法发送指令。
 * 3. 适合于一个成熟稳定的方法实现，返回指定的数据
 */
public class CreateOpetator {

    /**
     * 在这里，主要是创建了一个获取随机数的Observable对象
     *
     * @return
     */
    public static Observable<Integer> getRandomNumber() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    int random = new Random().nextInt(10);
                    subscriber.onNext(random);
                    subscriber.onCompleted();
                }
            }
        });
    }

    /**
     * 在这里，主要是创建了一个获取随机数的Observable对象
     *
     * @return
     */
    public static Observable<Integer> loop(final int index) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i < index; ++i) {
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {

        //创建Observable
        Observable<Integer> observable = CreateOpetator.getRandomNumber();

        //订阅
        observable
            .subscribe(new Subscriber<Integer>() {
                public void onCompleted() {
                    System.out.println("onComplete");
                }

                public void onError(Throwable e) {
                }

                public void onNext(Integer integer) {
                    System.out.println("onNext, Random = " + integer.intValue());
                }
            });


        CreateOpetator
            .loop(10)
            .subscribe(new Subscriber<Integer>() {
                public void onCompleted() {
                    System.out.println("onComplete");
                }

                public void onError(Throwable e) {
                }

                public void onNext(Integer integer) {
                    System.out.println("onNext, Number = " + integer.intValue());
                }
            });

        System.out.println("finish");

    }

}
