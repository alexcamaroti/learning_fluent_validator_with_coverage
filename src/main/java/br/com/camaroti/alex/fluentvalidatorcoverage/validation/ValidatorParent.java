package br.com.camaroti.alex.fluentvalidatorcoverage.validation;

import br.com.camaroti.alex.fluentvalidatorcoverage.model.Boy;
import br.com.camaroti.alex.fluentvalidatorcoverage.model.Child;
import br.com.camaroti.alex.fluentvalidatorcoverage.model.Girl;
import br.com.camaroti.alex.fluentvalidatorcoverage.model.Parent;
import br.com.fluentvalidator.AbstractValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.fluentvalidator.predicate.CollectionPredicate.empty;
import static br.com.fluentvalidator.predicate.CollectionPredicate.hasSize;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;
import static br.com.fluentvalidator.predicate.ComparablePredicate.lessThanOrEqual;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringContains;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Predicate.not;

public class ValidatorParent extends AbstractValidator<Parent> {

    @Override
    public void rules() {

        setPropertyOnContext("parent");

        ruleForEach(Parent::getChildren)
                .must(not(nullValue()))
                .withMessage("parent's children cannot be null")
                .withCode("555")
                .withFieldName("children")
                .must(not(empty()))
                .when(not(nullValue()))
                .withMessage("parent must have at least one child")
                .withFieldName("children")
                .whenever(not(nullValue()))
                .withValidator(new ValidatorChild())
                .critical();

//        ruleFor(Parent::getId)
//                .whenever(isTrue())
//                .withValidator(new ValidatorId())
//                .critical();

        ruleFor(Parent::getAge)
                .must(greaterThanOrEqual(5))
                .when(not(nullValue()))
                .withMessage("age must be greater than or equal to 10")
                .withFieldName("age")
                .must(lessThanOrEqual(7))
                .when(not(nullValue()))
                .withMessage("age must be less than or equal to 7")
                .withCode("666")
                .withFieldName("age");

        ruleFor(Parent::getCities)
                .must(hasSize(10))
                .when(not(nullValue()))
                .withMessage("cities size must be 10")
                .withFieldName("cities");

        ruleFor(Parent::getName)
                .must(stringContains("John"))
                .when(not(stringEmptyOrNull()))
                .withMessage("name must contains key John")
                .withFieldName("name");

//        ruleForEach(parent -> extractGirls(parent.getChildren()))
//                .whenever(not(nullValue()))
//                .withValidator(new ValidatorGirl());

        ruleForEach(parent -> extractBoys(parent.getChildren()))
                .whenever(not(nullValue()))
                .withValidator(new ValidatorBoy())
                .critical();

    }

    private Collection<Girl> extractGirls(Collection<Child> children) {
        return Optional.ofNullable(children).orElseGet(ArrayList::new)
                .stream()
                .filter(Girl.class::isInstance)
                .map(Girl.class::cast)
                .collect(Collectors.toList());
    }

    private Collection<Boy> extractBoys(Collection<Child> children) {
        return Optional.ofNullable(children).orElseGet(ArrayList::new)
                .stream()
                .filter(Boy.class::isInstance)
                .map(Boy.class::cast)
                .collect(Collectors.toList());
    }

}
