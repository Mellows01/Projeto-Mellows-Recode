package modelo;

public class Login {
	
	private int idLogin;
	private String tipoLogin;
	
	
	
	public Login() {
		super();
	}



	public Login(int idLogin, String tipoLogin) {
		super();
		this.idLogin = idLogin;
		this.tipoLogin = tipoLogin;
	}



	public int getIdLogin() {
		return idLogin;
	}



	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}



	public String getTipoLogin() {
		return tipoLogin;
	}



	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
	
	
	
	
	
	

}
