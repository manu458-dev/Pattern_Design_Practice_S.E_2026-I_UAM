/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.uam.is.practicadiseno.datos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class MapeadorDatosImpl implements MapeadorDatos{
   
    //SE AGREGA LA ESTRUCTURA DE DATOS PARA ALMACENAR LOS DATOS
    private List <String> datos = new ArrayList <String> ();
    
    //SEAGREGA AHORA OTRA ESTRUCTURA  ()
    private String[] datos2 = {};
    
    public MapeadorDatosImpl() {
        this.datos.add("Entrada 1");
        this.datos.add("Entrada 2");
        this.datos.add("Entrada 3");
    }
    
    @Override
    public boolean agrega(String dato) {
        if(!dato.equals("") && !datos.contains(dato)) {
                datos.add(dato);
                return true;
        }
        return false;
    }

    @Override
    public boolean borra(String dato) {
        return this.datos.remove(dato);
    }

    @Override
    public String[] dameDatos() {
        String arregloDatos [] = new String[datos.size()];
        datos.toArray(arregloDatos);
        return arregloDatos;
    }

    @Override
    public boolean contiene(String dato) {
        if(this.datos.contains(dato)) {
            return true;
        }
        return false;
    }
     
}
