package Dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ConstructorPaleta {

    @Id
    private int codigoConstructor;
    @Column
    private String nombre;

    @Column
    private String domicilio;

    public ConstructorPaleta(int codigoConstructor, String nombre, String domicilio){
        this.codigoConstructor = codigoConstructor;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

}
