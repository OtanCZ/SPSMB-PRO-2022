package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public class CreateJAFlag extends AbstractImageConvertor {
    @Override
    protected int[][][] computeImage(Image imageLeft, Image imageRight) {
        int[][][] leftImg = imageLeft.getArray();

        for (int i = 0; i < leftImg[0].length; i++) {
            for (int j = 0; j < leftImg[0][0].length; j++) {
                leftImg[0][i][j] = 255;
                leftImg[1][i][j] = 255;
                leftImg[2][i][j] = 255;
            }
        }

        return leftImg;
    }

    @Override
    public String getLabel() {
        return "Japan Flag";
    }
}
