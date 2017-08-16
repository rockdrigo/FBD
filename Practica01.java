public class Practica01 {

    public static void main(String[] args) {
        Consultas.CargarCSV();
		
		//Cuantas Propiedades son de menos de 200m² y valen entre $50,000 y $500,000
		Consultas.ConsultasInmoviliaria1();
		
		System.out.println("*********************************************************");
		System.out.println("*********************************************************");
		
		//Los nombres de los clientes que tienen más de un inmueble
		Consultas.ConsultasInmoviliaria2();
		
		System.out.println("*********************************************************");
		System.out.println("*********************************************************");
		
		//Las 10 propiedades más baratas
		Consultas.ConsultasInmoviliaria3();
		
		System.out.println("*********************************************************");
		System.out.println("*********************************************************");
				
		//Cuántas y cuáles son las 5 propiedades más caras
		Consultas.ConsultasInmoviliaria4();
		
		System.out.println("*********************************************************");
		System.out.println("*********************************************************");
		
		//Las 5 propiedades con mayor margen de ganancia
		Consultas.ConsultasInmoviliaria5();
		
		System.out.println("*********************************************************");
		System.out.println("*********************************************************");
		
	}
    
}
