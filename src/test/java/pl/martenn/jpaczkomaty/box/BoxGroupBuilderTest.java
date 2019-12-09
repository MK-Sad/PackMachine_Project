package pl.martenn.jpaczkomaty.box;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.pack.PackSize;

class BoxGroupBuilderTest {

    @Test
    public void shouldBuildGroup() {
        // when
        BoxGroup boxGroup = BoxGroupBuilder.builder().withA(2).withB(4).withC(2).build();

        // then
        Assertions.assertThat(boxGroup.getBoxes().size()).isEqualTo(8);
        Assertions.assertThat(boxGroup.getBoxes().get(0).getSize()).isEqualTo(PackSize.A);
        Assertions.assertThat(boxGroup.getBoxes().get(2).getSize()).isEqualTo(PackSize.B);
        Assertions.assertThat(boxGroup.getBoxes().get(6).getSize()).isEqualTo(PackSize.C);
    }

}