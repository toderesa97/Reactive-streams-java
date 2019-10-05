package basicExample;

import java.util.concurrent.Flow;

public class Computer<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("SUBSCRIBING");
        this.subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println(String.format("Got %s", item.toString()));
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("DONE");
    }

}