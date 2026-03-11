package org.jsp.esop.repository;

import org.jsp.esop.entity.GrantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface GrantRepository extends JpaRepository<GrantEntity, BigInteger> {

    @Query(value = "from GrantEntity where planId=:planId")
    List<GrantEntity> getGrantsByPlanId(BigInteger planID);

    @Query(value = "from GrantEntity where planId=:planId and grantStatus=:grantstatus and allocationStatus=:allocationstatus")
    List<GrantEntity> processgetGrantByPlanIdAndGrantStatusAndAllocationStatus(
            @Param("grantstatus") String grantStatus,
            @Param("planId") BigInteger planId,
            @Param("allocationstatus") String allocationStatus
    );

    @Modifying
    @Transactional
    @Query(value = "Update GrantEntity set grantStatus =:grantStatus , grantDate =:grantDate where altkey in :altKeyList")
    List<GrantEntity> processAcceptGrants(String grantStatus, Date grantDate, List<BigInteger> altKeyList);

    @Modifying
    @Transactional
    @Query(value = "Update GrantEntity set isAccepted =: isAccepted ,acceptedDate =: acceptedDate where altkey in :altKeyList")
    List<GrantEntity> updateIsAcceptedByAltKey(String isAccepted, Date acceptedDate, List<BigInteger> altKeyList);

}
