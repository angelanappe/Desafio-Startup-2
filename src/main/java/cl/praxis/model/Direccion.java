package cl.praxis.model;

public class Direccion {
	
	private String nombre;
    private String numeracion;
	
    public Direccion() {
		super();
	}

	public Direccion(String nombre, String numeracion) {
		super();
		this.nombre = nombre;
		this.numeracion = numeracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

}
