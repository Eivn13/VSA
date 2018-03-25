package entities;

import entities.Kniha;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T08:25:13")
@StaticMetamodel(Osoba.class)
public class Osoba_ { 

    public static volatile ListAttribute<Osoba, Kniha> dielo;
    public static volatile SingularAttribute<Osoba, String> meno;
    public static volatile SingularAttribute<Osoba, Long> id;

}