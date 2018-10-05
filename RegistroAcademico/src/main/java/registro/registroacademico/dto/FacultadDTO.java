package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.FacultadEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author Uriel Rodríguez Vallarta
 */
public class FacultadDTO {
   
  /**
   * Lista de atributos que hacen referencia al objeto facultad
   */    
  private int id_facultad;
  private String nombre_facultad; 

  /**
   * Constructor por defecto
   */  
  
    public FacultadDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param FacultadEntity 
     */
    public FacultadDTO(FacultadEntity FacultadEntity) {
        this.id_facultad = FacultadEntity.getId_facultad();
        this.nombre_facultad = FacultadEntity.getNombre_facultad();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public FacultadEntity toEntity(){
        FacultadEntity entity = new FacultadEntity(); 
        entity.setId_facultad(this.id_facultad);
        entity.setNombre_facultad(this.nombre_facultad);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos curso
     * @param facultadEntitys
     * @return 
     */
    
    public static List<FacultadDTO> tolistFacultad(List<FacultadEntity> facultadEntitys){
        
        List<FacultadDTO> listaObjectoFacultad = new ArrayList<>();
        for (int i = 0; i <facultadEntitys.size(); i++) {
            listaObjectoFacultad.add(new FacultadDTO(facultadEntitys.get(i)));
        }
        
        return listaObjectoFacultad;
    
    }

    
    /**
     * Metodos GET AND SET
     * @return 
     */

    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_tipo_programa(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }
}