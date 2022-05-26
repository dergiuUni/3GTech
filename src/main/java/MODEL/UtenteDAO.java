package MODEL;

public interface UtenteDAO {
	public boolean inserisciUtente     (UtenteBean utenteBean);
	public boolean rimuoviUtente       (UtenteBean utenteBean);
	public boolean modificaNome        (UtenteBean utenteBean);
	public boolean modificaCognome     (UtenteBean utenteBean);
	public boolean modificaPassword    (UtenteBean utenteBean);
	public boolean modificaTipo        (UtenteBean utenteBean);
	public boolean isAdmin        	   (UtenteBean utenteBean);
	public boolean isCliente           (UtenteBean utenteBean);
	public void    leggiSingoloUtente  (UtenteBean utenteBean);
}
