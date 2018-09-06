/*
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
 * Clase encargada de modelar la tabla Tipo_Programa
 * @author Uriel Rodríguez Vallarta
 */
/**
 * Nombre de la tabla que va a almacenar la información acerca de el tipo de 
 * programa
 */

@Entity (name = "Tipo_Programa")
public class TipoProgramaEntity implements Serializable{

    /**
     * LLave primaria de la tabla Tipo_Documento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_tipo_programa; 
   
    /**
     * Atributo nombre tipo de programa; este es el nombre del tipo  de programa
     * que este tendrá
     */
    @Column (name = "nombre_tipo_programa", nullable = false)
    private String nombre_tipo_programa;
    
    /**
     * Constructor de la clase TipoPrograma
     */
    public TipoProgramaEntity() {
    }

    /**
     * Metodos Getter Y Setter 
     */     
    public int getId_tipo_programa() {
        return id_tipo_programa;
    }

    public void setId_tipo_programa(int id_tipo_programa) {
        this.id_tipo_programa = id_tipo_programa;
    }

    public String getNombre_tipo_programa() {
        return nombre_tipo_programa;
    }

    public void setNombre_tipo_programa(String nombre_tipo_programa) {
        this.nombre_tipo_programa = nombre_tipo_programa;
    } 
}//class


    

    