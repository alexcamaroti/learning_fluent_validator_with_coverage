package br.com.camaroti.alex.fluentvalidatorcoverage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Child {

    private String name;
    private Integer age;
}