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
 * Clase para modelar la Entidad Curso Grupo
 * @author David Cañon
 */
@Entity(name = "Curso_Grupo")
public class CursoGrupoEntity implements Serializable{
    /**
     * Atributo estático para el manejo de curso_grupo
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad CursoGrupo
     */
    @Id
    @Column (name = "id_curso_grupo")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idCursoGrupo;
    
    /**
     * Llave Foranea con la Entidad Curso
     */
    @ManyToOne
    @JoinColumn(name="id_curso")
    private CursoEntity cursoIdCur;
    
    /**
     * Llave Foranea con la Entidad Grupo
     */
    @ManyToOne
    @JoinColumn(name="id_grupo")
    private GrupoEntity grupoIdGr;
    
    /**
     * Llave Foranea con la Entidad Docente
     */
    @ManyToOne
    @JoinColumn(name="id_docente")
    private DocenteEntity docenteIdGr;
    
    /**
     * Llave Foranea con la Entidad Tipo Curso
     */
    @ManyToOne
    @JoinColumn(name="id_tipo_curso")
    private TipoCursoEntity tipoCursoId;
    
    /**
     * Variable que almacena el cupo del grupo.
     */
    @Column (name = "cupo_grupo")
    private Long cupoGrupo;
    
    /**
     * Métodos GET Y SET
     * @return 
     */
    public Long getIdCursoGrupo() {
        return idCursoGrupo;
    }

    public void setIdCursoGrupo(Long idCursoGrupo) {
        this.idCursoGrupo = idCursoGrupo;
    }

    public CursoEntity getCursoIdCur() {
        return cursoIdCur;
    }

    public void setCursoIdCur(CursoEntity cursoIdCur) {
        this.cursoIdCur = cursoIdCur;
    }

    public GrupoEntity getGrupoIdGr() {
        return grupoIdGr;
    }

    public void setGrupoIdGr(GrupoEntity grupoIdGr) {
        this.grupoIdGr = grupoIdGr;
    }

    public DocenteEntity getDocenteIdGr() {
        return docenteIdGr;
    }

    public void setDocenteIdGr(DocenteEntity docenteIdGr) {
        this.docenteIdGr = docenteIdGr;
    }

    public TipoCursoEntity getTipoCursoId() {
        return tipoCursoId;
    }

    public void setTipoCursoId(TipoCursoEntity tipoCursoId) {
        this.tipoCursoId = tipoCursoId;
    }

    public Long getCupoGrupo() {
        return cupoGrupo;
    }

    public void setCupoGrupo(Long cupoGrupo) {
        this.cupoGrupo = cupoGrupo;
    }    
}
