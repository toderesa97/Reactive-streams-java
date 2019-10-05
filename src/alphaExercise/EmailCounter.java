package alphaExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;

public class EmailCounter<T, R> implements Flow.Processor<T, R> {

    private Map<String, Integer> map = new HashMap<>();

    @Override
    public void subscribe(Flow.Subscriber<? super R> subscriber) {

    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(T item) {
        String email = (String) item;
        if (map.containsKey(email)) {
            map.put(email, map.get(email) + 1);
        } else {
            map.put(email, 1);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    public Map<String, Integer> getResult() {
        return map;
    }
}
