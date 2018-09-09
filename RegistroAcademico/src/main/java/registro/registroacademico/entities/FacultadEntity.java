/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase encargada de modelar la tabla Facultad
 * @author Uriel Rodríguez Vallarta
 */
/**
 * Nombre de la tabla que va a almacenar la información acerca de facultad
 */

@Entity (name = "Facultad")
public class FacultadEntity implements Serializable{

    /**
     * LLave primaria de la tabla Tipo_Documento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_facultad; 
   
    /**
     * Atributo nombre de facultad; este es el nombre de la facultad
     */
    @Column (name = "nombre_facultad", nullable = false)
    private String nombre_facultad;
    
    /**
     * Constructor de la clase Facultad
     */
    public FacultadEntity() {
    }

    /**
     * Metodos Getter Y Setter 
     */     
    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }
}//class