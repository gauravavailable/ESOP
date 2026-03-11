package org.jsp.esop.service;

import org.jsp.esop.dto.AppResponseDTO;
import org.jsp.esop.dto.GrantDTO;
import java.math.BigInteger;
import java.util.List;

public interface GrantService {

    AppResponseDTO processUploadGrant(List<GrantDTO> grantDTOList);

    AppResponseDTO processGetGrants();

    AppResponseDTO processGrantById(BigInteger altkey);

    AppResponseDTO processGrantsByPlanId(BigInteger planId);

    AppResponseDTO processAcceptGrants(List<BigInteger> altKeyList);

    AppResponseDTO processAccessGrants(List<BigInteger> altKeyList);

    AppResponseDTO processgetGrantByPlanIdAndGrantStatusAndAllocationStatus(
            BigInteger planId,
            String grantStatus,
            String allocationStatus
    );



}
