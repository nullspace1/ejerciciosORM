package Dominio;

import Converters.ColorConverter;
import Persistencia.Entidad;

import javax.persistence.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
public class Reserva extends Entidad {

    @ManyToOne
    @JoinColumn
    private Cancha canchaUtilizada;

    @Column
    @Convert(converter = ColorConverter.class)
    private final Color colorDeCancha;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime comienzoPartido;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime finDePartido;

    @OneToMany(targetEntity = Jugador.class,fetch = FetchType.LAZY)
    @JoinColumn
    private Set<Jugador> jugadoresParticipantes;

    @ManyToOne(targetEntity = Jugador.class)
    private Jugador jugadorResponsable;

    public Reserva(Cancha canchaUtilizada, LocalDateTime comienzoPartido, Duration duracionPartido){
        this.canchaUtilizada = canchaUtilizada;
        this.colorDeCancha = canchaUtilizada.getColorDeCanchaActual();
        this.comienzoPartido = comienzoPartido;
        this.finDePartido = this.comienzoPartido.plus(duracionPartido);
    }


    public Color getColorDeCancha() {
        return colorDeCancha;
    }


    private int cantidadJugadores(Set<Jugador> jugadoresParticipantes) {
        return jugadoresParticipantes.size();
    }

    public void agregarJugador(Jugador jugador){
        jugadoresParticipantes.add(jugador);
        jugador.setReserva(this);
    }

    public boolean ocurreEntre(LocalDateTime fechaReserva) {
        return fechaReserva.isAfter(comienzoPartido) && fechaReserva.isBefore(finDePartido);
    }
}
