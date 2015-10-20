package bob.sun;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import java.lang.Override;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;

/**
 * Created by bob.sun on 15/10/20.
 */

public class Basic {
    public static void main(String[] args){
        Observable<String> observable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Whaaat?");
                    }
                }
        );

        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String result) {
                System.out.println(result);
            }
        };

        observable.subscribe(subscriber);

        /**
         * Use wrapped observable & action to get a more simple code.
         */

        Observable<String> simpleObs = Observable.just("Fuck me.");
        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };

        /**
         * This function may accept three arguments, onNextAction, onErrorAction, onCompleteAction.
         */
        simpleObs.subscribe(action1);

        /**
         * Use lambdas.
         */

        Observable
                .just("Hi there lambda")
                .subscribe(string -> System.out.println(string));
    }


}
