/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.uam.is.practicadiseno.negocio;

/**
 *
 * @author Manuel
 */
public class ManejadorProxy implements Manejador {

    // "HACER REFERENCIA HACIA UNA CLASE" se puede entender como inyección de
    // dependencias
    // Dicho de otra forma: crea un atributo de una interfaz, NO instancies una
    // clase
    private Manejador manejador;

    public ManejadorProxy(Manejador manejador) {
        System.out.println("Se ha creado el proxy del Manejador");
        this.manejador = manejador;
    }

    @Override
    public String[] dameDatos() {
        System.out.println("Se invoco el método 'dameDatos()' del manejador");
        return this.manejador.dameDatos();
    }

    @Override
    public boolean agrega(String dato) {
        System.out.println("Se invoco el método 'agrega()' del manejador");
        return this.manejador.agrega(dato);
    }

    @Override
    public boolean borra(String dato) {
        System.out.println("Se invoco el método 'borra()' del manejador");
        return this.manejador.borra(dato);
    }

    @Override
    public void finaliza() {
        System.out.println("Se invoco el método 'finaliza()' del manejador");
        this.manejador.finaliza();
    }

    @Override
    public boolean agregaObservador(Observador o) {
        System.out.println("Se invoco el método 'agregaObservador()' del manejador");
        return this.manejador.agregaObservador(o);
    }

    @Override
    public boolean quitarObservador(Observador o) {
        System.out.println("Se invoco el método 'quitarObservador()' del manejador");
        return this.manejador.quitarObservador(o);
    }

    @Override
    public void notifica() {
        System.out.println("Se invoco el método 'notifica()' del manejador");
        this.manejador.notifica();
    }

}
