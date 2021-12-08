package com.example.assignment8.Specification;

import com.example.assignment8.entity.Account;
import com.example.assignment8.entity.Address;
import com.example.assignment8.entity.Department;
import javafx.util.Builder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Date;

public class DepartmentSpecification implements Specification<Department> {
    private static final long serialVersionUID = 1L;

    private String field;
    private String operator;
    private Object value;

    public DepartmentSpecification(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }


    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (operator.equalsIgnoreCase("LIKE")) {
            if (field.equalsIgnoreCase("author.fullName")) {
                return builder.like(root.get("author").get("fullName"), "%" + value.toString() + "%");
            } else {
                return builder.like(root.get(field), "%" + value.toString() + "%");
            }
        }
        if (operator.equalsIgnoreCase("address")){
            Join<Department, Address> joinAddress = root.join("addressId", JoinType.LEFT);
            return builder.like(joinAddress.get("name"), "%" + value.toString() + "%");
        }
        if (operator.equalsIgnoreCase("author")){
               Join<Department, Account> joinAccount = root.join("author", JoinType.LEFT);
            return builder.like(joinAccount.get("userName"), "%" + value.toString() + "%");
        }
        if (operator.equalsIgnoreCase(">=")){
            if (value instanceof Date) {
                Date today1 = (Date) value;
                Date tomorrow1 = new Date(today1.getTime() + (1000*60*60*24));
                return builder.greaterThanOrEqualTo(root.get(field), (Date)value);
            }
        }
        if (operator.equalsIgnoreCase("<=")){
            if (value instanceof Date){
                Date today = (Date) value;
                Date tomorrow = new Date(today.getTime() + (1000*60*60*24));
                return builder.lessThan(root.get(field), tomorrow);
            }
        }
        return null;
    }


}
