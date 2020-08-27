package co.edu.ucentral.dao;

public class UsuarioDAO {
	
	private static UsuarioDAO usuarioDAO; 
	public UsuarioDAO() {
	
	}

	private static UsuarioDAO instancia() {
		if(usuarioDAO == null)
			usuarioDAO = new UsuarioDAO();
		return usuarioDAO;
	}
	
}
