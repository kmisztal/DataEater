package pl.edu.misztal.data;

import org.junit.Ignore;
import org.junit.Test;
import pl.edu.misztal.readers.Data;

/**
 * Created by krzys on 16.06.2017.
 */
@Ignore
public class ClusterTest {
    @Test
    public void add() {
//        Data data = new Data();
//        data.read("src/main/resources/data_test/png/circles.png", "image/png");
        Point[] points = {
                new Point(1, 1, 1, 1),
                new Point(1, 0, 0, 0)
        };
        Cluster cluster = new Cluster(3);
//        for(Point p : data.getData()){
//            cluster.add(p);
//        }
        for (Point p : points) {
            cluster.add(p);
        }

        System.out.println(cluster.getCov());
        System.out.println(cluster.getCardinality());
        System.out.println(cluster.getMean());
    }

    @Test
    public void addPNG() {
        Data data = new Data();
        data.read("src/main/resources/data_test/png/circles.png", "image/png");
//        Point [] points = {
//                new Point(1, 1,1,1),
//                new Point(1, 0,0,0)
//        };
        Cluster cluster = new Cluster(3);
        for (Point p : data.getData()) {
            cluster.add(p);
        }
//        for(Point p : points){
//            cluster.add(p);
//        }

        System.out.println(cluster.getCov());
        System.out.println(cluster.getCardinality());
        System.out.println(cluster.getMean());
    }
}