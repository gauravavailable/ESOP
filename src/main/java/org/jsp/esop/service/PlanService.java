package org.jsp.esop.service;

import org.jsp.esop.dto.AppResponseDTO;
import org.jsp.esop.dto.PlanDTO;

public interface PlanService {



    AppResponseDTO savePlan(PlanDTO planDto);

    AppResponseDTO currentActive();
}
