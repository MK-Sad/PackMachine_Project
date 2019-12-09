package pl.martenn.jpaczkomaty.machine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.box.BoxGroup;
import pl.martenn.jpaczkomaty.box.BoxGroupBuilder;
import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.pack.PackSize;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackMachineTest {
    private PackMachine packMachine = new PackMachine("PCK1");
    private BoxGroup boxGroup = BoxGroupBuilder.builder().withA(2).withB(4).withC(2).build();

    @BeforeEach
    public void init() {
        packMachine.add(boxGroup);
    }

    @Test
    public void shouldAddPackToFirstBox() {
        // given
        Pack pack = new Pack("1", PackSize.A);

        // when
        packMachine.put(pack);

        // then
        Assertions.assertThat(boxGroup.getBoxes().get(0).isEmpty()).isFalse();
        assertEquals(boxGroup.getBoxes().get(0).getPack(),pack);
    }
}