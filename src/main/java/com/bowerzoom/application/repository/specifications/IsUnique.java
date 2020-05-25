package com.bowerzoom.application.repository.specifications;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.domain.Archer_;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class IsUnique implements Specification<Archer> {

    @NotNull
    String email;

    @Override
    public Predicate toPredicate(Root<Archer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(Archer_.EMAIL), email);
    }
}
