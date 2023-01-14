package TestJUnit;

import bean.OrdineBean;
import bean.ProdottoBean;
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

class OrdiniDataTest {
	@Test
	@ParameterizedTest
	@MethodSource("testOrdiniDataProvider")
	public void testOrdiniData(String a, String b, JSONArray oracolo) throws Exception{
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		//System.out.println(utente.getEmail() + " " + oracolo.toString());
		assertEquals(orimp.selectOrdiniData(Date.valueOf(a), Date.valueOf(b)).toString(), oracolo.toString());
	}
	
	public static Stream<Arguments> testOrdiniDataProvider() {
		JSONArray ordUtNull = new JSONArray();
		JSONArray ordUt4 = new JSONArray();
		JSONArray ordUt5 = new JSONArray();
		Gson gson = new Gson();
		
		OrdineBean ordine = new OrdineBean();
		ordine.setId(1);
		ordine.setDataOrdine(Date.valueOf("2021-02-24"));
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
			
		ordine.setDataOrdine(Date.valueOf("2021-03-25"));
		ordine.setId(2);
		ordUt5.put(gson.toJson(ordine));
	
		ordine.setDataOrdine(Date.valueOf("2021-03-26"));
		ordine.setId(3);
		ordUt5.put(gson.toJson(ordine));
		
		ordine.setDataOrdine(Date.valueOf("2021-03-27"));
		ordine.setId(4);
		ordUt5.put(gson.toJson(ordine));
	
		ordine.setDataOrdine(Date.valueOf("2021-03-28"));
		ordine.setId(5);
		ordUt5.put(gson.toJson(ordine));
	
		ordine.setDataOrdine(Date.valueOf("2021-03-29"));
		ordine.setId(6);
		ordUt5.put(gson.toJson(ordine));
	
		ordine.setDataOrdine(Date.valueOf("2021-03-30"));
		ordine.setId(7);
		ordUt5.put(gson.toJson(ordine));
	
		ordine.setDataOrdine(Date.valueOf("2021-04-01"));
		ordine.setId(8);
		ordUt5.put(gson.toJson(ordine));
		
		ordine.setDataOrdine(Date.valueOf("2021-03-25"));
		ordine.setId(27);
		ordUt5.put(gson.toJson(ordine));
	
		return Stream.of(
					Arguments.of("2021-03-20", "2021-02-23", ordUtNull), // non ci so ordini
					Arguments.of("2021-02-23", "2021-02-25", ordUt4),// 1 ordine
					Arguments.of("2021-03-24", "2021-04-01", ordUt5) // 7 ordini
				);
		//data nulla o non valida tipo 2021-02-32 ci sta il parse di sql che fallisce
	}


}
