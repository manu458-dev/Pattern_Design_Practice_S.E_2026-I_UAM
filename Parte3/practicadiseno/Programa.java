package mx.uam.is.practicadiseno;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.MapeadorDatosImpl;
import mx.uam.is.practicadiseno.negocio.ManejadorImpl;
import mx.uam.is.practicadiseno.vista.Ventana;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Crea el mapedor de datos
		MapeadorDatos mapeador = new MapeadorDatosImpl();

		// Crea el manejador

		// ManejadorImpl manejador = new ManejadorImpl(mapeador);
		ManejadorImpl manejador = new ManejadorImpl(mapeador);

		// Crea la primera ventana y la registra como observadora
		Ventana ventana = new Ventana(manejador);
		manejador.agregaObservador(ventana);
		ventana.setVisible(true);

		// Crea la segunda ventana sobre el MISMO manejador y también la registra
		Ventana ventana2 = new Ventana(manejador);
		manejador.agregaObservador(ventana2);
		ventana2.setVisible(true);

		// Crea la tercera ventana sobre el MISMO manejador y también la registra
		Ventana ventana3 = new Ventana(manejador);
		manejador.agregaObservador(ventana3);
		ventana3.setVisible(true);
	}

}
