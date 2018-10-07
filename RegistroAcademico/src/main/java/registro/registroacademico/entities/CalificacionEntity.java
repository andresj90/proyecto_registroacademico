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
    private CursoGrupoEntity cursoGrupo;
    
    /**
     * Atributo estudiante_id_est, este es una llave foranea la cual conecta con 
     * la tabla estudiante, nos permitira seleccionar el estudiante al cual se le 
     * da la nota
     */    
    @ManyToOne
    @JoinColumn (name = "estudiante_id_est", nullable = false)
    private EstudianteEntity estudiante; 
    
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

    public CursoGrupoEntity getCursoGrupo() {
        return cursoGrupo;
    }

    public void setCursoGrupo(CursoGrupoEntity cursoGrupo) {
        this.cursoGrupo = cursoGrupo;
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    public float getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(float valor_nota) {
        this.valor_nota = valor_nota;
    }

}//class
