package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public class MockConvertor implements Convertor {

    @Override
    public String getLabel() {
        return "Test convetor";
    }

    @Override
    public int[][][] compute(Image imageLeft, Image imageRight) {
        int[][] r = imageLeft.getArray()[0];
        int[][] g = imageLeft.getArray()[0];
        int[][] b = imageLeft.getArray()[0];
        return new int[][][] {
                r, g, b
        };
    }
}
