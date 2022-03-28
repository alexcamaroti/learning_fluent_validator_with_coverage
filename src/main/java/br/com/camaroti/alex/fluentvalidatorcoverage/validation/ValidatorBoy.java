package br.com.camaroti.alex.fluentvalidatorcoverage.validation;

import br.com.camaroti.alex.fluentvalidatorcoverage.model.Boy;
import br.com.camaroti.alex.fluentvalidatorcoverage.model.Gender;
import br.com.fluentvalidator.AbstractValidator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.equalTo;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringContains;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Predicate.not;

public class ValidatorBoy extends AbstractValidator<Boy> {

    @Override
    public void rules() {

        ruleFor(Boy::getGender)
                .must(equalTo(Gender.MALE))
                .when(not(nullValue()))
                .withMessage("gender of boy must be MALE")
                .withFieldName("gender")
                .critical();

        ruleFor(Boy::getName)
                .must(stringContains("John"))
                .when(not(stringEmptyOrNull()))
                .withMessage("child name must contains key John")
                .withFieldName("name");
    }

}
