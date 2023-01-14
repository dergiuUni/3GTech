package TestJUnit;

import bean.OrdineBean;
import bean.ProdottoBean;
import bean.UtenteBean;
import implementazione.OrdineImplementazioneDAO;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;

class OrdiniUtenteTest {
	@Test
	@ParameterizedTest
	@MethodSource("testOrdiniUtenteProvider")
	public void testOrdiniUtente(UtenteBean utente, JSONArray oracolo) throws Exception{
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		//System.out.println(utente.getEmail() + " " + oracolo.toString());
		assertEquals(orimp.selectOrdiniUtente(utente).toString(), oracolo.toString());
	}
	
	public static Stream<Arguments> testOrdiniUtenteProvider() {
		Gson gson = new Gson();
		
		UtenteBean ut1 = new UtenteBean();
		ut1.setEmail("");
		JSONArray ordUt1 = new JSONArray();
		
		UtenteBean ut2 = new UtenteBean();
		ut2.setEmail(null);
		JSONArray ordUt2 = new JSONArray();
		
		UtenteBean ut3 = new UtenteBean();
		ut3.setEmail(""); // esiste senza oridini
		JSONArray ordUt3 = new JSONArray();
		
		UtenteBean ut4 = new UtenteBean();
		ut4.setEmail("i.schiavone@USER.IT"); //esiste con 1 ordini
		JSONArray ordUt4 = new JSONArray();
		OrdineBean ordine = new OrdineBean();
		ordine.setId(21);
		ordine.setDataOrdine(Date.valueOf("2021-05-14"));
		ordine.setDataConsegna(Date.valueOf("2021-03-27"));
		ordine.setOrarioOrdine(Time.valueOf("13:23:00"));
		ordine.setOrarioConsegna(Time.valueOf("18:45:00"));
		ordine.setPrezzoProdotto(18.23);
	    ordine.setQuantitaProdotto(1);
	    ordine.setIvaProdotto(10);
	    ordine.setIndirizzo("caduti in guerra");
	    ProdottoBean pr = new ProdottoBean();
	    pr.setCodice(Short.valueOf("2"));
	    pr.setNome("Fifa 22 Standard - Nintendo Switch");
	    pr.setDescrizione("Includerà nuove ITpetizioni, ITpresa la UEFA Europa Conference League, e una selezione dei più famosi stadi del mondo rifletterà gli eventi del mondo reale attraverso un serie di campagne FUT durante la stagione");
	    ordine.setProdotto(pr);
		ordUt4.put(gson.toJson(ordine));
		
		OrdineBean ordine1 = new OrdineBean();
		ordine1.setId(16);
		ordine1.setDataOrdine(Date.valueOf("2021-04-19"));
		ordine1.setDataConsegna(Date.valueOf("2021-03-27"));
		ordine1.setOrarioOrdine(Time.valueOf("13:23:00"));
		ordine1.setOrarioConsegna(Time.valueOf("18:45:00"));
		ordine1.setPrezzoProdotto(18.23);
	    ordine1.setQuantitaProdotto(1);
	    ordine1.setIvaProdotto(10);
	    ordine1.setIndirizzo("caduti in guerra");
		UtenteBean ut5 = new UtenteBean();
		ut5.setEmail("l.trupiano@USER.IT"); // esiste con 3 ordini
		JSONArray ordUt5 = new JSONArray();
		ordine1.setProdotto(pr);
		ordUt5.put(gson.toJson(ordine1));
		
		OrdineBean ordine2 = new OrdineBean();
		ordine2.setId(23);
		ordine2.setDataOrdine(Date.valueOf("2021-05-17"));
		ordine2.setDataConsegna(Date.valueOf("2021-03-27"));
		ordine2.setOrarioOrdine(Time.valueOf("13:23:00"));
		ordine2.setOrarioConsegna(Time.valueOf("18:45:00"));
		ordine2.setPrezzoProdotto(18.23);
	    ordine2.setQuantitaProdotto(1);
	    ordine2.setIvaProdotto(10);
	    ordine2.setIndirizzo("caduti in guerra");
		ordine2.setProdotto(pr);
		ordUt5.put(gson.toJson(ordine2));
		
		OrdineBean ordine3 = new OrdineBean();
		ordine3.setId(24);
		ordine3.setDataOrdine(Date.valueOf("2021-05-20"));
		ordine3.setDataConsegna(Date.valueOf("2021-03-27"));
		ordine3.setOrarioOrdine(Time.valueOf("13:23:00"));
		ordine3.setOrarioConsegna(Time.valueOf("18:45:00"));
		ordine3.setPrezzoProdotto(18.23);
	    ordine3.setQuantitaProdotto(1);
	    ordine3.setIvaProdotto(10);
	    ordine3.setIndirizzo("caduti in guerra");
		ordine3.setProdotto(pr);
		ordUt5.put(gson.toJson(ordine3));
		
		UtenteBean ut6 = new UtenteBean();
		ut6.setEmail("e.dovars@USER.IT"); //email errata -> corretta: e.dovara@USER.IT
		JSONArray ordUt6 = new JSONArray();
		
		
		return Stream.of(
					Arguments.of(ut1, ordUt1),
					Arguments.of(ut2,ordUt2),
					Arguments.of(ut3,ordUt3),
					Arguments.of(ut4,ordUt4),
					Arguments.of(ut5,ordUt5),
					Arguments.of(ut6,ordUt6)
				);
	}


}
