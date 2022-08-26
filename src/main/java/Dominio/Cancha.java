package Dominio;


import Converters.ColorConverter;
import Persistencia.Entidad;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Cancha extends Entidad {

    @Column
    private final String nombre;
    @Column(name = "Iluminacion")
    private final Boolean tieneIluminacion;

    @Column
    @Convert(converter = ColorConverter.class)
    private Color colorDeCanchaActual;

    @OneToMany(targetEntity = Reserva.class,fetch = FetchType.EAGER)
    @JoinColumn
    private final List<Reserva> reservasRealizadas = new ArrayList<>();

    public Cancha(String nombre, Boolean tieneIluminacion ,Color colorInicial){
        this.nombre = nombre;
        this.tieneIluminacion = tieneIluminacion;
    }


    public Boolean estaDisponibleEn(LocalDateTime fecha){
        return seEncuentraUsableEn(fecha) && noHayOtrasReservasEn(fecha);
    }

    public void agregarReserva(Reserva reserva){
        reservasRealizadas.add(reserva);
    }

    public void setColorDeCanchaActual(Color colorDeCanchaActual) {
        this.colorDeCanchaActual = colorDeCanchaActual;
    }

    public Color getColorDeCanchaActual() {
        return colorDeCanchaActual;
    }

    private Boolean seEncuentraUsableEn(LocalDateTime fechaReserva){
        return tieneIluminacion || ((fechaReserva.getHour() < 18 && fechaReserva.getHour() > 12));
    }

    private Boolean noHayOtrasReservasEn(LocalDateTime fechaReserva){
        return reservasRealizadas.stream().noneMatch(reserva -> reserva.ocurreEntre(fechaReserva));
    }

}
