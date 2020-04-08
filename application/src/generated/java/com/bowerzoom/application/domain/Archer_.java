package com.bowerzoom.application.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Archer.class)
public abstract class Archer_ extends com.bowerzoom.application.domain.BaseEntity_ {

	public static volatile SingularAttribute<Archer, Gender> gender;
	public static volatile SingularAttribute<Archer, String> name;
	public static volatile SingularAttribute<Archer, Instant> birthDate;
	public static volatile SingularAttribute<Archer, String> email;

	public static final String GENDER = "gender";
	public static final String NAME = "name";
	public static final String BIRTH_DATE = "birthDate";
	public static final String EMAIL = "email";

}

