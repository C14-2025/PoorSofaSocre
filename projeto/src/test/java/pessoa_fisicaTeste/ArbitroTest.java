package pessoa_fisicaTeste;

import org.example.futebol.pessoa_fisica.Arbitro;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArbitroTest {

    private Arbitro arbitro;

    @Test
    public void testConstrutor() {
        arbitro = new Arbitro("Pelé", 40, "12345678900");
        assertEquals("Pelé", arbitro.getNome());
        assertEquals(40, arbitro.getIdade());
        assertEquals("12345678900", arbitro.getCpf());
    }
}
