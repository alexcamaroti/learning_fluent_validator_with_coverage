package br.com.camaroti.alex.fluentvalidatorcoverage.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Parent {

    private String name;
    private Integer age;
    private List<String> cities;
    private List<Child> children;
}