package TestJUnit;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import carrello.GestioneCarrello;
import sessione.Session;

public class testisinizializzato {
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpSession session;
	
	/*
	@Test
	public void test() {
		request = Mockito.mock(HttpServletRequest.class);
		session = Mockito.mock(HttpSession.class);
		Session miaSession = new Session();
		
		when(session.getAttribute("carrello")).thenReturn("ciao");
		
		Mockito.when(session.setAttribute(anyString(), anyString())).thenAnswer(invocation -> myStringMethod(invocation.getArgument(0)));
		
		when(request.getSession()).thenReturn(session);
		
		System.out.println(request.getSession().getAttribute("carrello") + " classe test");
		System.out.println(miaSession.isInizializzatoCarrello(request) + " sessione mia");
		
		
		
		//boolean x = miaSession.isInizializzatoCarrello(any(HttpServletRequest.class));
		//assertEquals(x,false);
	}
	*/
	
	@Test
	@ParameterizedTest
	@MethodSource("testAggiungiCarrelloProvider")
	public void AggiungiAlCarrello(short codice, int quantita) {
		request = Mockito.mock(HttpServletRequest.class);
		session = Mockito.spy(HttpSession.class);
		Session miaSession = new Session();
		GestioneCarrello carrello = new GestioneCarrello();
		when(session.getAttribute("utente")).thenReturn("CLIENTE");
		when(session.getAttribute("carrello")).thenReturn("carr");
		session.setAttribute("x", "ciao");
		//Mockito.when(session).setAttribute();
		when(request.getSession()).thenReturn(session);
		
		/*
		Mockito.when( session.setAttribute(anyString(), anyString()))
	    .thenAnswer(invocation -> myStringMethod(invocation.getArgument(0)));
		*/
		
		request.getSession().setAttribute("carrello", "giacoomino");
		System.out.println(request.getSession().getAttribute("carrello") + " classe test");
		System.out.println(request.getSession().getAttribute("x") + " classe test");
		System.out.println(miaSession.isInizializzatoCarrello(request) + " sessione mia");
		//boolean x = miaSession.isInizializzatoCarrello(any(HttpServletRequest.class));
		//assertEquals(x,false);
	}
	
	public static Stream<Arguments> testAggiungiCarrelloProvider(){
		
		return Stream.of(
					//Arguments.of(Short.parseShort("3"), 1),
					//Arguments.of(Short.parseShort("4"), 1),
					//Arguments.of(Short.parseShort("5"), 1),
					//Arguments.of(Short.parseShort("1000"), 0),
					//Arguments.of(Short.parseShort("3"), 2),
					Arguments.of(Short.parseShort("3"), 3)
				);

	}
	
	

}
