public enum PageLayout {
    //A4x4(new int[] {612, 792}, new int[] {18, 18}, new int[] {774, 338}, new int[] {576, 360});
    A4x4(new int[] {150, 111}, new int[] {18, 18, 18}, new int[] {18, 150, 378}, new int[] {576, 360});
    private final int[] paperSize;

    private final int[] coordinatesX;

    private final int[] coordinatesY;
    private final int[] imageSize;


    PageLayout(int[] paperSize, int[] coordinatesX, int[] coordinatesY, int[] imageSize) {
        this.paperSize = paperSize;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.imageSize = imageSize;
    }

    public int getPaperSizeX() {
        return paperSize[0];
    }
    public int getPaperSizeY() {
        return paperSize[1];
    }
    public int lengthOfCoordinates() {
        if (coordinatesX.length == coordinatesY.length) {
            return coordinatesX.length;
        }
        System.out.println("INVALID ENUM DECLARATION, X & Y COORDINATES MUCH BE SAME LENGTH ARRAYS");
        return 0;
    }
    public int getCoordinatesX(int i) {
        return coordinatesX[i];
    }
    public int getCoordinatesY(int i) {
        return coordinatesY[i];
    }

    public int getImageSizeX() {
        return imageSize[0];
    }
    public int getImageSizeY() {
        return imageSize[1];
    }
}