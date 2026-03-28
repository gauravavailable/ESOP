package org.jsp.esop.controller;

import org.jsp.esop.dto.AppResponseDTO;
import org.jsp.esop.dto.PlanDTO;
import org.jsp.esop.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class PlanController {

    public PlanController() {
        System.out.println("PlanController has been created");
    }

    @Autowired
    private PlanService planService;

    @PostMapping(value = "/savePlan")
    public @ResponseBody AppResponseDTO savePlan(@RequestBody PlanDTO planDTO){
        return planService.savePlan(planDTO);
    }

    @PostMapping(value = "/get")
    public PlanService getPlanService () {
        return planService;
    }

}
