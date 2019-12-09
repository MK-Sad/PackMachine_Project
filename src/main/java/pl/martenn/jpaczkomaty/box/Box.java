package pl.martenn.jpaczkomaty.box;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.martenn.jpaczkomaty.machine.MachineVisitor;
import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.pack.PackSize;

@RequiredArgsConstructor
@Getter
public class Box {
    private final PackSize size;
    private Pack pack;

    public boolean isEmpty() {
        return pack == null;
    }

    public Pack retrieve() {
        Pack pack = this.pack;
        this.pack = null;
        return pack;
    }

    public void put(Pack pack) {
        this.pack = pack;
    }

    public void accept(MachineVisitor visitor) {
        visitor.visitBox(this);
    }
}
