package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.List;
import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.Observador;

public class ManejadorImpl implements Manejador {

        private MapeadorDatos mapeador;
        private List <Observador> ventanasObservadoras = new ArrayList<>(); 
        
	public ManejadorImpl(MapeadorDatos mapeador) {
		this.mapeador = mapeador;
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
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

        @Override
        public boolean agregaObservador(Observador o) {
            return this.ventanasObservadoras.add(o);        
        }

        @Override
        public boolean quitarObservador(Observador o) {
            return this.ventanasObservadoras.remove(o);
        }

        @Override
        public void notifica() {
            for(int i = 0; i<this.ventanasObservadoras.size(); i++){
                System.out.println("Se ha notificado a un observadors");
                this.ventanasObservadoras.get(i).actualiza();
            }
        }
}
