package br.com.camaroti.alex.fluentvalidatorcoverage.validation;

import br.com.camaroti.alex.fluentvalidatorcoverage.model.Girl;
import br.com.camaroti.alex.fluentvalidatorcoverage.model.Parent;
import br.com.fluentvalidator.context.ValidationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorParentTest {

    private  ValidatorParent validatorParent = new ValidatorParent();

    private Parent parent;

    @BeforeEach
    public void setUp(){
    parent = Parent.builder()
            .age(10)
            .name("Ana")
            .cities(Arrays.asList("c0", "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"))
            .children(Arrays.asList(new Girl("Barbara", 4)))
            .build();
    }


    @Test
    public void validationMustBeFalseWhenParentAndChildrenIsInvalid() {
        ValidationResult result = validatorParent.validate(parent);
        assertFalse(result.isValid());
//        assertThat(result.getErrors(), not(empty()));
//        assertThat(result.getErrors(), hasSize(4));
//
//        assertThat(result.getErrors(), hasItem(hasProperty("field", containsString("name"))));
//        assertThat(result.getErrors(), hasItem(hasProperty("attemptedValue", containsString("Ana"))));
//        assertThat(result.getErrors(), hasItem(hasProperty("message", containsString("name must contains key John"))));
//        assertThat(result.getErrors(), hasItem(hasProperty("code", nullValue())));
    }
}
