package pl.martenn.jpaczkomaty.price;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import pl.martenn.jpaczkomaty.pack.PackSize;

class PriceStrategyTest {
    private PriceStrategyFactory factory = new PriceStrategyFactory();

    @Test
    @Disabled
    public void shouldTestAPrice() {
        // given
        SizePriceStrategy strategy = new ASizePrice();

        // then
        Assertions.assertThat(strategy.price()).isEqualTo(5);
    }

    @Test
    @Disabled
    public void shouldTestBPrice() {
        // given
        SizePriceStrategy strategy = new BSizePrice();

        // then
        Assertions.assertThat(strategy.price()).isEqualTo(10);
    }

    @Test
    @Disabled
    public void shouldTestCPrice() {
        // given
        SizePriceStrategy strategy = new CSizePrice();

        // then
        Assertions.assertThat(strategy.price()).isEqualTo(15);
    }

    @Test
    @Disabled
    public void shouldGetAPrice() {
        // when
        SizePriceStrategy strategy = factory.getPriceStrategy(PackSize.A);

        // then
        Assertions.assertThat(strategy).isInstanceOf(ASizePrice.class);
    }

    @Test
    @Disabled
    public void shouldGetBPrice() {
        // when
        SizePriceStrategy strategy = factory.getPriceStrategy(PackSize.B);

        // then
        Assertions.assertThat(strategy).isInstanceOf(BSizePrice.class);
    }

    @Test
    @Disabled
    public void shouldGetCPrice() {
        // when
        SizePriceStrategy strategy = factory.getPriceStrategy(PackSize.C);

        // then
        Assertions.assertThat(strategy).isInstanceOf(CSizePrice.class);
    }

    @Test
    public void shouldCalculatePriceWithStatefulService() {
        // given
        PriceService service = new PriceService(factory);

        // when
        service.setPackSize(PackSize.C);

        // then
        Assertions.assertThat(service.price()).isEqualTo(15);

    }
}