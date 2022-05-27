package model;

public class OrdineTester {
	/*
	    OrdineBean or = new OrdineBean();
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		ProdottoBean pr = new ProdottoBean();
		UtenteBean ut = new UtenteBean();
		
		short codice = 48;
		pr.setCodice(codice);
		pr.setDescrizione("prodotto fittizzio ");
		pr.setNome("vaffanculo a eva la stronza");
		pr.setPrezzo(25);
		pr.setQuantita(2);
		pr.setTipo(MODEL.ProdottoBean.categoria.Altro);
		
		ut.setNome("anna");
		ut.setCognome("lindaBrenga");
		ut.setEmail("analin@USER.it");
		ut.setPassword("ciao");
		ut.setTipo(categoria.user);
		
		or.setId(28);
		or.setDataOrdine(Date.valueOf("2021-3-25"));
		or.setDataConsegna(Date.valueOf("2021-2-28"));
		or.setOrarioOrdine(Time.valueOf("21:34:58"));
		or.setOrarioConsegna(Time.valueOf("21:54:25"));
		or.setProdotto(pr);
		or.setPrezzoProdotto(pr.getPrezzo());
	    or.setQuantitaProdotto(2);
	    or.setIvaProdotto(10);
	    or.setUtente(ut);
	    or.setIndirizzo("Vattelo A Piglia Nel Cuneo.it");
	    
		//or.setId(28);
		//orimp.inserisciOrdine(or);
		//orimp.modificaDataConsegna(or);
		//orimp.modificaOrarioConsegna(or);
		
		orimp.leggiSingoloOrdine(or);
		response.getWriter().append("\nid: " + or.getId());
		response.getWriter().append("\n  data ordine: " + or.getDataOrdine());
		response.getWriter().append("\n  orario ordine" + or.getOrarioOrdine());
		response.getWriter().append("\n  data consegna " + or.getDataConsegna());
		response.getWriter().append("\n  orario consegna " + or.getOrarioConsegna());
		response.getWriter().append("\n  prodotto: " + or.getProdotto().getCodice());
		response.getWriter().append("\n  prezzo prodotto: " + or.getPrezzoProdotto());
		response.getWriter().append("\n  quantità prodotto " + or.getQuantitaProdotto());
		response.getWriter().append("\n  iva prodotto " + or.getIvaProdotto());
		response.getWriter().append("\n  utente: " + or.getUtente().getEmail());
		response.getWriter().append("\n  inditizzo " + or.getIndirizzo());
		
		ut.setEmail("G.DEROSA80@USER.IT");
		List<OrdineBean> prod = orimp.leggiOrdine(ut);
		for (OrdineBean ps : prod ) {
			response.getWriter().append("\nid: " + ps.getId());
			response.getWriter().append("\n  data ordine: " + ps.getDataOrdine());
			response.getWriter().append("\n  orario ordine" + ps.getOrarioOrdine());
			response.getWriter().append("\n  data consegna " + ps.getDataConsegna());
			response.getWriter().append("\n  orario consegna " + ps.getOrarioConsegna());
			response.getWriter().append("\n  prodotto: " + ps.getProdotto().getCodice());
			response.getWriter().append("\n  prezzo prodotto: " + ps.getPrezzoProdotto());
			response.getWriter().append("\n  quantità prodotto " + ps.getQuantitaProdotto());
			response.getWriter().append("\n  iva prodotto " + ps.getIvaProdotto());
			response.getWriter().append("\n  utente: " + ps.getUtente().getEmail());
			response.getWriter().append("\n  inditizzo " + ps.getIndirizzo());
		}
	 * */
}
