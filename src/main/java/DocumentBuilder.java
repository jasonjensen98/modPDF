import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;
import java.util.Queue;

public class DocumentBuilder {
    private Queue<String> urls;
    PageLayout layout = PageLayout.A4x4;


    public DocumentBuilder(Queue<String> urls) {
        this.urls = urls;
    }
    public void ImageBuild() {
        PDDocument newDocument = new PDDocument();
        ImageManager images = new ImageManager(urls);
        try {
            while(images.hasNextImage()) {
                PDPage page = new PDPage(PDRectangle.LETTER);
                newDocument.addPage(page);
                try (PDPageContentStream contentStream = new PDPageContentStream(newDocument, page)) {
                    for (int i = 0; i < layout.lengthOfCoordinates() && images.hasNextImage(); i++) {
                        contentStream.drawImage(images.nextImage(),
                                layout.getCoordinatesX(i),
                                layout.getCoordinatesY(i),
                                layout.getPaperSizeX(),
                                layout.getPaperSizeY());
                    }
                } catch (IOException e) {

                }
            }
            newDocument.save("output.pdf");
            newDocument.close();
            System.out.println("New Doc!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
