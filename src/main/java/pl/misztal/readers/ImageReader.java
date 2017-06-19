package pl.misztal.readers;

import pl.misztal.data.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Krzysztof
 */
public class ImageReader extends DataReader {

    public ImageReader() {

    }

    private static List<Point> readPNG(String filename, String type) throws IOException {
        CopyOnWriteArrayList<Point> result = new CopyOnWriteArrayList<>();

        String dir = System.getProperty("user.dir");

        BufferedImage bufferedImage = ImageIO.read(new File(filename));
        Raster raster = bufferedImage.getData().createTranslatedChild(0, 0);
        ColorModel colorModel = bufferedImage.getColorModel();


        int[] bitDepth = colorModel.getComponentSize();
        int channelCount = colorModel.getNumColorComponents();

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                final int rgb = bufferedImage.getRGB(j, i);
                final int alpha = (rgb >> 24) & 0xFF;
                final int red = (rgb >> 16) & 0xFF;
                final int green = (rgb >> 8) & 0xFF;
                final int blue = (rgb) & 0xFF;
//                double weight = 0;
//                double tempSum = 0;
//                tempSum += red;
//                tempSum += green;
//                tempSum += blue;
//                tempSum = tempSum / 3;
//                weight = (255. - tempSum) * alpha / 255. / 255.;
//                System.out.println(weight);
//                if (weight > 0.000_000_001)
                result.add(new Point(1, j, height - i, alpha, red, green, blue));
            }
        }
        return result;
    }

    @Override
    public boolean type(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Point> read(String filename, String type) throws IOException {
        Data.DataType inputType = Data.DataType.getByIdentifier(type);
        if (inputType == null)
            throw new UnsupportedOperationException("Not supported yet.");
        switch (inputType) {
            case IMAGE_PNG:
                return readPNG(filename, type);
            case IMAGE_TIFF:
            case IMAGE_BMP:
                AdvancedImageAdapter advancedImageAdapter = new AdvancedImageAdapter(type);
                return advancedImageAdapter.read(filename);
            default:
                if (successor != null) {
                    return successor.read(filename, type);
                } else {
                    throw new RuntimeException("File type unsupported");
                }
        }
    }
}
