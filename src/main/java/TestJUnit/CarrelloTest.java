package TestJUnit;

import static org.junit.Assert.assertEquals;
import java.util.stream.Stream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.google.gson.Gson;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import sessione.Session;
import bean.ProdottoBean;
import carrello.GestioneCarrello;

class CarrelloTest {
	@Test
	@ParameterizedTest
	@MethodSource("testAggiungiCarrelloProvider")
	public void testAggiugniCarrello(HttpServletRequest request, short codice, int quantita) throws Exception{
		GestioneCarrello carrello = new GestioneCarrello();
		Session sessione = new Session();
		
		carrello.incrementaQauntitaDiUno(request, codice);

		JSONArray arr = new JSONArray(sessione.leggiCarrello(request));
		for(int i = 0; i < arr.length(); i++) {
			JSONObject ob = new JSONObject(arr.getString(i));
			ProdottoBean pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
			if(pr.getCodice() == codice) {
				assertEquals(pr.getQuantitaCarrello(),quantita);
			}
		}
	}
	
	public static Stream<Arguments> testAggiungiCarrelloProvider(){
		
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		
		when(session.getAttribute("utente")).thenReturn("CLIENTE");
		when(session.getAttribute("carrello")).thenReturn(null);
		when(request.getSession()).thenReturn(session);

		System.out.println(session.getAttribute("utente") + " " + session.getAttribute("carrello") );
		return Stream.of(
					Arguments.of(request, Short.parseShort("3"), 1),
					Arguments.of(request, Short.parseShort("4"), 1),
					Arguments.of(request, Short.parseShort("5"), 1),
					Arguments.of(request, Short.parseShort("1000"), 0),
					Arguments.of(request, Short.parseShort("3"), 2),
					Arguments.of(request, Short.parseShort("3"), 3)
				);

	}
}
