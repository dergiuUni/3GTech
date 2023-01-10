package implementazione;

import bean.ProdottoBean;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProdottoTest {
	ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
	
	@ParameterizedTest
	@MethodSource("testInserisciProdottoProvider")
	public void testInserisciProdotto(ProdottoBean prodotto, boolean expected) throws Exception{
		boolean actual=dao.inserisciProdotto(prodotto);
		assertEquals(actual,expected);
	}
	
	public static Stream<Arguments> testInserisciProdottoProvider() {
		String centoCaratteri="testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttest";
		String trecentoCaratteri="testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest";
		
		long now=System.currentTimeMillis();
		Date date= new Date(now);
		ProdottoBean p1=new ProdottoBean("test","descrizione",10.0,ProdottoBean.categoria.Computer,1,date);
		ProdottoBean p2=new ProdottoBean(centoCaratteri,"descrizione",10.0,ProdottoBean.categoria.Computer,1,date);
		ProdottoBean p3=new ProdottoBean("test",trecentoCaratteri,10.0,ProdottoBean.categoria.Computer,1,date);
		ProdottoBean p4=new ProdottoBean("test", "descrizione", 0.0, ProdottoBean.categoria.Computer,1,date);
		
		return Stream.of(
					Arguments.of(p1,true),
					Arguments.of(p2,false),
					Arguments.of(p3,false),
					Arguments.of(p4,false)
				);
	}
	
	@ParameterizedTest
	@MethodSource("testRimuoviProdottoProvider")
	public void testRimuoviProdotto(ProdottoBean prodotto, boolean expected) throws Exception{
		
		boolean actual=dao.rimuoviProdotto(prodotto);
		assertEquals(actual,expected);
	}
	
	public static Stream<Arguments> testRimuoviProdottoProvider() {
		ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
		short id1= dao.getProdottoByName("test");
		short id2= 10000;
		
		ProdottoBean p1=new ProdottoBean(), p2=new ProdottoBean();
		p1.setCodice(id1); p2.setCodice(id2);
		return Stream.of(
					Arguments.of(p1,true),
					Arguments.of(p2,false)
				);
	}
	
	@ParameterizedTest
	@MethodSource("testCercaProdottoProvider")
	public void testCercaProdotto(String string, ArrayList<ProdottoBean> expected) throws Exception{
		
		ArrayList<String> actual=dao.cerca2(string);
		assertEquals(actual,expected);
	}
	
	public static Stream<Arguments> testCercaProdottoProvider() {
		ArrayList<String> list=new ArrayList<String>();
		list.add("ASUS TUF Gaming NVIDIA GeForce 3060");
		list.add("ASUS GF GT730");
		list.add("ASUS ROG Strix X570-F");
		list.add("ASUS PRIME B550-PLUS");
		return Stream.of(
					Arguments.of("ASUS",list),
					Arguments.of("NESSUN PRODOTTO",null),
					Arguments.of("",null)
				);
	}
	
	@ParameterizedTest
	@MethodSource("testModificaDescrizioneProvider")
	public void testModificaDescrizione(ProdottoBean prodotto, boolean expected) throws Exception{
		boolean actual=dao.modificaDescrizione(prodotto);
		assertEquals(actual,expected);
	}
	
	public static Stream<Arguments> testModificaDescrizioneProvider() {
		short s1=10000, s2=1;
		String trecentoCaratteri="testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest";
		
		ProdottoBean prodotto1=new ProdottoBean();
		prodotto1.setCodice(s2);
		prodotto1.setNome("TEST MODIFICA DESCRIZIONE");
		prodotto1.setDescrizione("TEST MODIFICA DESCRIZIONE");
		
		ProdottoBean prodotto2=new ProdottoBean();
		prodotto2.setCodice(s1);
		prodotto2.setDescrizione("TEST MODIFICA DESCRIZIONE : CODICE NON VALIDO");
		
		ProdottoBean prodotto3=new ProdottoBean();
		prodotto3.setCodice(s2);
		prodotto3.setDescrizione(trecentoCaratteri);
		
		return Stream.of(
					Arguments.of(prodotto1, true),
					Arguments.of(prodotto2, false),
					Arguments.of(prodotto3, false)
				);
	}
	
	@ParameterizedTest
	@MethodSource("testModificaPrezzoProvider")
	public void testModificaPrezzo(ProdottoBean prodotto, boolean expected) throws Exception{
		boolean actual=dao.modificaPrezzo(prodotto);
		assertEquals(actual,expected);
	}
	
	public static Stream<Arguments> testModificaPrezzoProvider() {
		short s1=10000, s2=1;
		
		ProdottoBean prodotto1=new ProdottoBean();
		prodotto1.setCodice(s2);
		prodotto1.setPrezzo(20);
		
		ProdottoBean prodotto2=new ProdottoBean();
		prodotto2.setCodice(s1);
		prodotto2.setPrezzo(20);
		
		ProdottoBean prodotto3=new ProdottoBean();
		prodotto2.setCodice(s1);
		prodotto2.setPrezzo(0.0);
		
		return Stream.of(
					Arguments.of(prodotto1, true),
					Arguments.of(prodotto2, false),
					Arguments.of(prodotto3, false)
				);
	}

}
