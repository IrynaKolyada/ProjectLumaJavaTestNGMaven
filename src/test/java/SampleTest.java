import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void testPass() {

        Assert.assertTrue(true);
    }

    @Test
    public void testFail() {

        Assert.assertTrue(false);
    }
}
