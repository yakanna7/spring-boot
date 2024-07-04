package com.student.application.student_application.specification;

import com.student.application.student_application.entity.MyProduct;
import com.student.application.student_application.filters.ProductFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    public static Specification<MyProduct> getProductsByFilter(ProductFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getCategory() != null && !filter.getCategory().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("category"), filter.getCategory()));
            }

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + filter.getName() + "%"));
            }

            if (filter.getMinCost() != null && filter.getMaxCost() != null) {
                predicates.add(criteriaBuilder.between(root.get("cost"), filter.getMinCost(), filter.getMaxCost()));
            }

            if (filter.getColor() != null && !filter.getColor().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("color"), filter.getColor()));
            }

            if (filter.getModel() != null && !filter.getModel().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("model"), filter.getModel()));
            }

            if (filter.getRating() != null ) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), filter.getRating()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
