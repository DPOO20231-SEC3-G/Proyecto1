package uniandes.dpoo.p1.model;

public class Usuario {
	
	private String user;
	
	private String contraseña;
	
	private char rol;
	/// Hay 3 tipos de rol 'a' Administrador, 'r' Recepcionista y 'e' Empleado. 

	public Usuario(String nUser, String nContraseña, char nRol) {
		
		user = nUser;
		contraseña = nContraseña;
		rol = nRol;
	
	}

	public String getUser() {
		return user;
	}

	public String getContraseña() {
		return contraseña;
	}

	public char getRol() {
		return rol;
	}
	
}
