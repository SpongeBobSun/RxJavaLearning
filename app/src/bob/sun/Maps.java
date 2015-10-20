package bob.sun;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bob.sun on 15/10/20.
 */
public class Maps {
    public Maps(){
//        new BasicMap();
//        new TransMap();
        new FlatMap();
    }
    public static void main(String[] args){
        Maps maps = new Maps();
    }

    class BasicMap{
        public BasicMap(){
            Observable.just("Fuck me ")
                    .map(s -> s + "harder, nigga!")
                    .subscribe(s -> System.out.println(s));
        }
    }

    class TransMap{
        public TransMap(){
            Observable.just("I want to know my hash value!!")
                    .map(s -> {
                        System.out.println(s);
                        return s.hashCode();
                    })
                    .subscribe(integer -> {
                        System.out.println(integer);
                    });
        }
    }

    class FlatMap{
        HashMap<String, ArrayList> urlMap;
        public FlatMap(){
            urlMap = new HashMap<>();
            ArrayList<String> outside = new ArrayList();
            outside.add("www.google.com");
            outside.add("www.facebook.com");
            outside.add("www.github.com");
            outside.add("www.twitter.com");

            ArrayList<String> sucker = new ArrayList<>();
            sucker.add("www.baidu.com");

            urlMap.put("Outside the wall", outside);
            urlMap.put("sucker", sucker);

            Observable.from(outside)
                    .flatMap(url ->Observable.just(url))
                    .subscribe(s -> System.out.println(s));

        }
    }
}
