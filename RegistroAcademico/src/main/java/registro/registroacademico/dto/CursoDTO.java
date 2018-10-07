package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.CursoEntity;
import registro.registroacademico.entities.ProgramaEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author Uriel Rodríguez Vallarta
 */
public class CursoDTO {
   
  /**
   * Lista de atributos que hacen referencia al objeto Curso
   */    
  private int id_curso;
  private String nom_curso; 
  private ProgramaEntity programa_id_pr;
  

  /**
   * Constructor por defecto
   */  
  
    public CursoDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param CursoEntity 
     */
    public CursoDTO(CursoEntity CursoEntity) {
        this.id_curso = CursoEntity.getId_curso();
        this.nom_curso = CursoEntity.getNom_curso();
        this.programa_id_pr = CursoEntity.getPrograma();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public CursoEntity toEntity(){
        CursoEntity entity = new CursoEntity(); 
        entity.setId_curso(this.id_curso);
        entity.setNom_curso(this.nom_curso);
        entity.setPrograma(this.programa_id_pr);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos curso
     * @param cursoEntitys
     * @return 
     */
    
    public static List<CursoDTO> tolistCurso(List<CursoEntity> cursoEntitys){
        
        List<CursoDTO> listaObjectoCurso = new ArrayList<>();
        for (int i = 0; i <cursoEntitys.size(); i++) {
            listaObjectoCurso.add(new CursoDTO(cursoEntitys.get(i)));
        }
        
        return listaObjectoCurso;
    
    }

    
    /**
     * Metodos GET AND SET
     * @return 
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

    public ProgramaEntity getPrograma_id_pr() {
        return programa_id_pr;
    }

    public void setPrograma_id_pr(ProgramaEntity programa_id_pr) {
        this.programa_id_pr = programa_id_pr;
    }

}//class