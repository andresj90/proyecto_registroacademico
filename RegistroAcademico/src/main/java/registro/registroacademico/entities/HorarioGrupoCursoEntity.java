
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
 * Clase para modelar la Entidad Horario Grupo Curso
 * @author David Cañon
 */

@Entity(name = "Horario_Grupo_Curso")
public class HorarioGrupoCursoEntity implements Serializable{
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
    @ManyToOne
    @JoinColumn(name="id_curso_grupo")
    private CursoGrupoEntity cursoGrupoId;
    
    /**
     * Llave Foranea con la Entidad Horario
     */
    @ManyToOne
    @JoinColumn(name="id_horario")
    private HorarioEntity horarioId;
    
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

    public CursoGrupoEntity getCursoGrupoId() {
        return cursoGrupoId;
    }

    public void setCursoGrupoId(CursoGrupoEntity cursoGrupoId) {
        this.cursoGrupoId = cursoGrupoId;
    }

    public HorarioEntity getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(HorarioEntity horarioId) {
        this.horarioId = horarioId;
    }
}