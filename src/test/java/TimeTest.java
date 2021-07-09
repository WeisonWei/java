import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class TimeTest {

    @Test
    public void NanosTest() throws InterruptedException {
        long l = System.nanoTime();
        TimeUnit.NANOSECONDS.sleep(10);
        long l1 = System.nanoTime();
        long l2 = l1 - l;
        if (l2 > 10) {
            System.out.println(">>>>>>l2 > 10>>>>>>>>");
        }
    }
}
