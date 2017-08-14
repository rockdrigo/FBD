public class Cliente {
	
    private String nombre;
    private int telefono;
    private String direccion;
    private String correo;
    private String metrosCuadradosProiedad;
    private long valorPropiedad;
    private long valorVenta;
	
	public Cliente(String nombre, int telefono, String direccion, String correo, String metrosCuadradosProiedad, long valorPropiedad, long valorVenta) {
        this.nombre=nombre;
        this.telefono=telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.metrosCuadradosProiedad = metrosCuadradosProiedad;
		this.valorPropiedad = valorPropiedad;
		this.valorVenta = valorPropiedad;
    }
    	
}