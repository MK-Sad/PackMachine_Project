package pl.martenn.jpaczkomaty.box;

import pl.martenn.jpaczkomaty.machine.MachineVisitor;
import pl.martenn.jpaczkomaty.pack.PackSize;

import java.util.*;

import lombok.Getter;

public class BoxGroup {

    @Getter
    private List<Box> boxes;
    private Map<PackSize, List<PackSize>> sizeMappings = new HashMap<>();

    public BoxGroup() {
        sizeMappings.put(PackSize.A, Arrays.asList(PackSize.A, PackSize.B, PackSize.C));
        sizeMappings.put(PackSize.B, Arrays.asList(PackSize.B, PackSize.C));
        sizeMappings.put(PackSize.C, Arrays.asList(PackSize.C));
    }

    public Box getSmallestEmptyBox(PackSize size) {
        List<PackSize> available = sizeMappings.get(size);
        for (PackSize p : available) {
            Optional<Box> candidate = boxes.stream()
                    .filter(box -> box.getSize().equals(p) && box.isEmpty())
                    .findFirst();
            if (candidate.isPresent()) {
                return candidate.get();
            }
        }

        return null;
    }

    public void accept(MachineVisitor visitor) {
        visitor.visitBoxGroup(this);
        boxes.forEach(box -> box.accept(visitor));
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }
}
