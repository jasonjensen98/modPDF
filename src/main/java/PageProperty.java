import java.util.Queue;

public class PageProperty {
    private PageSize pageSize;
    private ImageSize imageSize;

    private Queue<ObjectCoordinates> objectCoordinates;

    public PageProperty(PageSize pageSize, ImageSize imageSize, Queue<ObjectCoordinates> objectCoordinates) {
        this.pageSize = pageSize;
        this.imageSize = imageSize;
        this.objectCoordinates = objectCoordinates;
    }
    public PageSize getPageSize() {
        return pageSize;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public ObjectCoordinates getObjectCoordinates() {
        return objectCoordinates.poll();
    }
    public boolean isObjectCoordinatesEmpty() {
        return objectCoordinates.isEmpty();
    }
}
