package cz.spsmb.xlesson.imageconvertor.model;

/**
 * Represents convolution filter
 */
public interface Filter {

    /**
     * Returns filter as array of integers
     *
     * @return integer array
     */
    int[][] getArray();
}

