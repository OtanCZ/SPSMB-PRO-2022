package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public class RandomChannelConvertor extends AbstractImageConvertor {

    @Override
    public String getLabel() {
        return "Random channel";
    }

    @Override
    protected int[][][] computeImage(Image imageLeft, Image imageRight) {
        int[][] r = imageRight.getArray()[randomChannel()];
        int[][] g = imageLeft.getArray()[randomChannel()];
        int[][] b = imageRight.getArray()[randomChannel()];
        return new int[][][] {
                r, g, b
        };
    }

    private int randomChannel() {
        return (int)(Math.random() * 3);
    }
}
