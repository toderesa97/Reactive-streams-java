package alphaExercise;

import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor<T, R> implements Flow.Processor<T, R> {

    private Flow.Subscriber<? super R> subscriber;

    @Override
    public void subscribe(Flow.Subscriber<? super R> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(T item) {
        String comment = (String) item;
        Pattern pattern = Pattern.compile("\"email\": \"([A-Za-z0-9_]+@[a-z0-9]+\\.[a-z]+)\"");
        Matcher matcher = pattern.matcher(comment);
        System.out.println("Finding email in " + item);
        if (matcher.find()) {
            String email = matcher.group(1);
            System.out.println("Found " + email);
            this.subscriber.onNext((R) email);
        }
        this.subscriber.onComplete();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
