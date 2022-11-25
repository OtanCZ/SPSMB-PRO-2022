package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public class JoinImageConvertor extends AbstractImageConvertor {
    @Override
    protected int[][][] computeImage(Image imageLeft, Image imageRight) {
        int[][][] leftImg = imageLeft.getArray();
        int[][][] rightImg = imageRight.getArray();
        for(int channelIndex = 0; channelIndex < 3; channelIndex++){
            for (int i = 0; i < leftImg[channelIndex].length; i++) {
                for (int j = 0; j < leftImg[channelIndex][i].length; j++) {
                    if(i %2==0){
                        leftImg[channelIndex][i][j] = rightImg[channelIndex][i][j];
                    }
                }
            }
        }

        return leftImg;
    }

    @Override
    public String getLabel() {
        return "Join image";
    }
}
