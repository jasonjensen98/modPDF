import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;

import org.apache.pdfbox.printing.PDFPageable;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import org.apache.pdfbox.pdmodel.PDDocument;
import javax.print.PrintService;
import java.awt.print.PrinterJob;


public class PDFLogic  {
    public static void linkToImage(String pdfURL) throws IOException {
        File oldFile = new File(pdfURL);
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
                        String basePath = new File("").getAbsolutePath();
                        File outputImage = new File(basePath + "\\src\\main\\resources\\png\\" + imageName);
                        System.out.println(basePath);
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

        document.close();

    }

    public static void printPDF(PDDocument document) {
        try {

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPageable(new PDFPageable(document));

            if (job.printDialog()) {
                job.print();
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
