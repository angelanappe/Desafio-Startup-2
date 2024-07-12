package cl.praxis.model;

import java.util.List;

public class Usuario {
	
	private int id;
    private String correo;
    private String nick;
    private String nombre;
    private int peso;
    private List<Direccion> direcciones;
    private String rol;
	
    public Usuario() {
		super();
	}

	public Usuario(int id, String correo, String nick, String nombre, int peso, List<Direccion> direcciones,
			String rol) {
		super();
		this.id = id;
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.peso = peso;
		this.direcciones = direcciones;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    

}
