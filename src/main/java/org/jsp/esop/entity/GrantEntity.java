package org.jsp.esop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsp.esop.dto.GrantDTO;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "grants_master")
@AllArgsConstructor
@NoArgsConstructor
public class GrantEntity {

    @Id
    @Column(name = "alt_Key")
    private BigInteger altkey;

    @Column(name = "emp_id")
    private BigInteger empId;

    @Column(name = "grant_number")
    private long grantNumber;

    @Column(name = "grant_price")
    private double grantPrice;

    //@Column(columnDefinition = "DEFAULT 'PENDING'")

    @Column(name = "grant_Status")
    private String grantStatus = "PENDING";

    @Column(name = "allocation_Status")
    private String allocationStatus = "PENDING";

    @Column(name = "is_accepted")
    private String isAccepted = "NO";

    @Column(name = "accepted_date")
    private Date acceptedDate;

    @Column(name = "grant_date")
    private Date grantDate;

    @Column(name = "frequency")
    private long frequency;

    @Column(name = "plan_id")
    private BigInteger planId;

    @Column(name = "created_date")
    private Date createdDate = new Date();

    @Column(name = "modifies_date")
    private Date modifiedDate;

    public GrantEntity(GrantDTO grantDTO) {
        this.empId = empId;
        this.grantNumber = grantNumber;
        this.grantPrice = grantPrice;
        this.frequency = frequency;
        this.planId = planId;
    }

}
