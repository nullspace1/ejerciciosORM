package Dominio;

import Persistencia.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Persona extends Entidad {

    @Column
    private final String nombre;

    @Column
    private final String apellido;

    @Column
    private final String domicilio;

    @Column
    private final long numeroTelefono;

    @Column(columnDefinition = "DATE")
    private final LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, String domicilio, LocalDate fechaNacimiento,  long numeroTelefono){
        this.nombre= nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
