package mx.uam.is.practicadiseno;

import mx.uam.is.practicadiseno.vista.Ventana;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import mx.uam.is.practicadiseno.negocio.ManejadorImpl;

public class Programa {

	private static final String CONFIG_FILE = "application.properties";
	private static final String KEY_CANTIDAD = "ventanas.cantidad";
	private static final int DEFAULT_CANTIDAD = 1;

	public static void main(String[] args) {
		int cantidad = cargarCantidadVentanas();

		var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		for (int i = 0; i < cantidad; i++) {
			Ventana ventana = ctx.getBean("ventana", Ventana.class);
                        ctx.getBean("manejador", ManejadorImpl.class).agregaObservador(ventana);
			ventana.setVisible(true);
		}
	}

	/**
	 * Carga el número de ventanas desde application.properties.
	 * Busca primero en el directorio actual (opcional override); si no existe, en el classpath (src/main/resources).
	 */
	private static int cargarCantidadVentanas() {
		Properties props = new Properties();

		Path external = Path.of(CONFIG_FILE);
		if (Files.isRegularFile(external)) {
			try (var in = Files.newInputStream(external)) {
				props.load(in);
			} catch (IOException e) {
				System.err.println("Error leyendo " + CONFIG_FILE + ": " + e.getMessage());
			}
		} else {
			try (InputStream in = Programa.class.getResourceAsStream("/" + CONFIG_FILE)) {
				if (in != null) {
					props.load(in);
				}
			} catch (IOException e) {
				System.err.println("Error leyendo " + CONFIG_FILE + " del classpath: " + e.getMessage());
			}
		}

		String valor = props.getProperty(KEY_CANTIDAD, String.valueOf(DEFAULT_CANTIDAD));
		try {
			int n = Integer.parseInt(valor.trim());
			return n > 0 ? n : DEFAULT_CANTIDAD;
		} catch (NumberFormatException e) {
			System.err.println("Valor inválido para " + KEY_CANTIDAD + " («" + valor + "»), usando " + DEFAULT_CANTIDAD);
			return DEFAULT_CANTIDAD;
		}
	}
}
