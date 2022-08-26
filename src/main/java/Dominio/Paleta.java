package Dominio;

import Converters.ColorConverter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table
public class Paleta{

    @Id
    private int codigoPaleta;

    @Column
    private String nombrePaleta;

    @Column
    @Convert(converter = ColorConverter.class)
    private Color color;

    @Column
    private Double grosor;

    @ManyToOne
    private ConstructorPaleta constructorPaleta;

    public Paleta(int codigoPaleta, String nombrePaleta, Color color, Double grosor, ConstructorPaleta constructorPaleta){
        this.codigoPaleta = codigoPaleta;
        this.nombrePaleta = nombrePaleta;
        this.color = color;
        this.grosor = grosor;
        this.constructorPaleta = constructorPaleta;
    }

}
