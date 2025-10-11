package futebolTests.pessoa_fisicaTests;

import br.inatel.futebol.pessoa_fisica.Arbitro;
import br.inatel.futebol.pessoa_juridica.Federacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArbitroTest {

    private Arbitro arbitro;

    @BeforeEach
    void setup() {
        Arbitro.getListaArbitros().clear();
        Federacao federacaoMock = mock(Federacao.class);
    }

    @Test
    public void testConstrutor() {
        arbitro = new Arbitro("Daronco", 40, "12345678900");
        assertEquals("Daronco", arbitro.getNome());
        assertEquals(40, arbitro.getIdade());
        assertEquals("12345678900", arbitro.getCpf());
    }

    @Test
    void deveAdicionarArbitroNaListaAoSerCriado() {
        Arbitro a1 = new Arbitro("Carlos", 35, "123456");
        assertTrue(Arbitro.getListaArbitros().contains(a1));
    }

    @Test
    void deveContratarEAdicionarNaFederacao() {
        Federacao federacaoMock = mock(Federacao.class);
        arbitro = new Arbitro("Daronco", 40, "12345678900"); // sua classe que tem o método contratar

        arbitro.contratar(federacaoMock);

        verify(federacaoMock, times(1)).adicionarArbitro(arbitro);
        assertEquals(federacaoMock, arbitro.getFederacao());
    }

    @Test
    void deveMostrarInformacoesComFederacaoMockada() {
        Federacao federacaoMock = mock(Federacao.class);
        when(federacaoMock.getNome()).thenReturn("Federação Brasileira");

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        arbitro = new Arbitro("Daronco", 40, "12345678900"); // sua classe que tem o método contratar
        arbitro.contratar(federacaoMock);
        arbitro.mostrarInformacoes();

        String resultado = saida.toString();
        assertTrue(resultado.contains("Nome: Daronco"));
        assertTrue(resultado.contains("Idade: 40"));
        assertTrue(resultado.contains("Federação: Federação Brasileira"));

        verify(federacaoMock, times(1)).getNome();
    }

    @Test
    void deveMostrarMensagemSemFederacao() {
        Arbitro a1 = new Arbitro("Ana", 32, "444444");

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        a1.mostrarInformacoes();

        String resultado = saida.toString();
        assertTrue(resultado.contains("Nome: Ana"));
        assertTrue(resultado.contains("Idade: 32"));
        assertTrue(resultado.contains("Não foi adicionado a uma federação!"));
    }
}
