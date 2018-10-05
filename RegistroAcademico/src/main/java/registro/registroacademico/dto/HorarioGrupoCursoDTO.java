
package registro.registroacademico.dto;
import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.CursoGrupoEntity;
import registro.registroacademico.entities.HorarioEntity;
import registro.registroacademico.entities.HorarioGrupoCursoEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author DavidC
 */
public class HorarioGrupoCursoDTO {
    /**
   * Lista de atributos que hacen referencia al objeto Horario
   */
  private Long idHorarioGrupoCurso;
  private CursoGrupoEntity cursoGrupoId; 
  private HorarioEntity horarioId;
  
  /**
   * Constructor por defecto
   */
    public HorarioGrupoCursoDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param horarioGrupoCursoEntity 
     */
    public HorarioGrupoCursoDTO(HorarioGrupoCursoEntity horarioGrupoCursoEntity) {
        this.idHorarioGrupoCurso = horarioGrupoCursoEntity.getIdHorarioGrupoCurso();
        this.cursoGrupoId = horarioGrupoCursoEntity.getCursoGrupoId();
        this.horarioId = horarioGrupoCursoEntity.getHorarioId();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public HorarioGrupoCursoEntity toEntity(){
        
        HorarioGrupoCursoEntity entity = new HorarioGrupoCursoEntity(); 
        entity.setIdHorarioGrupoCurso(this.idHorarioGrupoCurso);
        entity.setCursoGrupoId(this.cursoGrupoId);
        entity.setHorarioId(this.horarioId);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos HorarioGrupoCurso
     * @param horarioGrupoCursoEntitys
     * @return 
     */
    
    public static List<HorarioGrupoCursoDTO> tolistHorario(List<HorarioGrupoCursoEntity> horarioGrupoCursoEntitys){
        
        List<HorarioGrupoCursoDTO> listaObjectoHorario = new ArrayList<>();
        for (int i = 0; i <horarioGrupoCursoEntitys.size(); i++) {
            listaObjectoHorario.add(new HorarioGrupoCursoDTO(horarioGrupoCursoEntitys.get(i)));
        }
        
        return listaObjectoHorario;
    }
    /**
     * Metodos GET AND SET
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

