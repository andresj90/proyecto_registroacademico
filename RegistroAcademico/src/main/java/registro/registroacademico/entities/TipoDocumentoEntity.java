package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase encargada de modelar la tabla Tipo_Documento
 * @author Andres Jara
 */
@Entity (name = "Tipo_Documento")
public class TipoDocumentoEntity implements Serializable{

    /**
     * LLave primaria de la tabla Tipo_Documento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_tipo_documento;
    
    /**
     * Atributo tipo de documento; este es el nombre del tipo  de documento 
     * eje : cedula
     */
    @Column (name = "tipo_documento", nullable = false)
    private String tipo_documento;
    
    /**
     * Constructor de la clase TipoDocumento
     */
    public TipoDocumentoEntity() {
    }

    
    /**METODOS SET Y GET*/ 

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

}//class
