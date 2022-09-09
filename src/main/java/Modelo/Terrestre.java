package Modelo;

import javax.persistence.Entity;

@Entity
public class Terrestre extends FuerzaMilitar{
    private Integer cantidadDeSoldados;

    @Override
    public void atacarA(Lugar lugar) {

    }
}
