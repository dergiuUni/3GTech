package TestJUnit;

import bean.CartaBEAN;
import implementazione.CartaImplementazioneDAO;
import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class PagamentoTest {
	@Test
	@ParameterizedTest
	@MethodSource("pagamentoTestProvider")
	public void testPagamento(CartaBEAN carta, boolean oracolo ) throws Exception{
		CartaImplementazioneDAO crimp = new CartaImplementazioneDAO();
		assertEquals(crimp.pagamento(carta), oracolo);
	}
	
	public static Stream<Arguments> pagamentoTestProvider() {
		CartaBEAN c1 = new CartaBEAN();
		CartaBEAN c2 = new CartaBEAN();
		CartaBEAN c3 = new CartaBEAN();
		CartaBEAN c4 = new CartaBEAN();
		CartaBEAN c5 = new CartaBEAN();
		CartaBEAN c6 = new CartaBEAN();
		
		c1.setTitolare("Giuseppe De Rosa");
		c1.setScadenza(Date.valueOf("2023-10-25"));
		c1.setCvc(Short.valueOf("123"));
		c1.setNumero("3475682450");
		
		c2.setTitolare("Giuseppe de Rosa");
		c2.setScadenza(Date.valueOf("2023-10-25"));
		c2.setCvc(Short.valueOf("123"));
		c2.setNumero("3475682450");
		
		c3.setTitolare("");
		c3.setScadenza(Date.valueOf("2023-10-25"));
		c3.setCvc(Short.valueOf("123"));
		c3.setNumero("3475682450");
		
		c4.setTitolare("Giuseppe De Rosa");
		c4.setScadenza(Date.valueOf("2022-10-25"));
		c4.setCvc(Short.valueOf("123"));
		c4.setNumero("3475682450");
		
		c5.setTitolare("Giuseppe De Rosa");
		c5.setScadenza(Date.valueOf("2023-10-25"));
		c5.setCvc(Short.valueOf("133"));
		c5.setNumero("3475682450");
		
		c6.setTitolare("Giuseppe De Rosa");
		c6.setScadenza(Date.valueOf("2023-10-25"));
		c6.setCvc(Short.valueOf("123"));
		c6.setNumero("3475682430");
		
		return Stream.of(
					Arguments.of(c1,true),
					Arguments.of(c2,false),
					Arguments.of(c3,false),
					Arguments.of(c4,false),
					Arguments.of(c5,false),
					Arguments.of(c6,false)
				);
	}


}
