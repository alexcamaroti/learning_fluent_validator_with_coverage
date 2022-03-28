package br.com.camaroti.alex.fluentvalidatorcoverage.model;

import lombok.Data;

@Data
public class Girl extends Child {

    private final Gender gender =  Gender.FEMALE;

    public Girl(String name, int age) {
        super(name, age);
    }
}
