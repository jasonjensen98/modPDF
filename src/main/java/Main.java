import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        File oldFile = new File("D:\\LabelPDFDigestion\\src\\PDF_document.pdf");
        PDDocument document = PDDocument.load(oldFile);

        int pageNum = 0;

        for (PDPage page : document.getPages()) {
            PDResources resources = page.getResources();

            if (resources != null) {
                for (COSName xObjectName : resources.getXObjectNames()) {
                    // Check if the XObject is an image
                    if (resources.isImageXObject(xObjectName)) {
                        PDImageXObject xObject = (PDImageXObject) resources.getXObject(xObjectName);

                        // Extracted image is saved as a PNG file
                        String imageName = "page" + (pageNum + 1) + "_image" + xObjectName.getName() + ".png";
                        File outputImage = new File("D:\\LabelPDFDigestion\\src\\output_images\\" + imageName);

                        // Get the BufferedImage from the PDImageXObject
                        BufferedImage image = xObject.getImage();

                        // Save the image using ImageIO
                        ImageIO.write(image, "png", outputImage);

                        System.out.println("Extracted image: " + outputImage.
                                getAbsolutePath());
                    }
                }
            }

            pageNum++;
        }

        // Close the PDF document
        document.close();
    }
}
