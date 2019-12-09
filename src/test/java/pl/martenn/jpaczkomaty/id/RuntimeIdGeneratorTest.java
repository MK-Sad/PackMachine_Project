package pl.martenn.jpaczkomaty.id;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RuntimeIdGeneratorTest {

    private IdGenerator idGenerator;

    @BeforeEach
    public void init() {
        idGenerator=new MyIDGenerator();

    }

    @Test
    public void shouldGetPackIds() {
        // then
        Assertions.assertThat(idGenerator.getPackId()).isEqualTo("0");
        Assertions.assertThat(idGenerator.getPackId()).isEqualTo("1");
    }

    @Test
    @Disabled
    public void shouldGetPackMachineIds() {
        // then
        Assertions.assertThat(idGenerator.getPackMachineId()).isEqualTo("PCK0");
        Assertions.assertThat(idGenerator.getPackMachineId()).isEqualTo("PCK1");
    }

    @Test
    @Disabled
    public void shouldGetTransportIds() {
        // then
        Assertions.assertThat(idGenerator.getTransportId()).isNotBlank();
    }
}