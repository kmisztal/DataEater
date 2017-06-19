package pl.misztal.readers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by krzys on 16.06.2017.
 */
class DataTest {
    @Test
    void readPNG() {
        Data data = new Data();
        data.read("src/main/resources/data_test/png/circles.png", "image/png");

        assert data.getSize() == 100 * 80;//2036;
    }

    @Test
    void readBMP() {
        Data data = new Data();
        data.read("src/main/resources/data_test/bmp/example.bmp", "image/bmp");
        assertEquals(data.getSize(), 640 * 893);//116136
    }

    @Test
    void readTIFF() {
        Data data = new Data();
        data.read("src/main/resources/data_test/tiff/example.tiff", "image/tiff");
        assertEquals(data.getSize(), 277 * 339);//93902
    }
}