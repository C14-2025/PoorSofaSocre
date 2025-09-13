package pessoa_fisicaTeste;

import org.example.futebol.pessoa_fisica.Tecnico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TecnicoTest {
    private Tecnico tecnico;

    @Test
    public void testConstrutor() {
        tecnico = new Tecnico("Guardiola",54,"11111111111","Espanha");
        assertEquals("Guardiola", tecnico.getNome());
        assertEquals(54, tecnico.getIdade());
        assertEquals("11111111111", tecnico.getCpf());
        assertEquals("Espanha", tecnico.getNacionalidade());
    }
}
