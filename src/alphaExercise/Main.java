package alphaExercise;

public class Main {

    public static void main(String[] args) {
        BulkCommentRetriever bulkCommentRetriever =
                new BulkCommentRetriever("https://jsonplaceholder.typicode.com/comments");
        EmailExtractor<String, String> emailExtractor = new EmailExtractor<>();
        EmailCounter<String, String> emailCounter = new EmailCounter<>();
        emailExtractor.subscribe(emailCounter);
        bulkCommentRetriever.subscribe(emailExtractor);
        bulkCommentRetriever.getComments();

        System.out.println("--------------------------------------");
        System.out.println(emailCounter.getResult());
    }

}
