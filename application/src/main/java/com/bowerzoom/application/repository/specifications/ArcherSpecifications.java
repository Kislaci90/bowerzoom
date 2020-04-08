package com.bowerzoom.application.repository.specifications;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.domain.Archer_;
import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import org.springframework.data.jpa.domain.Specification;

public class ArcherSpecifications {

    public static Specification<Archer> isUnique(ArcherFilterCmd archerFilterCmd) {
        return (root, query, cb) -> cb.equal(root.get(Archer_.EMAIL), archerFilterCmd.email());
    }
}
