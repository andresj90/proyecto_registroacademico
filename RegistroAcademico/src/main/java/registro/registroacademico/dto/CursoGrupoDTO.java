
package registro.registroacademico.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import registro.registroacademico.entities.CursoEntity;
import registro.registroacademico.entities.CursoGrupoEntity;
import registro.registroacademico.entities.DocenteEntity;
import registro.registroacademico.entities.GrupoEntity;
import registro.registroacademico.entities.TipoCursoEntity;

/**
 * Clase para modelar la Entidad curso grupo
 * @author David Cañon
 */
public class CursoGrupoDTO {
    /**
   * Lista de atributos que hacen referencia al objeto curso Grupo
   */
  private int idCursoGrupo;
  private CursoEntity cursoIdCur;
  private GrupoEntity grupoIdGr;
  private DocenteEntity docenteIdGr;
  private TipoCursoEntity tipoCursoId;
  private int cupoGrupo;
  /**
   * Constructor por defecto
   */  
  
    public CursoGrupoDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param cursoGrupoEntity 
     */
    public CursoGrupoDTO(CursoGrupoEntity cursoGrupoEntity) {
        this.idCursoGrupo = cursoGrupoEntity.getIdCursoGrupo();
        this.cursoIdCur = cursoGrupoEntity.getCursoIdCur();
        this.grupoIdGr = cursoGrupoEntity.getGrupoIdGr();
        this.docenteIdGr = cursoGrupoEntity.getDocenteIdGr();
        this.tipoCursoId = cursoGrupoEntity.getTipoCursoId();
        this.cupoGrupo = cursoGrupoEntity.getCupoGrupo();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public CursoGrupoEntity toEntity(){
        
        CursoGrupoEntity entity = new CursoGrupoEntity(); 
        entity.setIdCursoGrupo(this.idCursoGrupo);
        entity.setCursoIdCur(this.cursoIdCur);
        entity.setGrupoIdGr(this.grupoIdGr);
        entity.setDocenteIdGr(this.docenteIdGr);
        entity.setTipoCursoId(this.tipoCursoId);
        entity.setCupoGrupo(this.cupoGrupo);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos curso Grupo
     * @param cursoGrupoEntitys
     * @return 
     */
    
    public static List<CursoGrupoDTO> tolistCursoGrupo(List<CursoGrupoEntity> cursoGrupoEntitys){
        
        List<CursoGrupoDTO> listaObjectoHorario = new ArrayList<>();
        for (int i = 0; i <cursoGrupoEntitys.size(); i++) {
            listaObjectoHorario.add(new CursoGrupoDTO(cursoGrupoEntitys.get(i)));
        }
        
        return listaObjectoHorario;
    }
    /**
     * Métodos GET Y SET
     * @return 
     */
    public int getIdCursoGrupo() {
        return idCursoGrupo;
    }

    public void setIdCursoGrupo(int idCursoGrupo) {
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

    public int getCupoGrupo() {
        return cupoGrupo;
    }

    public void setCupoGrupo(int cupoGrupo) {
        this.cupoGrupo = cupoGrupo;
    }

}