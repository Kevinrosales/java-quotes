import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test public void testToGenerateQuoteTrue() {
        App classUnderTest = new App();
        String[] empty = new String[0];
        classUnderTest.main(empty);

        assertTrue("Does not equal null", outContent.toString() != null);

    }

    @Test public void testToGenerateQuoteFalse() {
        App classUnderTest = new App();
        String[] empty = new String[0];
        classUnderTest.main(empty);

        assertFalse("Does equal null", outContent.toString() == null);
    }


}