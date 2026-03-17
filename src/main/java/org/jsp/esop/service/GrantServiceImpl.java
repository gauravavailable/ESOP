package org.jsp.esop.service;

import lombok.RequiredArgsConstructor;
import org.jsp.esop.dto.AppResponseDTO;
import org.jsp.esop.dto.GrantDTO;
import org.jsp.esop.entity.GrantEntity;
import org.jsp.esop.repository.GrantRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrantServiceImpl implements GrantService {

    private final GrantRepository grantRepository;

    @Override
    public AppResponseDTO processUploadGrant(List<GrantDTO> grantDTOList) {
        AppResponseDTO appResponseDTO = null;
        try {
            List<GrantEntity> grantEntityList =
                    grantDTOList.stream()
                            .map(GrantEntity::new)
                            .collect(Collectors.toList());
            grantEntityList = grantRepository.saveAll(grantEntityList);
            appResponseDTO = new AppResponseDTO("200", "SUCCESS", null, grantEntityList);
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("200", "ERROE", exception.getMessage(), null);
        }
        return appResponseDTO;
    }

    @Override
    public AppResponseDTO processGetGrants() {
        AppResponseDTO appResponseDTO = null;
        try {
            List<GrantEntity> grantEntityList=
                    grantRepository.findAll();
            grantEntityList = grantRepository.saveAll(grantEntityList);
            appResponseDTO = new AppResponseDTO("200",null,"SUCCESS",grantEntityList);
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("500", "ERROE", exception.getMessage(), null);
        }
        return appResponseDTO;
    }

    @Override
    public AppResponseDTO processGrantById(BigInteger altkey) {
        AppResponseDTO appResponseDTO = null;
        try {
            Optional<GrantEntity> grantEntityOptional=
                    grantRepository.findById(altkey);
            appResponseDTO = new AppResponseDTO("200", "SUCCESS", null, grantEntityOptional.get());
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("200", "ERROR", exception.getMessage(), null);
        }
        return appResponseDTO;
    }

    @Override
    public AppResponseDTO processGrantsByPlanId(BigInteger planId) {
        AppResponseDTO appResponseDTO = null;
        try {
            List<GrantEntity> grantEntityList=
                    grantRepository.getGrantsByPlanId(planId);
            appResponseDTO = new AppResponseDTO("200", "SUCCESS", null, grantEntityList);
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("500", "ERROR", exception.getMessage(), null);
        }
        return appResponseDTO;
    }



    @Override
    public AppResponseDTO processAcceptGrants(List<BigInteger> altKeyList) {
        AppResponseDTO appResponseDTO = null;
        try {
            List<GrantEntity> grantEntityList =
                    grantRepository.processAcceptGrants("APPROVED",new Date(), altKeyList);
            appResponseDTO = new AppResponseDTO("200", "SUCCESS", null, null);
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("500", "ERROR", exception.getMessage(), null);
        }
        return appResponseDTO;
    }

    @Override
    public AppResponseDTO processAccessGrants(List<BigInteger> altKeyList) {
        AppResponseDTO appResponseDTO = null;
        try {

            List<GrantEntity> grantEntityList =
                    grantRepository.processAcceptGrants("yes",new Date(),altKeyList);
            appResponseDTO = new AppResponseDTO("200", "SUCCESS", null, null);
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("500", "ERROR", exception.getMessage(), null);
        }
        return appResponseDTO;
    }



    @Override
    public AppResponseDTO processgetGrantByPlanIdAndGrantStatusAndAllocationStatus(BigInteger planId, String grantStatus, String allocationStatus) {
        AppResponseDTO appResponseDTO = null;
        try {
            List<GrantEntity> grantEntityList =
                    grantRepository.processgetGrantByPlanIdAndGrantStatusAndAllocationStatus(grantStatus, planId, allocationStatus);
            appResponseDTO = new AppResponseDTO("200", "SUCCESS", null, grantEntityList);
        } catch (Exception exception) {
            appResponseDTO = new AppResponseDTO("500", "ERROR", exception.getMessage(), null);
        }
        return appResponseDTO;
    }
}
