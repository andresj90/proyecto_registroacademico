
package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase para modelar la Entidad Tipo Curso
 * @author David Cañon
 */

@Entity(name = "Tipo_Curso")
public class TipoCursoEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad TipoCurso
     */
    @Id
    @Column (name = "id_tipo_curso")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idTipoCurso;
    
    /**
     * Variable que almacena el Nombre tipo curso.
     */
    @Column (name = "nombre_tipo_curso")
    private String nombreTipoCurso;
   
    /**
     * Métodos GET Y SET
     * @return 
     */
    public Long getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(Long idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public String getNombreTipoCurso() {
        return nombreTipoCurso;
    }

    public void setNombreTipoCurso(String nombreTipoCurso) {
        this.nombreTipoCurso = nombreTipoCurso;
    }
    
    
}
