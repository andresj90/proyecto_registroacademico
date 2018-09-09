
package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase para modelar la Entidad Horario
 * @author David Cañon
 */

@Entity(name = "Horario")
public class HorarioEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad Horario
     */
    @Id
    @Column (name = "id_horario")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idHorario;
    
    /**
     * Variable que almacena el dia.
     */
    @Column (name = "dia")
    private String dia;
    
    /**
     * Variable que almacena la hora de inicio.
     */
    @Column (name = "hora_inicio")
    private String horaInicio;
    
    /**
     * Variable que almacena la hora de finalizacion.
     */
    @Column (name = "hora_finalizacion")
    private String horaFinalizacion;

    /**
     * Métodos GET Y SET
     * @return 
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }
}