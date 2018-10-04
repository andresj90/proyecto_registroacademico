package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Clase encargada de modelar la tabla Calificacion
 * @author Andres Jara
 */

@Entity(name = "Calificacion")
public class CalificacionEntity implements Serializable{
    
    /**
     * LLave primaria de la tabla Calificacion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_calificacion;
    
     /**
     * Atributo curso_grupo_id, este es una llave foranea la cual conecta con 
     * la tabla curso_grupo, nos permitira calificar la materia del curso que 
     * tomó el estudiante
     */   
    @ManyToOne
    @JoinColumn(name = "curso_grupo_id", nullable = false)
    private int curso_grupo_id;
    
    /**
     * Atributo estudiante_id_est, este es una llave foranea la cual conecta con 
     * la tabla estudiante, nos permitira seleccionar el estudiante al cual se le 
     * da la nota
     */    
    @ManyToOne
    @JoinColumn (name = "estudiante_id_est", nullable = false)
    private int estudiante_id_est; 
    
    /**
     * Atributo en el cual se almacenará la nota del estudiante, es de tipo 
     * float y el se acaptarán 2 cifras decimales y se redondeará la nota al minimo o 
     * mayor más cercano.
     */   
    
    @Column (name = "valor_nota", nullable = false)
    private float valor_nota; 
    
    /**
     * Constructor por defecto
     */

    public CalificacionEntity() {
    }

    
    /**METODOS SET Y GET*/ 
    
    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
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

    public float getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(float valor_nota) {
        this.valor_nota = valor_nota;
    }
    
    
}//class
