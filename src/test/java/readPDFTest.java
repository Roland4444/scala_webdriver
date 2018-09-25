import org.junit.Test;

import static org.junit.Assert.*;

public class readPDFTest {

    @Test
    public void readPDF() {
        readPDF r = new readPDF();
        assertEquals("текст\n", r.readPDF("testPDF.pdf"));

    }
}