
package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase para modelar la Entidad Horario Grupo Curso
 * @author David Cañon
 */

@Entity
public class HorarioGrupoCurso implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    /**
     * Llave Primaria de la Entidad horario grupo curso
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "horario_grupo_curos")
    private Long idHorarioGrupoCurso;
    /**
     * Llave Foranea con la Entidad Curso Grupo
     */
    @Column (name = "curso_grupo_id")
    private Long cursoGrupoId;
    
    /**
     * Llave Foranea con la Entidad Horario
     */
    @Column (name = "horario_id")
    private Long horarioId;
    
    /**
     * Métodos GET Y SET
     * @return 
     */
    public Long getIdHorarioGrupoCurso() {
        return idHorarioGrupoCurso;
    }

    public void setIdHorarioGrupoCurso(Long idHorarioGrupoCurso) {
        this.idHorarioGrupoCurso = idHorarioGrupoCurso;
    }

    public Long getCursoGrupoId() {
        return cursoGrupoId;
    }

    public void setCursoGrupoId(Long cursoGrupoId) {
        this.cursoGrupoId = cursoGrupoId;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }
    
}