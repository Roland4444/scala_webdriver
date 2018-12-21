import org.junit.Test;

import static org.junit.Assert.*;

public class readPDFTest {

    @Test
    public void readPDF() {
        readPDF r = new readPDF();
        assertEquals("текст\n", r.readPDF("testPDF.pdf"));

    }

    //А06-9454-2017__20180314.pdf
    @Test
    public void readPDF2() {
        readPDF r = new readPDF();
        assertNotEquals(null, r.readPDF("А06-9454-2017__20180314.pdf"));
        System.out.println(r.readPDF("А06-9454-2017__20180314.pdf"));

    }

    @Test
    public void readPDFAll() {
        readPDF r = new readPDF();
        assertEquals("текст\n", r.readPDFAll("testPDF.pdf"));
    }
    //McLaren 570S Spider Brochure.pdf

    @Test
    public void rFile() {
        readPDF r = new readPDF();
        assertNotEquals("текст\n", r.readPDFAll("McLaren 570S Spider Brochure.pdf"));
        System.out.println(r.readPDFAll("McLaren 570S Spider Brochure.pdf"));
    }

    @Test
    public void rtupidCBR() {
        readPDF r = new readPDF();
        assertNotEquals("текст\n", r.readPDFAll("/home/roland/Downloads/4859_U_06082018.pdf"));
        System.out.println(r.readPDFAll("/home/roland/Downloads/4859_U_06082018.pdf"));
    }
}