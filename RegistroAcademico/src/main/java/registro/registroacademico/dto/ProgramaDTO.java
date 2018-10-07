package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.CoordinadorEntity;
import registro.registroacademico.entities.FacultadEntity;
import registro.registroacademico.entities.ProgramaEntity;
import registro.registroacademico.entities.TipoProgramaEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author Uriel Rodríguez Vallarta
 */
public class ProgramaDTO {
   
  /**
   * Lista de atributos que hacen referencia al objeto Programa
   */    
  private int id_programa;
  private String nombre_programa; 
  private int creditos_programa;
  private TipoProgramaEntity tipo_programa_id;
  private FacultadEntity facultad_id_facultad; 
  private CoordinadorEntity coordinador_id_coor;
  
  

  /**
   * Constructor por defecto
   */  
  
    public ProgramaDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param ProgramaEntity 
     */
    public ProgramaDTO(ProgramaEntity ProgramaEntity) {
        this.id_programa = ProgramaEntity.getId_programa();
        this.nombre_programa = ProgramaEntity.getNombre_programa();
        this.creditos_programa = ProgramaEntity.getCreditos_programa();
        this.tipo_programa_id = ProgramaEntity.getTipoPrograma();
        this.facultad_id_facultad = ProgramaEntity.getFacultad();
        this.coordinador_id_coor = ProgramaEntity.getCoordinador();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public ProgramaEntity toEntity(){
        ProgramaEntity entity = new ProgramaEntity(); 
        entity.setId_programa(this.id_programa);
        entity.setNombre_programa(this.nombre_programa);
        entity.setCreditos_programa(this.creditos_programa);
        entity.setTipoPrograma(this.tipo_programa_id);
        entity.setFacultad(this.facultad_id_facultad);
        entity.setCoordinador(this.coordinador_id_coor);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Programa
     * @param programaEntitys
     * @return 
     */
    
    public static List<ProgramaDTO> tolistPrograma(List<ProgramaEntity> programaEntitys){
        
        List<ProgramaDTO> listaObjectoPrograma = new ArrayList<>();
        for (int i = 0; i <programaEntitys.size(); i++) {
            listaObjectoPrograma.add(new ProgramaDTO(programaEntitys.get(i)));
        }
        
        return listaObjectoPrograma;
    
    }

    
    /**
     * Metodos GET AND SET
     * @return 
     */

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }
    
    public int getCreditos_programa() {
        return creditos_programa;
    }

    public void setCreditos_programa(int creditos_programa) {
        this.creditos_programa = creditos_programa;    
    }    

    public TipoProgramaEntity getTipo_programa_id() {
        return tipo_programa_id;
    }

    public void setTipo_programa_id(TipoProgramaEntity tipo_programa_id) {
        this.tipo_programa_id = tipo_programa_id;
    }

    public FacultadEntity getFacultad_id_facultad() {
        return facultad_id_facultad;
    }

    public void setFacultad_id_facultad(FacultadEntity facultad_id_facultad) {
        this.facultad_id_facultad = facultad_id_facultad;
    }

    public CoordinadorEntity getCoordinador_id_coor() {
        return coordinador_id_coor;
    }

    public void setCoordinador_id_coor(CoordinadorEntity coordinador_id_coor) {
        this.coordinador_id_coor = coordinador_id_coor;
    }
    
}//class