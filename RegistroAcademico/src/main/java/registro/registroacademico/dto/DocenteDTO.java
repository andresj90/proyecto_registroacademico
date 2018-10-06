package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.DocenteEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author AndresJ90
 */
public class DocenteDTO {
    
   /**
   * Lista de atributos que hacen referencia al objeto Docente
   */    
    
  private int id_docente;
  private String nombres; 
  private String apellidos;
   private int tipo_documento_id; 
  private Long nro_documento; 
  private String genero; 
  private String email; 
  private String area_profundizacion;
  
  
  /**
   * Constructor por defecto
   */  
  
    public DocenteDTO() {
    }
    
    
  /**
     * Mapeo de Entidad a Objeto
     * @param coordinadorEntity 
     */
    
    
    public DocenteDTO(DocenteEntity docenteEntity) {
        this.id_docente = docenteEntity.getId_docente();
        this.nombres = docenteEntity.getNombres();
        this.apellidos = docenteEntity.getApellidos();
        this.tipo_documento_id = docenteEntity.getTipo_documento_id();
        this.nro_documento = docenteEntity.getNro_documento();
        this.genero = docenteEntity.getGenero();
        this.email = docenteEntity.getEmail();
        this.area_profundizacion = docenteEntity.getArea_profundizacion();
    }

    /**
     * Mapear de Objeto a Entidad
     * @return 
     */
    
    public DocenteEntity toEntity(){
     DocenteEntity entity = new DocenteEntity();
     
     entity.setId_docente(this.id_docente);
     entity.setNombres(this.nombres);
     entity.setApellidos(this.apellidos);
     entity.setTipo_documento_id(this.tipo_documento_id);
     entity.setNro_documento(this.nro_documento);
     entity.setGenero(this.genero);
     entity.setEmail(this.email);
     entity.setArea_profundizacion(this.area_profundizacion);
     
     return entity;
    }
  
    /**
     * Conversor lista entidad a lista de objetos Docente
     * @param docenteEntitys 
     * @return 
     */
    
    public static List<DocenteDTO> tolistDocente(List<DocenteEntity> docenteEntitys){
        
        List<DocenteDTO> listaObjectoDocente = new ArrayList<>();
        for (int i = 0; i <docenteEntitys.size(); i++) {
            listaObjectoDocente.add(new DocenteDTO(docenteEntitys.get(i)));
        }
        
        return listaObjectoDocente;
    }
    
    /**
     * Metodos GET AND SET
     * @return 
     */

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
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

    public String getArea_profundizacion() {
        return area_profundizacion;
    }

    public void setArea_profundizacion(String area_profundizacion) {
        this.area_profundizacion = area_profundizacion;
    }
    
    
}
