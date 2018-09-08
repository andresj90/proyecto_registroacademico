
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
 * Clase encargada de modelar la tabla Estudiante
 * @author Andres Jara
 */

@Entity(name = "Estudiante")
public class EstudianteEntity implements Serializable{
    
     /**
     * LLave primaria de la tabla Estudiante
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_estudiante;
    
    /**
     * Atributo nombres de la tabla Estudinate 
     */
    
    @Column(name = "nombres", nullable = false)
    private String nombres;
    
    /**
     * Atributo apellidos de la tabla Estudinate 
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
     * Atributo nro_documento de la tabla Estudinate 
     */
    
    @Column (name = "nro_documento", nullable = false)
    private Long nro_documento; 
    
    /**
     * Atributo codigo de la tabla Estudinate 
     */
    
    @Column (name = "cod_estudiantil", nullable = false)
    private Long cod_estudiantil; 
    
    /**
     * Atributo genero de la tabla Estudinate 
     */
    
    @Column (name = "genero", nullable = false)
    private String genero; 
    
    /**
     * Atributo email de la tabla Estudinate 
     */
    
    @Column (name = "email", nullable = false)
    private String email;
    
    /**
     * Atributo programa_id_pr el cual es llave forenea de la tabla programa
     * de la tabla programa 
     */
    
    @Column (name = "programa_id_pr", nullable = false)
    private int programa_id_pr;
    
    /**
     * Constructor por defecto
     */

    public EstudianteEntity() {
    }
    
    /**
     * ------------- METODOS GET Y SET -------------- 
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

    public int getPrograma_id_pr() {
        return programa_id_pr;
    }

    public void setPrograma_id_pr(int programa_id_pr) {
        this.programa_id_pr = programa_id_pr;
    }
   
    
}//class
