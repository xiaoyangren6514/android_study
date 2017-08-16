package com.happy.rxjava.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * RxJava:在JVM上使用可观测的序列来组成异步的基于事件的程序的库
 * observer 观察者
 * observerable 被观察者
 * subcribe 订阅
 * event 事件
 */
public class BaseUseActivity extends AppCompatActivity {

    private static final String TAG = "BaseUseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_use);
        onNormal();
        onError();
        onOverride();
    }

    private void onOverride() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("aaaa");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.v(TAG, "onOverride accept " + s);
            }
        });
    }

    private void onError() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("旺财");
                e.onNext("小强");
                e.onError(new RuntimeException("i am happy"));
                e.onNext("小丁");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "on error onSubscribe");
            }

            @Override
            public void onNext(String value) {
                Log.v(TAG, "on error onNext " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.v(TAG, "on error onError");
            }

            @Override
            public void onComplete() {
                Log.v(TAG, "on error onComplete");
            }
        });
    }

    private void onNormal() {
        // 创建一个上游事件发送者
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onComplete();
            }
        });
        // 创建一个下游事件接收者
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.v(TAG, "onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.v(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.v(TAG, "onComplete");
            }
        };
        // 建立连接
        observable.subscribe(observer);
    }
}
