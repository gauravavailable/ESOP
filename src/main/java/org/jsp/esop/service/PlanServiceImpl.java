package org.jsp.esop.service;

import org.jsp.esop.dto.AppResponseDTO;
import org.jsp.esop.dto.PlanDTO;
import org.jsp.esop.entity.PlanEntity;
import org.jsp.esop.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public AppResponseDTO savePlan(PlanDTO planDto) {

        PlanEntity entity = new PlanEntity();
        entity.setAltkey(BigInteger.valueOf(ThreadLocalRandom.current().nextLong(5000, 99999)));
        entity.setStartdate(planDto.getStartDate());
        entity.setEnddate(planDto.getEndDate());
        entity.setCurrentPlan(planDto.isCurrentPlan());
        entity.setMonetizationDate(planDto.getMonetisationDate());
        entity.setVestingFactor(planDto.getVestingFactor());

        planRepository.save(entity);
        return new AppResponseDTO("200", null, "SUCCESS", entity);
    }

    @Override
    public AppResponseDTO currentActive() {
        return null;
    }
}
