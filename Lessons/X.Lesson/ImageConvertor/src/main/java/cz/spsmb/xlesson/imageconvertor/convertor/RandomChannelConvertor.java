package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public class RandomChannelConvertor implements Convertor {

    @Override
    public String getLabel() {
        return "Random channel";
    }

    @Override
    public int[][][] compute(Image imageLeft, Image imageRight) {
        int[][][] leftImg = imageLeft.getArray();
        int[][][] rightImg = imageRight.getArray();

        return new int[][][] {
                leftImg[randomChannel()],
                rightImg[randomChannel()],
                leftImg[randomChannel()]
        };
    }

    private int randomChannel() {
        return (int) (Math.random() * 3);
    }
}
