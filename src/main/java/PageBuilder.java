import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.File;
import javax.imageio.ImageIO;

public class PageBuilder {
    private Queue<PageProperty> pageProperties;
    private PageProperty currentPage;
    private ImageManager imageManager;
    public PageBuilder(Queue<PageProperty> pageProperties, Queue<String> urls) {
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
}
