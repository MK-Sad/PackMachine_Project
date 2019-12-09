package pl.martenn.jpaczkomaty.machine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.martenn.jpaczkomaty.box.Box;
import pl.martenn.jpaczkomaty.box.BoxGroup;
import pl.martenn.jpaczkomaty.pack.Pack;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PackMachine {

    @Getter
    private final String id;
    private List<BoxGroup> groups = new ArrayList<>();

    public void put(Pack pack) {
        for (BoxGroup group : groups) {
            Box box = group.getSmallestEmptyBox(pack.getSize());
            if (box != null) {
                box.put(pack);
                return;
            }
        }
    }

    public void add(BoxGroup group) {
        this.groups.add(group);
    }

    public void clear() {
        groups.clear();
    }

    public void accept(MachineVisitor visitor) {
        visitor.visitPackMachine(this);
        groups.forEach(group -> group.accept(visitor));
    }
}
