package org.example.springecommerce.generator;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,  ElementType.FIELD})
@IdGeneratorType(OrderIdGenerator.class)
public @interface OrderIdGen {

}
