package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de modelar la tabla Inscripcion
 * @author Andres Jara
 */

@Entity (name = "Inscripcion")
public class InscripcionEntity implements Serializable{
    
     /**
     * LLave primaria de la tabla Inscripcion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_inscripcion;
    
    /**
     * Atributo curso_grupo_id, este es una llave foranea la cual conecta con 
     * la tabla que maneja la creacion de cursos 
     */
    
    @ManyToOne
    @JoinColumn(name = "id_curso_grupo", nullable = false)
    private CursoGrupoEntity curso_grupo;
    
    /**
     * Atributo estudiante_id_est, este es una llave foranea la cual conecta con 
     * la tabla estudiante, nos permitira manejar la inscripcion al estudiante
     */    
    @ManyToOne
    @JoinColumn (name = "estudiante_id_est", nullable = false)
    private EstudianteEntity estudiante; 
    
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

    public CursoGrupoEntity getCurso_grupo() {
        return curso_grupo;
    }

    public void setCurso_grupo(CursoGrupoEntity curso_grupo) {
        this.curso_grupo = curso_grupo;
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }
}//clase  
