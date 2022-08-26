package Dominio;

import Persistencia.Entidad;

import javax.persistence.*;

@Entity
@Table
public class Jugador extends Entidad {

    @ManyToOne(cascade = CascadeType.ALL)
    private Persona persona;

    @ManyToOne(cascade = CascadeType.ALL)
    private Paleta paletaUtilizada;

    @ManyToOne(cascade = CascadeType.ALL)
    private Reserva reserva;

    public Jugador(Persona persona, Paleta paletaUtilizada){
        this.persona = persona;
        this.paletaUtilizada = paletaUtilizada;
    }

    public Paleta getPaletaUtilizada() {
        return paletaUtilizada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
