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
 * Clase encargada de modelar la tabla Tipo_Documento
 * @author Andres Jara
 */


/**
 * Nombre de la tabla que va a almacenar la información acerca de la inscripción a 
 * los cursos 
 * @author AndresJ90
 */
@Entity (name = "Inscripcion")
public class InscripcionEntity implements Serializable{
    
     /**
     * LLave primaria de la tabla Tipo_Documento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_inscripcion;
    
    /**
     * Atributo curso_grupo_id, este es una llave foranea la cual conecta con 
     * la tabla que maneja la creacion de cursos 
     */
    
    @Column(name = "curso_grupo_id", nullable = false)
    private int curso_grupo_id;
    
    /**
     * Atributo estudiante_id_est, este es una llave foranea la cual conecta con 
     * la tabla estudiante, nos permitira manejar la inscripcion al estudiante
     */    

    @Column (name = "estudiante_id_est", nullable = false)
    private int estudiante_id_est; 
    
    /**
     * Constructor por defecto
     */

    public InscripcionEntity() {
    }
 

    /**
     * ------------- METODOS GET Y SET -------------- 
     */
    
    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getCurso_grupo_id() {
        return curso_grupo_id;
    }

    public void setCurso_grupo_id(int curso_grupo_id) {
        this.curso_grupo_id = curso_grupo_id;
    }

    public int getEstudiante_id_est() {
        return estudiante_id_est;
    }

    public void setEstudiante_id_est(int estudiante_id_est) {
        this.estudiante_id_est = estudiante_id_est;
    }
    
    
}//clase
