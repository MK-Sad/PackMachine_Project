package pl.martenn.jpaczkomaty.price;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.martenn.jpaczkomaty.pack.PackSize;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceStrategyFactory strategyFactory;
    private SizePriceStrategy strategy;


    public int price() {

        return strategy.price();
    }

    public void setPackSize(PackSize size) {

        strategy = strategyFactory.getPriceStrategy(size);


       
    }

}
