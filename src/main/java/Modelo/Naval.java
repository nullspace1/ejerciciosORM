package Modelo;

import javax.persistence.Entity;

@Entity
public class Naval extends FuerzaMilitar{
    public int cantidadDeBarcos;

    @Override
    public void atacarA(Lugar lugar) {
        // tuki
    }
}
