package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.EstudianteEntity;
import registro.registroacademico.entities.ProgramaEntity;
import registro.registroacademico.entities.TipoDocumentoEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author AndresJ90
 */
public class EstudianteDTO {
  /**
   * Lista de atributos que hacen referencia al objeto Estudiante
   */    
  private int id_estudiante;
  private String nombres; 
  private String apellidos;
  private TipoDocumentoEntity tipo_documento_id;
  private Long nro_documento;
  private Long cod_estudiantil;
  private String genero; 
  private String email; 
  private ProgramaEntity programa_id_pr;
   
  /**
   * Constructor por defecto
   */  
  
    public EstudianteDTO() {
    }
    
    /**
     * Mapeo de Entidad a Objeto
     * @param coordinadorEntity 
     */
    
    public EstudianteDTO(EstudianteEntity estudianteEntity) {
        this.id_estudiante = estudianteEntity.getId_estudiante();
        this.nombres = estudianteEntity.getNombres();
        this.apellidos = estudianteEntity.getApellidos();
        this.tipo_documento_id = estudianteEntity.getTipoDocumento();
        this.nro_documento = estudianteEntity.getNro_documento();
        this.cod_estudiantil = estudianteEntity.getCod_estudiantil();
        this.genero = estudianteEntity.getGenero();
        this.email = estudianteEntity.getEmail();
        this.programa_id_pr = estudianteEntity.getPrograma();
    }
  
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */
  public EstudianteEntity toEntity(){
      
      EstudianteEntity estudianteEntity = new EstudianteEntity(); 
      
      estudianteEntity.setId_estudiante(this.id_estudiante);
      estudianteEntity.setNombres(this.nombres);
      estudianteEntity.setApellidos(this.apellidos);
      estudianteEntity.setTipoDocumento(this.tipo_documento_id);
      estudianteEntity.setNro_documento(this.nro_documento);
      estudianteEntity.setCod_estudiantil(this.cod_estudiantil);
      estudianteEntity.setGenero(this.genero);
      estudianteEntity.setEmail(this.email);
      estudianteEntity.setPrograma(this.programa_id_pr);
      
      return estudianteEntity;
  }
  
  /**
     * Conversor lista entidad a lista de objetos Estudiante
     * @param estudianteEntitys 
     * @return 
     */
   
  public static List<EstudianteDTO> tolistEstudiante(List<EstudianteEntity> estudianteEntitys){
        
        List<EstudianteDTO> listaObjectoEstudiante = new ArrayList<>();
        for (int i = 0; i <estudianteEntitys.size(); i++) {
            listaObjectoEstudiante.add(new EstudianteDTO(estudianteEntitys.get(i)));
        }
        
        return listaObjectoEstudiante;
    }
  
     /**
     * Metodos GET AND SET
     * @return 
     */
  

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
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

    public TipoDocumentoEntity getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(TipoDocumentoEntity tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public Long getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(Long nro_documento) {
        this.nro_documento = nro_documento;
    }

    public Long getCod_estudiantil() {
        return cod_estudiantil;
    }

    public void setCod_estudiantil(Long cod_estudiantil) {
        this.cod_estudiantil = cod_estudiantil;
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

    public ProgramaEntity getPrograma_id_pr() {
        return programa_id_pr;
    }

    public void setPrograma_id_pr(ProgramaEntity programa_id_pr) {
        this.programa_id_pr = programa_id_pr;
    }

}//class
