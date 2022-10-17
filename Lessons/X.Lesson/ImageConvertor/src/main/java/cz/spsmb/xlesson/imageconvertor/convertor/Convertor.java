package cz.spsmb.xlesson.imageconvertor.convertor;

import cz.spsmb.xlesson.imageconvertor.model.Image;

public interface Convertor {

    String getLabel();

    int[][][] compute(Image imageLeft, Image imageRight);
}
