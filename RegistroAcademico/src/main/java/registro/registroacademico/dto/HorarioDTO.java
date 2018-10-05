package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.HorarioEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author DavidC
 */
public class HorarioDTO {
  /**
   * Lista de atributos que hacen referencia al objeto Horario
   */
  private Long idHorario;
  private String dia; 
  private String horarioInicio;
  private String horarioFinalizacion;
  /**
   * Constructor por defecto
   */  
  
    public HorarioDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param horarioEntity 
     */
    public HorarioDTO(HorarioEntity horarioEntity) {
        this.idHorario = horarioEntity.getIdHorario();
        this.dia = horarioEntity.getDia();
        this.horarioInicio = horarioEntity.getDia();
        this.horarioFinalizacion= horarioEntity.getHoraFinalizacion();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public HorarioEntity toEntity(){
        
        HorarioEntity entity = new HorarioEntity(); 
        entity.setIdHorario(this.idHorario);
        entity.setDia(this.dia);
        entity.setHoraInicio(this.horarioInicio);
        entity.setHoraFinalizacion(this.horarioFinalizacion);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Horario
     * @param horarioEntitys
     * @return 
     */
    
    public static List<HorarioDTO> tolistHorario(List<HorarioEntity> horarioEntitys){
        
        List<HorarioDTO> listaObjectoHorario = new ArrayList<>();
        for (int i = 0; i <horarioEntitys.size(); i++) {
            listaObjectoHorario.add(new HorarioDTO(horarioEntitys.get(i)));
        }
        
        return listaObjectoHorario;
    }
    /**
     * Metodos GET AND SET
     */
    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFinalizacion() {
        return horarioFinalizacion;
    }

    public void setHorarioFinalizacion(String horarioFinalizacion) {
        this.horarioFinalizacion = horarioFinalizacion;
    }
}
