package org.jsp.esop.controller;

import lombok.NoArgsConstructor;
import org.jsp.esop.dto.AppResponseDTO;
import org.jsp.esop.dto.GrantDTO;
import org.jsp.esop.service.GrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@Component
public class GrantController {

    GrantController() {
        System.out.println("GrantController has been created");
    }

    @Autowired
    private GrantService grantService;

    @RequestMapping(value = "/uploadGrants")
//  @GetMapping(value = "/uploadGrants")
    public  @ResponseBody AppResponseDTO processuploadGrant(@RequestBody List<GrantDTO> dtoList) {
        return grantService.processUploadGrant(dtoList);
    }

    @RequestMapping(value = "/getGrants")
    public AppResponseDTO getGrants() {
        return grantService.processGetGrants();
    }

    @RequestMapping("/getGrantbyId/{altKey}")
    public AppResponseDTO getGrantById(@PathVariable BigInteger altKey){
        return grantService.processGrantById(altKey);
    }

    @RequestMapping("/getGrantsByPlanId/{planId}")
    public AppResponseDTO getGrantsByPlanId(@PathVariable BigInteger planId){
        return grantService.processGrantsByPlanId(planId);
    }

    @GetMapping("/getGrantsByPlanId/{planId}/{grantStatus}/{allocationStatus}")
    public AppResponseDTO getGrantByPlanIdAndGrantStatusAndAllocationStatus(
            @PathVariable("planId") BigInteger planId,
            @PathVariable("grantStatus") String grantStatus,
            @PathVariable("allocationStatus") String allocationStatus)
    {
        return grantService.processgetGrantByPlanIdAndGrantStatusAndAllocationStatus(planId,grantStatus,allocationStatus);
    }

    @RequestMapping("/approvedGrant")
    public AppResponseDTO approvedGrant( @RequestBody  List<BigInteger> altKeyList){
        return grantService.processAcceptGrants(altKeyList);
    }

    @RequestMapping("/accessGrants")
    public AppResponseDTO accessGrants( @RequestBody  List<BigInteger> altKeyList){
        return grantService.processAcceptGrants(altKeyList);
    }


}
