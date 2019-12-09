package pl.martenn.jpaczkomaty.operations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.box.BoxGroupBuilder;
import pl.martenn.jpaczkomaty.machine.MachineFreeSpaceVisitor;
import pl.martenn.jpaczkomaty.machine.PackMachine;
import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.pack.PackSize;
import pl.martenn.jpaczkomaty.transport.Transport;

class SendPackOperationTest {

    private PackMachine packMachine = new PackMachine("PCK0");

    @BeforeEach
    public void init() {
        packMachine.add(BoxGroupBuilder.builder().withA(2).withB(4).withC(2).build());
    }

    @Test
    public void shouldPutPackIntoMachineUsingTransport() {
        // given
        Transport transport = new Transport("1", new Pack("1", PackSize.A), "PCK1");
        assertPackMachineEmpty();
        PackOperation operation = new SendPackOperation(transport, packMachine);

        // when
        operation.execute();

        // then
        Assertions.assertThat(transport.getPlace()).isEqualTo(packMachine.getId());
        assertPackMachineWithOneOccupiedBox();
    }

    private void assertPackMachineWithOneOccupiedBox() {
        MachineFreeSpaceVisitor visitor = new MachineFreeSpaceVisitor();
        packMachine.accept(visitor);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.A)).isEqualTo(1);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.B)).isEqualTo(4);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.C)).isEqualTo(2);
    }

    private void assertPackMachineEmpty() {
        MachineFreeSpaceVisitor visitor = new MachineFreeSpaceVisitor();
        packMachine.accept(visitor);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.A)).isEqualTo(2);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.B)).isEqualTo(4);
        Assertions.assertThat(visitor.getQuantities().get(PackSize.C)).isEqualTo(2);
    }

}