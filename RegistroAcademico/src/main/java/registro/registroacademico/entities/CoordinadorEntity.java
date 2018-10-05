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
 * Clase encargada de modelar la tabla Coordinador
 * @author Andres Jara
 */

@Entity(name = "Coordinador")
public class CoordinadorEntity implements Serializable{
   
    /**
     * LLave primaria de la tabla Coordinador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_coordinador;
    
    /**
     * Atributo nombres de la tabla Coordinador 
     */
    
    @Column(name = "nombres", nullable = false)
    private String nombres;
    
    /**
     * Atributo apellidos de la tabla Coordinador 
     */
    
    @Column (name = "apellidos", nullable = false)
    private String apellidos; 
    
    /**
     * Atributo tipo_documento el cual es llave forenea de la tabla tipo de documento
     * de la tabla tipo de documento 
     */
    
    @ManyToOne
    @JoinColumn (name = "tipo_documento_id", nullable = false)
    private int tipo_documento_id;
     
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
     * Constructor por defecto
     */
    
    public CoordinadorEntity() {
    }
    
    /**
     * ------------- METODOS GET Y SET -------------- 
    */

    public int getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(int id_coordinador) {
        this.id_coordinador = id_coordinador;
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
    
    
    
    
}//class
