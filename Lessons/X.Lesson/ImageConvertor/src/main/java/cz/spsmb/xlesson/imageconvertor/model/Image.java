package cz.spsmb.xlesson.imageconvertor.model;

/**
 * Interface represents RGB image
 */
public interface Image {

    /**
     * Returns RGB image as array of integers
     *
     * @return integer array
     */
    int[][][] getArray();
}
