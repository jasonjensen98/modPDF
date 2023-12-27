import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ImageManager {
    private Queue<String> urls;
    private Queue<PDImageXObject> imageQueue;
    private PDDocument currentDocument;

    public ImageManager(Queue<String> urls) {
        this.urls = urls;
        this.currentDocument = loadPdfInMemory(urls.poll());
        this.imageQueue = processPdfObject();
    }

    public PDImageXObject nextImage() {
        if (!imageQueue.isEmpty()) {
            return imageQueue.poll();
        } else if (!urls.isEmpty()) {
          //  try {
                //currentDocument.close();
          //  } catch (IOException e) {

         //   }
            currentDocument = loadPdfInMemory(urls.poll());
            imageQueue = processPdfObject();
            return imageQueue.poll();

        }
       //     try {
               // currentDocument.close();
       //     } catch (IOException e) {

       //     }
            System.out.println("All images processed");
            return null;

    }
    public boolean hasNextImage() {
        if(urls.isEmpty() && imageQueue.isEmpty()) {
            return false;
        }
        return true;
    }

    public Queue<PDImageXObject> processPdfObject() {
        Queue<PDImageXObject> imageQueue = new LinkedList<>();
        for (PDPage page : currentDocument.getPages()) {
            PDResources resources = page.getResources();
            if (resources != null) {
                for (COSName xObjectName : resources.getXObjectNames()) {
                    // Check if the XObject is an image
                    if (resources.isImageXObject(xObjectName)) {
                        try {
                            imageQueue.add((PDImageXObject) resources.getXObject(xObjectName));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return imageQueue;
    }

    public PDDocument loadPdfInMemory(String url) {
        try {
            File oldFile = new File(url);
            return PDDocument.load(oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
