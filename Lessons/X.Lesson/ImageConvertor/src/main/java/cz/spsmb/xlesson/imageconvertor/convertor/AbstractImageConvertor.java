package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public abstract class AbstractImageConvertor implements Convertor {

    @Override
    public int[][][] compute(Image imageLeft, Image imageRight) {
        return computeImage(imageLeft, imageRight);
    }

    protected abstract int[][][] computeImage(Image imageLeft, Image imageRight);
}
