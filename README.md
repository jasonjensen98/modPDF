# modPDF
modPDF is a java library that implements apache PDFBox. This library has methods that allow for object extraction from pdf files as well as pdf file creation.

modPDF is intended to allow propgramattic pdf file creation, specified through object size, placement and objects themselves. 
modPDF should be implemented as a service. 

'ImageManager' constructor accepts a queue of Strings as parameter which is a list of reference to pdf file locations. The constructor opens the first document in memory and creates a new queue of Images from that document. The 'nextImage' method returns the PDImageXObject at the front of the queue. When the queue of images if empty the method automatically closes the current document, dueques the next url, opens that document, then loads all the images of the current document. The 'nextImage' method will continue to pass PDImageXObjects until urls and imageQueue is empty. 

'DocumentBuilder' constructor accepts a url queue and builds an ImageManager. Then, based on selected enum, will build new pdf according to specs of enum. 

The enum class defines image size, page size, and image placement locations.

Future features:
Document processing that validates X dimension/module specifications. It can return information such as required dpi, and X dimension which aids decision making process for print quality and scanning enviornment. 
Program to seamlessly accept PDFs, Images, page information and return pdf files. 
Barcode builder: build image based on barcode data, barcode type, barcode encoding, barcode size, additional text information, rfid information, icons or logos. 
