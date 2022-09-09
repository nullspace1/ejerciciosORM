package Modelo;

import Persistencia.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Region extends Entidad {

    @Column
    private String nombre;

    @Column
    private Casa casaPrincipal;
}
