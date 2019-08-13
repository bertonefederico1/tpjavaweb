package entidades;

public class Mecanico {
	
	private int matricula;
	private String nombre_y_apellido;
	private String direccion;
	private String mail;
	private String telefono;
	private String usuario;
	private String contrasenia;
	
	
	
	public String getNombre_y_apellido() {
		return nombre_y_apellido;
	}
	public void setNombre_y_apellido(String nombre_y_apellido) {
		this.nombre_y_apellido = nombre_y_apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
