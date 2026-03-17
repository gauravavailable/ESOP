package org.jsp.esop.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PlanDTO {

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getMonetisationDate() {
        return monetisationDate;
    }

    public void setMonetisationDate(Date monetisationDate) {
        this.monetisationDate = monetisationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getVestingFactor() {
        return vestingFactor;
    }

    public void setVestingFactor(double vestingFactor) {
        this.vestingFactor = vestingFactor;
    }

    private Date startDate;
    private Date endDate;
    private boolean isCurrentPlan;
    private double vestingFactor;

    public boolean isCurrentPlan() {
        return isCurrentPlan;
    }

    public void setCurrentPlan(boolean currentPlan) {
        isCurrentPlan = currentPlan;
    }

    private Date monetisationDate;
}

