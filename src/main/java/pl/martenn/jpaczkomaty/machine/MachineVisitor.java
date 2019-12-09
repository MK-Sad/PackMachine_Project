package pl.martenn.jpaczkomaty.machine;

import pl.martenn.jpaczkomaty.box.Box;
import pl.martenn.jpaczkomaty.box.BoxGroup;

public interface MachineVisitor {
    void visitBox(Box box);
    void visitBoxGroup(BoxGroup boxGroup);
    void visitPackMachine(PackMachine packMachine);
}
