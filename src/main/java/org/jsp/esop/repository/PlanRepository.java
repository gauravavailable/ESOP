package org.jsp.esop.repository;

import org.jsp.esop.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PlanRepository extends JpaRepository<PlanEntity, BigInteger> {

}
