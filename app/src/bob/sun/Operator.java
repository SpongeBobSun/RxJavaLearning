package bob.sun;

import rx.Observable;
import rx.Subscription;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bob.sun on 15/10/20.
 */
public class Operator {
    public Operator(){
//        new Filter();
        new DoOnNext();
    }
    public static void main(String[] args){
        new Operator();
    }

    public class Filter{
        public Filter(){
            ArrayList<String> outside = new ArrayList();
            outside.add("www.google.com");
            outside.add("www.facebook.com");
            outside.add("www.github.com");
            outside.add("www.twitter.com");
            outside.add("nil");

            Observable.from(outside)
                    .filter(url -> url != "nil")
                    .subscribe(url -> System.out.println(url));
            /**
             * `take` operator.
             */
            Observable.from(outside)
                    .take(3)
                    .subscribe(url -> System.out.println(url));
        }
    }

    class DoOnNext{
        {
            ArrayList<String> outside = new ArrayList();
            outside.add("www.google.com");
            outside.add("www.facebook.com");
            outside.add("www.github.com");
            outside.add("www.twitter.com");
            outside.add("nil");

            Observable.from(outside)
                    .doOnNext(url -> System.out.println("Before next action for " + url))
                    .subscribe(url -> System.out.println(url));
        }
    }
}
