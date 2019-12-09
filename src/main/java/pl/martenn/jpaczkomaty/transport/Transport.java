package pl.martenn.jpaczkomaty.transport;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.martenn.jpaczkomaty.pack.Pack;

@RequiredArgsConstructor
@Getter
public class Transport {

    private final String id;
    private final Pack pack;
    private final String destination;
    @Setter
    private String place;

}
