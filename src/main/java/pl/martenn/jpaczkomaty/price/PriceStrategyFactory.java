package pl.martenn.jpaczkomaty.price;

import org.springframework.stereotype.Service;
import pl.martenn.jpaczkomaty.pack.PackSize;

@Service
public class PriceStrategyFactory {


    public SizePriceStrategy getPriceStrategy(PackSize size) {

        if (size == PackSize.A)
        {
            return new ASizePrice();
        }
        else if (size == PackSize.B)
        {
            return new BSizePrice();
        }
        else
        {
            return new CSizePrice();
        }

    }
}
