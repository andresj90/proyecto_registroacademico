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
 * Clase encargada de modelar la tabla Programa
 * @author Uriel Rodríguez Vallarta
 */

@Entity (name = "Programa")
public class ProgramaEntity implements Serializable{
    
     /**
     * LLave primaria de la tabla Programa
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_programa;
    
     /**
     * Atributo que maneja nombre de programa
     */
    @Column(name = "nombre_programa", nullable = false)
    private String nombre_programa;
    
    /**
     * Atributo que maneja los créditos del programa a cursar
     */
    @Column(name = "creditos_programa", nullable = false)
    private int creditos_programa;
    
    /**
     * Atributo tipo_programa_id, este es una llave foranea la cual conecta con 
     * la tabla que maneja los tipos de programa
     */
    @ManyToOne
    @JoinColumn(name = "tipo_programa_id", nullable = false)
    private TipoProgramaEntity tipoPrograma;
    
    /**
     * Atributo facultad_id_facultad, este es una llave foranea la cual conecta con 
     * la tabla de facultad
     */    
    @ManyToOne
    @JoinColumn (name = "facultad_id_facultad", nullable = false)
    private FacultadEntity facultad; 
    
    /**
     * Atributo coordinador_id_coor, este es una llave foranea la cual conecta con 
     * la tabla de coordinador
     */    
    @ManyToOne
    @JoinColumn (name = "coordinador_id_coor", nullable = false)
    private CoordinadorEntity coordinador; 
    
    /**
     * Constructor por defecto
     */
    public ProgramaEntity() {
    }

    /**
     * ------------- METODOS GET Y SET -------------- 
     */
    
    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

    public int getCreditos_programa() {
        return creditos_programa;
    }

    public void setCreditos_programa(int creditos_programa) {
        this.creditos_programa = creditos_programa;
    }

    public TipoProgramaEntity getTipoPrograma() {
        return tipoPrograma;
    }

    public void setTipoPrograma(TipoProgramaEntity tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }

    public FacultadEntity getFacultad() {
        return facultad;
    }

    public void setFacultad(FacultadEntity facultad) {
        this.facultad = facultad;
    }

    public CoordinadorEntity getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(CoordinadorEntity coordinador) {
        this.coordinador = coordinador;
    }
}//clase
