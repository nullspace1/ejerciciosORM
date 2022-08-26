package Persistencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract  class Entidad {
    @Id
    @GeneratedValue
    int id;
}
