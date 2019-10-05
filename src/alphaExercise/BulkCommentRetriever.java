package alphaExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;

public class BulkCommentRetriever implements Flow.Publisher<String> {

    private Flow.Subscriber<? super String> subscriber;
    private String url;

    public BulkCommentRetriever(String url) {
        this.url = url;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
    }

    public void getComments() {
        try {
            String comments = retrieveComments();
            List<String> commentList = Arrays.asList(comments.split("},[ ]+\\{"));
            commentList.forEach(subscriber::onNext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.subscriber.onComplete();
    }

    private String retrieveComments() throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}
