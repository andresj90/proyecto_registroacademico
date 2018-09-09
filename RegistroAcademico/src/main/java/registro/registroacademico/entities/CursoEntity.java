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
 * Clase encargada de modelar la tabla Curso
 * @author Uriel Rodríguez Vallarta
 */
/**
 * Nombre de la tabla que va a almacenar la información acerca de Curso
 */

@Entity (name = "Curso")
public class CursoEntity implements Serializable{

    /**
     * LLave primaria de la tabla Curso
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_curso; 
   
    /**
     * Atributo nombre de curso
     */
    @Column (name = "nom_curso", nullable = false)
    private String nom_curso;
    
    /**
     * Atributo programa que es una llave foranea y nos manejará el curso
     */
    @Column (name = "programa_id_pr", nullable = false)
    private String programa_id_pr;
    
    /**
     * Constructor de la clase Curso
     */
    public CursoEntity() {
    }

    /**
     * Metodos Getter Y Setter 
     */  
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNom_curso() {
        return nom_curso;
    }

    public void setNom_curso(String nom_curso) {
        this.nom_curso = nom_curso;
    }

    public String getPrograma_id_pr() {
        return programa_id_pr;
    }

    public void setPrograma_id_pr(String programa_id_pr) {
        this.programa_id_pr = programa_id_pr;
    }   
}//class