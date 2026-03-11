package org.jsp.esop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class GrantDTO {
    private BigInteger Altkey;
    private BigInteger empId;
    private long grantNumber;
    private double grantPrice;
    private long frequency;
    private BigInteger planId;

}
