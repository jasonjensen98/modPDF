# modPDF
modPDF is a java library that implements apache PDFBox. This library has methods that allow for object extraction from pdf files as well as pdf file creation.

'ImageManager' constructor accepts a queue of Strings as parameter which is a list of reference to pdf file locations. The constructor opens the first document in memory and creates a new queue of Images from that document. The 'nextImage' method returns the PDImageXObject at the front of the queue. When the queue of images if empty the method automatically closes the current document, dueques the next url, opens that document, then loads all the images of the current document. The 'nextImage' method will continue to pass PDImageXObjects until urls and imageQueue is empty. 
