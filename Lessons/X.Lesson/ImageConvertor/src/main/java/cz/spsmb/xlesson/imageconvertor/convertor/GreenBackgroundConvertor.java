package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public class GreenBackgroundConvertor extends AbstractImageConvertor {

    @Override
    public String getLabel() {
        return "GreenBackground effect";
    }

    @Override
    protected int[][][] computeImage(Image imageLeft, Image imageRight) {
        int[][][] leftImg = imageLeft.getArray();
        int[][][] rightImg = imageRight.getArray();

        for (int i = 0; i < leftImg[1].length; i++) {
            for (int j = 0; j < leftImg[1][i].length; j++) {
                if (leftImg[1][i][j] > (leftImg[0][i][j] + leftImg[2][i][j])) {
                    leftImg[0][i][j] = rightImg[0][i][j];
                    leftImg[1][i][j] = rightImg[1][i][j];
                    leftImg[2][i][j] = rightImg[2][i][j];
                }
            }
        }

        return leftImg;
    }

}
