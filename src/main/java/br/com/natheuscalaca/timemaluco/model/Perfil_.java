package br.com.natheuscalaca.timemaluco.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perfil.class)
public abstract class Perfil_ extends io.quarkus.hibernate.orm.panache.PanacheEntity_ {

	public static volatile SingularAttribute<Perfil, String> cor;
	public static volatile SingularAttribute<Perfil, String> nome;

	public static final String COR = "cor";
	public static final String NOME = "nome";

}

