import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Consultas {
	
	public static Cliente clientes[] = new Cliente[100];
	
	
	public static void CargarCSV(){
		int contador = 0;
		try {
        CsvReader mi_csv = new CsvReader("./P1.csv"); //Cambien a la ruta de su archivo
        mi_csv.readHeaders(); // Leemos las Cabeceras, las cuales nos dan informacion de cada campo
		
        while (mi_csv.readRecord()){
            String nombre = mi_csv.get(0);
            String telefono = mi_csv.get(1);
            String direccion = mi_csv.get(2);
            String correo = mi_csv.get(3);
            String metrosCuadradosProiedad = mi_csv.get(4);
            String valorPropiedad = mi_csv.get(5);
            String valorVenta = mi_csv.get(6);
           // System.out.println("Registro leido");
			
			clientes[contador] = new Cliente(nombre, telefono, direccion, correo, metrosCuadradosProiedad, valorPropiedad, valorVenta);
            contador++;
//            System.out.println("Registro agregado");
//            System.out.println("Nombre: "+nombre);
//            System.out.println("Telefono: "+telefono); 
//            System.out.println("Direccion: "+direccion);             
//            System.out.println("Correo: "+correo);     
//            System.out.println("Metros Cuadrados: "+metrosCuadradosProiedad+" m^²"); 
//            System.out.println("Valor de la Propiedad: $"+valorPropiedad); 
//            System.out.println("Valor para Venta: $"+valorVenta);
//            System.out.println("/***********************************/\n");
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Cuantas Propiedades son de menos de 200m² y valen entre $50,000 y $500,000
	 */
	public static void ConsultasInmoviliaria1(){
		int aux = 0;
		for(int i = 0; i < clientes.length;i++){
			
			int m2 = Integer.parseInt(clientes[i].getMetrosCuadrados());
			
			double val = Double.parseDouble(clientes[i].getValorPropiedad());
			
			if(m2 <= 200 && val >= 50000 && val <= 500000 ){
				System.out.println(clientes[i]);
				aux++;
			}
			
		}
		System.out.println("Las Propiedades menores a 200m2 y valen entre $50,000 y $500,000 son: "+aux);
	}
	/**
	 * Los nombres de los clientes que tienen más de un inmueble
	 */
	public static void ConsultasInmoviliaria2(){
		//Donde en <String, Integer> equivale a <Clave, Valor>
		//se puede usar cualquier tipo de map, hashmap o treemap
		//pero el treemap, al parecer es mas rapido
		Map<String, Integer> apariciones = new TreeMap<>();
		
		for(int i = 0; i < clientes.length;i++){
			String nombre1 = clientes[i].getNombre();
			//System.out.println(nombre1);
			
			if(!apariciones.containsKey(nombre1)){
				apariciones.put(nombre1, 1);
			}else{
				int valor = apariciones.get(nombre1);
				apariciones.put(nombre1, valor+1);
			}
		}
		
//		System.out.println(apariciones.values());
//		System.out.println(apariciones.size());
//		System.out.println(apariciones.keySet());
		
		//http://www.java2novice.com/java-interview-programs/sort-a-map-by-value/
		// aun no se como lo hace pero funciona, investigar el pq
		Set<Entry<String, Integer>> conjunto = apariciones.entrySet();
        List<Entry<String, Integer>> lista = new ArrayList<Entry<String, Integer>>(conjunto);
        Collections.sort( lista, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
		System.out.println("Personas ordenadas por la cantidad de propiedades: \n");
        for(Map.Entry<String, Integer> entry:lista){
            System.out.println("NOMBRE: "+entry.getKey()+"\t PROPIEDADES: "+entry.getValue());
        }
		//hasta aqui
		
	}
	/**
	 * Las 10 propiedades más baratas
	 */
	public static void ConsultasInmoviliaria3(){
		System.out.println("10 PROPIEDADES MAS BARATAS: \n");
		//Donde en <String, Integer> equivale a <Clave, Valor>
		//se puede usar cualquier tipo de map, hashmap o treemap
		//pero el treemap, al parecer es mas rapido
		Map<String, Double> propiedades = new TreeMap<>();
				
//		System.out.println(propiedades);

		for(int i = 0; i < clientes.length;i++){
			String direccion = clientes[i].getDireccion();
			//System.out.println(direccion);
			Double valorPropiedad = Double.parseDouble(clientes[i].getValorPropiedad());
			//System.out.println(valorPropiedad);
			
			propiedades.put(direccion, valorPropiedad);
		}
		
//		System.out.println(propiedades);
//		System.out.println(propiedades.values());
//		System.out.println(propiedades.size());
//		System.out.println(propiedades.keySet());
		
		//http://www.java2novice.com/java-interview-programs/sort-a-map-by-value/
		// aun no se como lo hace pero funciona, investigar el pq
		Set<Entry<String, Double>> conjunto = propiedades.entrySet();
        List<Entry<String, Double>> lista = new ArrayList<Entry<String, Double>>(conjunto);
        Collections.sort( lista, new Comparator<Map.Entry<String, Double>>()
        {
            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
            {
				//intercambiar valor aqui para cambiar el orden de comparacion
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );
		int x =0;
        for(Map.Entry<String, Double> entry:lista){
            System.out.println("Propiedad Ubicada en: " + entry.getKey()+ "    Valor: $"+entry.getValue());
			x++;
			if(x==10) break;
        }
		//hasta aqui
	}
	/**
	 * Cuántas y cuáles son las 5 propiedades más caras
	 */
	public static void ConsultasInmoviliaria4(){
		System.out.println("5 PROPIEDADES MAS CARAS: \n");
		//Donde en <String, Integer> equivale a <Clave, Valor>
		//se puede usar cualquier tipo de map, hashmap o treemap
		//pero el treemap, al parecer es mas rapido
		Map<String, Double> propiedades = new TreeMap<>();
				
//		System.out.println(propiedades);

		for(int i = 0; i < clientes.length;i++){
			String direccion = clientes[i].getDireccion();
			//System.out.println(direccion);
			Double valorPropiedad = Double.parseDouble(clientes[i].getValorPropiedad());
			//System.out.println(valorPropiedad);
			
			propiedades.put(direccion, valorPropiedad);
		}
		
//		System.out.println(propiedades);
//		System.out.println(propiedades.values());
//		System.out.println(propiedades.size());
//		System.out.println(propiedades.keySet());
		
		//http://www.java2novice.com/java-interview-programs/sort-a-map-by-value/
		// aun no se como lo hace pero funciona, investigar el pq
		Set<Entry<String, Double>> conjunto = propiedades.entrySet();
        List<Entry<String, Double>> lista = new ArrayList<Entry<String, Double>>(conjunto);
        Collections.sort( lista, new Comparator<Map.Entry<String, Double>>()
        {
            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
            {
				//intercambiar valor aqui para cambiar el orden de comparacion
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
		int x =0;
        for(Map.Entry<String, Double> entry:lista){
            System.out.println("Propiedad Ubicada en: " + entry.getKey()+ "    Valor: $"+entry.getValue());
			x++;
			if(x==5) break;
        }
		//hasta aqui
	}
	/**
	 * Las 5 propiedades con mayor margen de ganancia
	 */
	public static void ConsultasInmoviliaria5(){
		System.out.println("5 PROPIEDADES CON MAYOR MARGEN DE GANANCIA: \n");
		Arrays.sort(clientes);
		
		for(int i = 0; i < 5;i++){
				System.out.println(clientes[i].toString());
		}
	}
	

	
}
