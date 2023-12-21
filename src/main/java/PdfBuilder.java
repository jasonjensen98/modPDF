import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class PdfBuilder {
    this.pageProperties = pageProperties;
    this.imageManager = new ImageManager(urls)
    PDDocument newDocument = new PDDocument();
        while(!pageProperties.isEmpty()) {
        this.currentPage = pageProperties.poll()
        PDPage page = new PDPage(PDRectangle.LETTER);
        newDocument.addPage(page);
        try(PDPageContentStream contentStream = new PDPageContentStream(newDocument, page)) {
            while(!currentPage.isObjectCoordinatesEmpty()) {
                contentStream.drawImage(imageManager.nextImage(), currentPage.getObjectCoordinates().getX(),
                        currentPage.getObjectCoordinates().getY(), currentPage.getPageSize().getX(),
                        currentPage.getPageSize().getY());
            }
        } catch (IOException e) {

        }
    }
}
