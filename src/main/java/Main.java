
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.util.Matrix;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.File;
import javax.imageio.ImageIO;



public class Main {
    public static void main(final String[] args) throws IOException {



        Queue<String> queue = new LinkedList<>();

        // Adding lists to the queue
        queue.add("1.pdf");
        queue.add("2.pdf");
        queue.add("3.pdf");
        queue.add("4.pdf");
        queue.add("5.pdf");
        queue.add("6.pdf");
        queue.add("7.pdf");
        queue.add("8.pdf");
        queue.add("9.pdf");
        queue.add("10.pdf");
        queue.add("11.pdf");
        queue.add("12.pdf");
        queue.add("13.pdf");
        queue.add("14.pdf");
        queue.add("15.pdf");
        queue.add("16.pdf");

        ImageManager imageManage = new ImageManager(queue);
        PDDocument document = new PDDocument();


        try {

            while ((!imageManage.urls.isEmpty())) {
                PDRectangle a4 = PDRectangle.A4;
                PDPage page = new PDPage(a4);
                document.addPage(page);
                PDImageXObject image = imageManage.nextImage();

                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                // Center the image on the page
                float scale = 1.0f; // Adjust scale factor as needed
                float imageWidth = image.getWidth() * scale;
                float imageHeight = image.getHeight() * scale;

                float xPosition = (a4.getWidth() - imageWidth) / 2;
                float yPosition = (a4.getHeight() - imageHeight) / 2;

                contentStream.drawImage(image, xPosition, yPosition, imageWidth, imageHeight);

                contentStream.close();

            }

            document.save("output.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
