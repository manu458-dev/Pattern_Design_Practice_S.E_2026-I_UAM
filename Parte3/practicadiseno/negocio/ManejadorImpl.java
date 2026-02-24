package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.List;
import mx.uam.is.practicadiseno.datos.MapeadorDatos;

public class ManejadorImpl implements Manejador {

	// La estructura que contiene los datos
	//private List <String> datos = new ArrayList <String> ();

        MapeadorDatos mapeador;
        private List <Observador> ventanasObservadoras = new ArrayList<>(); 
	/**
	 * Constructor que inicializa con algunos datos
	 *
	 */
	public ManejadorImpl(MapeadorDatos mapeador) {
		//datos.add("Entrada 1");
		//datos.add("Entrada 2");
		//datos.add("Entrada 3");
                this.mapeador = mapeador;
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
		// Convierte la lista a un arreglo de cadenas y lo regresa
		return this.mapeador.dameDatos();
	}

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agrega(String dato) {
		if(!dato.equals("") && ! this.mapeador.contiene(dato)) {
			this.mapeador.agrega(dato);
                        this.notifica();
			return true;
		}
		return false;
	}

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	public boolean borra(String dato) {
                this.notifica();
		return this.mapeador.borra(dato);
	}

	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza() {
		System.exit(0);
	}
        
        public boolean agregaObservador(Observador o) {
            return this.ventanasObservadoras.add(o);
        }
        
        public boolean quitarObservador(Observador o){
            return this.ventanasObservadoras.remove(o);
        }
        
        public void notifica(){
            for(int i = 0; i<this.ventanasObservadoras.size(); i++){
                System.out.println("Se ha notificado a un observadors");
                this.ventanasObservadoras.get(i).actualiza();
            }
        }

}
