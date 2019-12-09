package pl.martenn.jpaczkomaty.machine;

import pl.martenn.jpaczkomaty.box.Box;
import pl.martenn.jpaczkomaty.box.BoxGroup;
import pl.martenn.jpaczkomaty.pack.PackSize;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class MachineFreeSpaceVisitor implements MachineVisitor {
    @Getter
    private Map<PackSize, Integer> quantities = new HashMap<>();

    public MachineFreeSpaceVisitor() {
    }

    @Override
    public void visitBox(Box box) {
        PackSize packKey = box.getSize();
        if (box.isEmpty()) {
            int quantity = 0;
            if (quantities.containsKey(packKey)) {
                quantity = quantities.get(packKey);
            }
            quantities.put(packKey, quantity + 1);
        }
    }

    @Override
    public void visitBoxGroup(BoxGroup boxGroup) {
    }

    @Override
    public void visitPackMachine(PackMachine packMachine) {
    }
}
