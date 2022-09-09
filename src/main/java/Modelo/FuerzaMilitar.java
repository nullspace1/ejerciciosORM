package Modelo;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class FuerzaMilitar {

     @Id
     @GeneratedValue
     private int Id;

     abstract void atacarA(Lugar lugar);
}
