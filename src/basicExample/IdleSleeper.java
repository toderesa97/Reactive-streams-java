package basicExample;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class IdleSleeper {


    private static SecureRandom sr;

    public static void init() {
        try {
            if (sr == null)
                sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void run(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void random_sleep(int max_milis) {
        run(sr.nextInt(max_milis));
    }

}
