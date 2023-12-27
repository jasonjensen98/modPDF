
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
        DocumentBuilder newBuilding = new DocumentBuilder(queue);
        newBuilding.ImageBuild();



    }


}
