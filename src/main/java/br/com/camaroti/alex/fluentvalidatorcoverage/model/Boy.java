package br.com.camaroti.alex.fluentvalidatorcoverage.model;

import lombok.Data;

@Data
public class Boy extends Child {

    private final Gender gender =  Gender.MALE;

    public Boy(String name, int age) {
        super(name, age);
    }
}
