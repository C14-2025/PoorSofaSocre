package futebolTests.pessoa_fisicaTests;

import br.inatel.futebol.pessoa_fisica.Arbitro;
import br.inatel.futebol.pessoa_juridica.Federacao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArbitroTest {

    private Arbitro arbitro;

    @Test
    public void testConstrutor() {
        arbitro = new Arbitro("Daronco", 40, "12345678900");
        assertEquals("Daronco", arbitro.getNome());
        assertEquals(40, arbitro.getIdade());
        assertEquals("12345678900", arbitro.getCpf());
    }

    @Test
    void deveContratarEAdicionarNaFederacao() {
        // Arrange
        Federacao federacaoMock = Mockito.mock(Federacao.class);
        arbitro = new Arbitro("Daronco", 40, "12345678900"); // sua classe que tem o método contratar

        // Act
        arbitro.contratar(federacaoMock);

        // Assert
        // Verifica se o método adicionarArbitro foi chamado
        verify(federacaoMock, times(1)).adicionarArbitro(arbitro);

        // Verifica se o campo 'federacao' do árbitro foi atualizado
        assertEquals(federacaoMock, arbitro.getFederacao());
    }
}
