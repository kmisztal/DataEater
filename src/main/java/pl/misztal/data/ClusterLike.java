package pl.misztal.data;

import org.ejml.simple.SimpleMatrix;

/**
 * @author Krzysztof
 */
public interface ClusterLike {

    double getWeight();

    SimpleMatrix getMean();

    SimpleMatrix getCov();

    int getCardinality();

}
