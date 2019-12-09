package pl.martenn.jpaczkomaty.operations;

import lombok.RequiredArgsConstructor;
import pl.martenn.jpaczkomaty.machine.PackMachine;
import pl.martenn.jpaczkomaty.pack.Pack;
import pl.martenn.jpaczkomaty.transport.Transport;

@RequiredArgsConstructor
public class SendPackOperation implements PackOperation {

    private final Transport transport;
    private final PackMachine packMachine;

    @Override
    public void execute() {
        transport.setPlace(packMachine.getId());
        packMachine.put(transport.getPack());
    }
}
