
package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase para modelar la Entidad Grupo
 * @author David Cañon
 */

@Entity
public class GrupoEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad Grupo
     */
    @Id
    @Column (name = "id_grupo")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idGrupo;
    
    /**
     * Variable que almacena el Nombre tipo curso.
     */
    @Column (name = "nombre_grupo")
    private String nombreGrupo;
    
    /**
     * Métodos GET Y SET
     * @return 
     */
    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
}
