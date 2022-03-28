package br.com.camaroti.alex.fluentvalidatorcoverage.validation;

import br.com.camaroti.alex.fluentvalidatorcoverage.model.Child;
import br.com.camaroti.alex.fluentvalidatorcoverage.model.Parent;
import br.com.fluentvalidator.AbstractValidator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Predicate.not;

public class ValidatorChild extends AbstractValidator<Child> {

    @Override
    public void rules() {

        setPropertyOnContext("child");

        ruleFor(Child::getAge)
                .must(not(nullValue()))
                .withMessage("child age must be not null")
                .withFieldName("age")
                .must(greaterThanOrEqual(5))
                .withMessage("child age must be greater than or equal to 5")
                .withFieldName("age")
                .must(this::checkAgeConstraintChild)
                .withMessage("child age must be less than age parent")
                .withFieldName("age")
                .critical();

        ruleFor(Child::getName)
                .must(not(stringEmptyOrNull()))
                .withMessage("child name must be not null or empty")
                .withFieldName("name");

    }

    private boolean checkAgeConstraintChild(final Integer age) {
        return age < getPropertyOnContext("parent", Parent.class).getAge();
    }

}
