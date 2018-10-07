
package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de modelar la tabla Docente
 * @author Andres Jara
 */

@Entity(name = "Docente")
public class DocenteEntity implements Serializable{
   
    /**
     * LLave primaria de la tabla Docente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_docente;
    
    /**
     * Atributo nombres de la tabla Docente 
     */
    
    @Column(name = "nombres", nullable = false)
    private String nombres;
    
    /**
     * Atributo apellidos de la tabla Docente 
     */
    
    @Column (name = "apellidos", nullable = false)
    private String apellidos; 
    
    /**
     * Atributo tipo_documento el cual es llave forenea de la tabla tipo de documento
     * de la tabla tipo de documento 
     */
    
    @ManyToOne
    @JoinColumn (name = "tipo_documento_id", nullable = false)
    private TipoDocumentoEntity tipoDocumento;
     
    /**
     * Atributo nro_documento de la tabla Docente 
     */
    
    @Column (name = "nro_documento", nullable = false)
    private Long nro_documento; 
    
    /**
     * Atributo genero de la tabla Docente 
     */
    
    @Column (name = "genero", nullable = false)
    private String genero; 
    
    /**
     * Atributo email de la tabla Estudinate 
     */
    
    @Column (name = "email", nullable = false)
    private String email;
    
    /**
     * Atributo email de la tabla Estudinate 
     */
    
    @Column (name = "area_profundizacion", nullable = false)
    private String area_profundizacion;

    /**
     * Constructor por defecto
     */
    
    public DocenteEntity() {
    }
    
    /**
     * ------------- METODOS GET Y SET -------------- 
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

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
    
}//class
