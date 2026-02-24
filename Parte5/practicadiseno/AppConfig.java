package mx.uam.is.practicadiseno;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.MapeadorDatosImpl;
import mx.uam.is.practicadiseno.negocio.Manejador;
import mx.uam.is.practicadiseno.negocio.ManejadorImpl;
import mx.uam.is.practicadiseno.negocio.ManejadorProxy;
import mx.uam.is.practicadiseno.vista.Ventana;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * Configuración de Spring: define los beans y la inyección de dependencias.
 */
@Configuration
public class AppConfig {

        @Bean
        public MapeadorDatos mapeadorDatos() {
            return new MapeadorDatosImpl();
        }

    
	@Bean
	public Manejador manejador(MapeadorDatos mapeador) {
		return new ManejadorImpl(mapeador);
	}

        @Bean
        public ManejadorProxy manejadorProxy(Manejador manejador) {
            return new ManejadorProxy(manejador);
        }
        
	@Bean
	@Scope("prototype")
	public Ventana ventana(ManejadorProxy manejador) {
		return new Ventana(manejador);
	}
}
