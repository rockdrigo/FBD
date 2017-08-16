public class Cliente implements Comparable<Cliente>{

	private String nombre, telefono, direccion, correo, metrosCuadradosProiedad,
			valorPropiedad, valorVenta;
	private double ganancia;

	public Cliente(String nombre, String telefono, String direccion, String correo,
			String metrosCuadradosProiedad, String valorPropiedad, String valorVenta) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.metrosCuadradosProiedad = metrosCuadradosProiedad;
		this.valorPropiedad = valorPropiedad;
		this.valorVenta = valorVenta;

		double ganancia = Double.parseDouble(valorVenta) - Double.parseDouble(valorPropiedad);

		this.ganancia = ganancia;
	}

	public String getNombre() {
		return nombre;
	}

	public double getGanancia() {
		return ganancia;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getMetrosCuadrados() {
		return metrosCuadradosProiedad;
	}

	public String getValorPropiedad() {
		return valorPropiedad;
	}

	public String getValorVenta() {
		return valorVenta;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n"
				+ "Telefono: " + this.telefono + "\n"
				+ "Direccion: " + this.direccion + "\n"
				+ "Correo: " + this.correo + "\n"
				+ "Metros Cuadrados: " + this.metrosCuadradosProiedad + " m^²" + "\n"
				+ "Valor de la Propiedad: $" + this.valorPropiedad + "\n"
				+ "Valor para Venta: $" + this.valorVenta + "\n"
				+ "GANANCIA: " + this.ganancia + "\n"
				+ "/***********************************/\n";
	}

	@Override
	public int compareTo(Cliente o) {
		if (ganancia > o.ganancia) {
			return -1;
		}
		if (ganancia < o.ganancia) {
			return 1;
		}
		return 0;
	}
}
