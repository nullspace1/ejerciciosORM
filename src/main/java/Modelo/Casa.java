package Modelo;

import Persistencia.Entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Casa implements Fundable {

    @Column
    private String nombre;

    @Column
    private Integer patrimonio;

    @Column
    private Integer anioFundacion;

    @Column
    private Casa vasallaDe;

    @OneToMany(targetEntity = FuerzaMilitar.class,fetch = FetchType.LAZY)
    @JoinColumn
    private List<FuerzaMilitar> fuerzaMilitares;

    @Override
    public Integer anioFundacion() {
        return null;
    }
}
