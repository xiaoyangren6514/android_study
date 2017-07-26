package com.happy.rxjava.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/**
 * RxJava:在JVM上使用可观测的序列来组成异步的基于事件的程序的库
 * observer 观察者
 * observerable 被观察者
 * subcribe 订阅
 * event 事件
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Flowable<String> observable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("aaa");
                e.onNext("bbb");
                e.onComplete();
            }
        }, BackpressureStrategy.MISSING);

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.v(TAG, "onSubscribe"+s.getClass());
            }

            @Override
            public void onNext(String s) {
                Log.v(TAG, "onNext");
                Log.v(TAG, s);
            }

            @Override
            public void onError(Throwable t) {
                Log.v(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.v(TAG, "onComplete");
            }
        };

        observable.subscribe(subscriber);

    }
}
