import java.awt.Rectangle
import java.io.{BufferedOutputStream, File, FileOutputStream, OutputStream}
import org.apache.pdfbox.text.PDFTextStripper
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripperByArea
class readPDF {
  def readPDF(fileName: String): String={
    val document = PDDocument.load(new File(fileName))
		val stripper = new PDFTextStripperByArea
    stripper.setSortByPosition( true );
    val rect  = new Rectangle( 0, 0, 500, 600 );
    stripper.addRegion( "class1", rect );
		val firstPage = document.getPage(0);
    stripper.extractRegions( firstPage );
		stripper.getTextForRegion( "class1" )
  }

  def readPDFAll(fileName: String): String={
    val pdd = PDDocument.load(new File(fileName))
    new PDFTextStripper().getText(pdd)
  }

	def readPDF(fileName: String, x: Integer, y: Integer, width: Integer, height: Integer): String={
		val document = PDDocument.load(new File(fileName))
		val stripper = new PDFTextStripperByArea
		stripper.setSortByPosition( true );
		val rect  = new Rectangle( x, y, width, height );
		stripper.addRegion( "class1", rect );
		val firstPage = document.getPage(0);
		stripper.extractRegions( firstPage );
		stripper.getTextForRegion( "class1" )
	}
}
