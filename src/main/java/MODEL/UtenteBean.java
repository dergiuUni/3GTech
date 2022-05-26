package MODEL;

public class UtenteBean {
	private String nome;
	private String cognome;
	private String email;
	private String password;
    public static enum categoria{
		user,
		admin
	}
    private categoria tipo;
    
    public UtenteBean() {
    	
    }
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public categoria getTipo() {
		return tipo;
	}

	public void setTipo(categoria tipo) {
		this.tipo = tipo;
	}
}
