package com.rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.Random;

/**
 * Created by zhangjie on 16/9/7.
 */
public class CreateOpetator {

    /**
     * 在这里，主要是创建了一个获取随机数的Observable对象
     * @return
     */
    public static Observable<Integer> getRandomNumber() {
        return
            Observable.create(new Observable.OnSubscribe<Integer>() {
                public void call(Subscriber<? super Integer> subscriber) {
                    if (subscriber.isUnsubscribed()) {
                        int random = new Random().nextInt(10);
                        subscriber.onNext(random);
                        subscriber.onCompleted();
                    }
                }
            });
    }

    public static void main(String[] args) {
        //创建Observable
        Observable<Integer> observable = CreateOpetator.getRandomNumber();

        //订阅
        observable.subscribe(new Subscriber<Integer>() {
            public void onCompleted() {
                System.out.println("onComplete");
            }
            public void onError(Throwable e) {
            }
            public void onNext(Integer integer) {
                System.out.println("onNext, Random = " + integer.intValue());
            }
        });
    }

}
