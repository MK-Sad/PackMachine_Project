package pl.martenn.jpaczkomaty.box;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.pack.PackSize;

class BoxTest {

    private Box box;

    @BeforeEach
    public void init() {
        box = new Box(PackSize.A);
    }

    @Test
    public void shouldBeEmptyByDefault() {
        // then
        Assertions.assertThat(box.isEmpty()).isTrue();
    }

    @Test
    public void shouldBeOccupiedWhenWithPack() {
        // given
        box.put(new Pack("1", PackSize.A));

        // then
        Assertions.assertThat(box.isEmpty()).isFalse();
    }

}