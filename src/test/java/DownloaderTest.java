import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DownloaderTest {

    @Test
    public void getFilefromURL() {
        String filename = "tmps";
        String URL = "https://kad.arbitr.ru/PdfDocument/f0f9227e-1d94-4acc-b340-88e3f5a93816/ddd55fa0-f75a-4ec3-90d5-69b3f8385de1/%D0%9006-9454-2017__20180314.pdf";
        Downloader d = new Downloader();
        d.getFilefromURL(URL, filename);
        assertNotEquals(0, new File(filename).length());
    }
}