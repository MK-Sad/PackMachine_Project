package pl.martenn.jpaczkomaty.box;

import pl.martenn.jpaczkomaty.pack.PackSize;

import java.util.ArrayList;
import java.util.List;

public class BoxGroupBuilder {
    private int aBoxes;
    private int bBoxes;
    private int cBoxes;

    private BoxGroupBuilder() {
    }

    public static BoxGroupBuilder builder() {
            return new BoxGroupBuilder();
    }

    public BoxGroupBuilder withA(int a) {
        aBoxes = a;
        return this;
    }

    public BoxGroupBuilder withB(int b) {
        bBoxes = b;
        return this;
    }

    public BoxGroupBuilder withC(int c) {
        cBoxes = c;
        return this;
    }

    public BoxGroup build() {
        BoxGroup group = new BoxGroup();
        List<Box> boxes = new ArrayList<>();
        boxes.addAll(buildBoxArray(PackSize.A, aBoxes));
        boxes.addAll(buildBoxArray(PackSize.B, bBoxes));
        boxes.addAll(buildBoxArray(PackSize.C, cBoxes));
        group.setBoxes(boxes);
        return group;
    }

    private List<Box> buildBoxArray(PackSize packSize, int numberOfBoxes) {
        List<Box> result = new ArrayList<>();
        for (int i = 0; i < numberOfBoxes; i++) {
            result.add(new Box(packSize));
        }
        return result;
    }

}
