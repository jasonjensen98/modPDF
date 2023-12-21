import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import java.awt.print.PrinterJob;

public class PdfPrinter {
    public void printPdf(PDDocument document) {
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