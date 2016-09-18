package com.rxjava;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by zhangjie on 16/9/8.
 */

/**
 * Range操作符主要接受2个参数
 * start: 起始
 * count: 从起始开始的数量（切记不是end)
 */
public class RangeOperator {

    public static void main(String[] args) {

        Observable.range(10, 5)
            .subscribe(new Action1<Integer>() {
                public void call(Integer integer) {
                    System.out.println("Number: " + integer.intValue());
                }
            });

        //用Lambda表达式
        Observable.range(20, 5)
            .subscribe(i -> {
                String out = "Number: " + i;
                System.out.println(out);
            });

        String number = "helloworld";
        Observable.range(5, 4)
            .subscribe(new Action1<Integer>() {
                @Override
                public void call(Integer integer) {
                    System.out.println(number.charAt(integer.intValue()));
                }
            });

    }

}
