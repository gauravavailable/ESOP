package org.jsp.esop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "plan_master")
public class PlanEntity {
    @Id
    @Column(name = "alt_Key")
    private BigInteger altkey;

    @Column(name = "start_date")
    private Date startdate;

    @Column(name = "end_date")
    private Date enddate;

    @Column(name = "isCurrent_Plan")
    private boolean isCurrentPlan;

    @Column(name = "vesting_Factor")
    private Double vestingFactor;

    @Column(name = "monetization_Date")
    private Date monetizationDate;
}
