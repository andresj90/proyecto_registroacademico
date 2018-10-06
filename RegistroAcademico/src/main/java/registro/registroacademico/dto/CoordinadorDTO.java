package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.CoordinadorEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author AndresJ90
 */
public class CoordinadorDTO {
   
  /**
   * Lista de atributos que hacen referencia al objeto Coordinador
   */    
  private int id_coodinador;
  private String nombres; 
  private String apellidos;
  private String genero; 
  private String email; 
  private int tipo_documento_id; 
  private Long nro_documento; 
  


  /**
   * Constructor por defecto
   */  
  
    public CoordinadorDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param coordinadorEntity 
     */
    public CoordinadorDTO(CoordinadorEntity coordinadorEntity) {
        this.id_coodinador = coordinadorEntity.getId_coordinador();
        this.nombres = coordinadorEntity.getNombres();
        this.apellidos = coordinadorEntity.getApellidos();
        this.genero = coordinadorEntity.getGenero();
        this.email = coordinadorEntity.getEmail();
        this.tipo_documento_id = coordinadorEntity.getTipo_documento_id();
        this.nro_documento = coordinadorEntity.getNro_documento();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public CoordinadorEntity toEntity(){
        
        CoordinadorEntity entity = new CoordinadorEntity(); 
        entity.setId_coordinador(this.id_coodinador);
        entity.setNombres(this.nombres);
        entity.setApellidos(this.apellidos);
        entity.setGenero(this.genero);
        entity.setEmail(this.email);
        entity.setTipo_documento_id(this.tipo_documento_id);
        entity.setNro_documento(this.nro_documento);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Coordinador
     * @param coordinadorEntitys
     * @return 
     */
    
    public static List<CoordinadorDTO> tolistCoordinador(List<CoordinadorEntity> coordinadorEntitys){
        
        List<CoordinadorDTO> listaObjectoCoordinador = new ArrayList<>();
        for (int i = 0; i <coordinadorEntitys.size(); i++) {
            listaObjectoCoordinador.add(new CoordinadorDTO(coordinadorEntitys.get(i)));
        }
        
        return listaObjectoCoordinador;
    }
            
    
    /**
     * Metodos GET AND SET
     * @return 
     */

    public int getId_coodinador() {
        return id_coodinador;
    }

    public void setId_coodinador(int id_coodinador) {
        this.id_coodinador = id_coodinador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(int tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public Long getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(Long nro_documento) {
        this.nro_documento = nro_documento;
    }
 
}//class
