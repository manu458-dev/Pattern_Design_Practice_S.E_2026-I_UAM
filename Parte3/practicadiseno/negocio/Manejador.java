package mx.uam.is.practicadiseno.negocio;


public interface Manejador {

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos();

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agrega(String dato);

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	public boolean borra(String dato);

	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza();

        // MÉTODOS CORRESPONDIENTES A LA ESCUCHA DE OBSERVADOR
        public boolean agregaObservador(Observador o);
        
        public boolean quitarObservador(Observador o);
        
        public void notifica();
}
