package pl.martenn.jpaczkomaty.machine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.box.BoxGroupBuilder;
import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.pack.PackSize;

class MachineFreeSpaceVisitorTest {
    private MachineFreeSpaceVisitor visitor = new MachineFreeSpaceVisitor();
    private PackMachine packMachine = new PackMachine("PCK0");

    @Test
    //@Disabled
    public void shouldCountFreeSpaces() {
        // given
        packMachine.add(BoxGroupBuilder.builder().withA(2).withB(4).withC(2).build());
        packMachine.put(new Pack("1", PackSize.B));

        // when
        packMachine.accept(visitor);

        // then
        Assertions.assertThat(visitor.getQuantities().get(PackSize.A)).isEqualTo(2);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.B)).isEqualTo(3);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.C)).isEqualTo(2);
    }
}