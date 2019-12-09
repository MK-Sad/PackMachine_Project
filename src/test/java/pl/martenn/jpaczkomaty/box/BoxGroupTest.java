package pl.martenn.jpaczkomaty.box;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.pack.PackSize;

import java.util.Arrays;
import java.util.List;

public class BoxGroupTest {

    private BoxGroup uut = new BoxGroup();
    private static final Box EMPTY_A = new Box(PackSize.A);
    private static final Box EMPTY_B = new Box(PackSize.B);
    private static final Box NOT_EMPTY_A = new Box(PackSize.A);
    private static final Pack PACK_A = new Pack("1", PackSize.A);

    @BeforeEach
    public void init() {
        NOT_EMPTY_A.put(PACK_A);
    }

    @Test
    public void shouldGetSmallestEmptyBoxB() {
        // given
        uut.setBoxes(boxesWithEmptyAAndB());

        // when
        Box result = uut.getSmallestEmptyBox(PackSize.B);

        // then
        Assertions.assertThat(result).isSameAs(EMPTY_B);
    }

    @Test
    public void shouldGetSmallestEmptyBoxA() {
        // given
        uut.setBoxes(boxesWithEmptyAAndB());

        // when
        Box result = uut.getSmallestEmptyBox(PackSize.A);

        // then
        Assertions.assertThat(result).isSameAs(EMPTY_A);
    }

    @Test
    public void shouldNotGetBoxWhenSizeUnavailable() {
        // given
        uut.setBoxes(boxesWithEmptyAAndB());

        // when
        Box result = uut.getSmallestEmptyBox(PackSize.C);

        // then
        Assertions.assertThat(result).isNull();
    }

    @Test
    public void shouldGetBBecauseAIsOccupied() {
        // given
        uut.setBoxes(boxesWithEmptyBAndNotEmptyA());

        // when
        Box result = uut.getSmallestEmptyBox(PackSize.A);

        // then
        Assertions.assertThat(result).isSameAs(EMPTY_B);
    }

    private List<Box> boxesWithEmptyAAndB() {
        return Arrays.asList(EMPTY_A, EMPTY_B);
    }

    private List<Box> boxesWithEmptyBAndNotEmptyA() {
        return Arrays.asList(NOT_EMPTY_A, EMPTY_B);
    }
}
