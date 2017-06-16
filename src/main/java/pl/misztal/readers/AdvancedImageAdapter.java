package pl.misztal.readers;

import pl.misztal.data.Point;

import java.io.IOException;
import java.util.List;

public class AdvancedImageAdapter {

    AdvancedImageReader advancedImageReader;

    public AdvancedImageAdapter(String imageType) {
        if (imageType == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else {
            advancedImageReader = new AdvancedImageReader();
        }
    }

    public List<Point> read(String filename) throws IOException {
        return advancedImageReader.read(filename);
    }

}
