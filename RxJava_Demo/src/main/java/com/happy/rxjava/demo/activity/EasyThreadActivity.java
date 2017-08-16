package com.happy.rxjava.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.happy.rxjava.demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 线程控制
 */
public class EasyThreadActivity extends AppCompatActivity {

    public static final String TAG = "EasyThreadActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_thread);
        onNormal();
        onTestThread();
        onTestThread2();
        onTestThread3();
    }

    /**
     * 子线程发送事件
     * 主线程接收事件
     */
    private void onTestThread3() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.v(TAG, "onTestThread3 subscribe " + Thread.currentThread().getName());
                e.onNext("a");
            }
        });
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.v(TAG, "onTestThread3 accept " + Thread.currentThread().getName());
            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.v(TAG, "onTestThread3 first accept " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.v(TAG, "onTestThread3 second accept " + Thread.currentThread().getName());
                    }
                }).subscribe(consumer);
    }

    /**
     * 子线程发送事件
     * 主线程接收事件
     * subscribeOn 只有第一个有效
     */
    private void onTestThread2() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.v(TAG, "onTestThread2 subscribe " + Thread.currentThread().getName());
                e.onNext("a");
            }
        });
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.v(TAG, "onTestThread2 accept " + Thread.currentThread().getName());
            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    /**
     * 默认发送和接收事件线程都是一个
     */
    private void onTestThread() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.v(TAG, "onTestThread subscribe " + Thread.currentThread().getName());
                e.onNext("a");
            }
        });
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.v(TAG, "onTestThread accept " + Thread.currentThread().getName());
            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .subscribe(consumer);
    }

    private void onNormal() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.v(TAG, "subscribe " + Thread.currentThread().getName());
                e.onNext("test");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "onSubscribe " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(String value) {
                Log.v(TAG, "onNext " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.v(TAG, "onError " + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                Log.v(TAG, "onComplete " + Thread.currentThread().getName());
            }
        });
    }

}
