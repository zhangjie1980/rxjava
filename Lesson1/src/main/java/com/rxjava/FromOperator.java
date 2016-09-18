package com.rxjava;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by zhangjie on 16/9/18.
 *
 * From操作符用来将数组或者列表中的每一个对象转化成为Observable对象
 * 然后依次发送出去，和just比较类似，但是just是把数组或者列表作为一个
 * 整体发送出去，而From是每一个分开发送。
 *
 */
public class FromOperator {

    public static void main(String[] args) {

        /**
         * 和just很类似，不过from本身进行了循环处理，也就是说
         * 避免了在just中进行for循环操作
         */
        Observable.from(new String[] {"Hello", "World"})
            .subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    System.out.println(s);
                }
            });

        //lambda写法
        Observable.from(new Integer[] {1,2,3,4})
            .subscribe(s -> System.out.println("" + s));
    }

}
