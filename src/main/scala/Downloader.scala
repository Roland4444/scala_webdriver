import java.io._
import java.net.{HttpURLConnection, URL}

class Downloader {
  def getFilefromURL(inputLink: String, fileName: String): Unit ={
    val url = new URL(inputLink)
    val connection = url.openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("GET")
    val in: InputStream = connection.getInputStream
    val fileToDownloadAs = new java.io.File(fileName)
    val out: OutputStream = new BufferedOutputStream(new FileOutputStream(fileToDownloadAs))
    val byteArray = Stream.continually(in.read).takeWhile(-1 !=).map(_.toByte).toArray
    out.write(byteArray)
    out.close()
  }

}
