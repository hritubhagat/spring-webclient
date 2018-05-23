package com.bhagat.hritu.aurora.messages;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_EMPTY)
public class RoomPrice implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4965830419500106102L;
    private Date date;
    private double basePrice;
    private double customerPrice;
    private double price;
    private boolean isComp;
    private boolean isCTA;
    private int points;
    private int basePoints;
    private double memberBasePrice;
    private double memberPrice;
    private int memberBasePoints;
    private int memberPoints;
    private String propertyId;
    private String roomType;
    private String programId;
    private String pricingRuleId;
    private String memberProgramId;
    private String unavailabilityReason;
    private ArrayList<Integer> _xFieldBitmask_;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    
    public int getMemberBasePoints() {
        return memberBasePoints;
    }

    public void setMemberBasePoints(int memberBasePoints) {
        this.memberBasePoints = memberBasePoints;
    }

    public int getMemberPoints() {
        return memberPoints;
    }

    public void setMemberPoints(int memberPoints) {
        this.memberPoints = memberPoints;
    }

    public double getCustomerPrice() {
        return this.customerPrice;
    }

    public void setCustomerPrice(double customerPrice) {
        this.customerPrice = customerPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsComp() {
        return this.isComp;
    }

    public void setIsComp(boolean isComp) {
        this.isComp = isComp;
    }

    private boolean programIdIsRateTable;

    public boolean getProgramIdIsRateTable() {
        return this.programIdIsRateTable;
    }

    public void setProgramIdIsRateTable(boolean programIdIsRateTable) {
        this.programIdIsRateTable = programIdIsRateTable;
    }

    public boolean getIsCTA() {
        return this.isCTA;
    }

    public void setIsCTA(boolean isCTA) {
        this.isCTA = isCTA;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getBasePoints() {
        return this.basePoints;
    }

    public void setBasePoints(int basePoints) {
        this.basePoints = basePoints;
    }

    public double getMemberPrice() {
        return this.memberPrice;
    }

    public void setMemberPrice(double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public double getMemberBasePrice() {
        return this.memberBasePrice;
    }

    public void setMemberBasePrice(double memberBasePrice) {
        this.memberBasePrice = memberBasePrice;
    }

    public String getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getProgramId() {
        return this.programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getPricingRuleId() {
        return this.pricingRuleId;
    }

    public void setPricingRuleId(String pricingRuleId) {
        this.pricingRuleId = pricingRuleId;
    }

    public String getMemberProgramId() {
        return this.memberProgramId;
    }

    public void setMemberProgramId(String memberProgramId) {
        this.memberProgramId = memberProgramId;
    }
    
    public String getUnavailabilityReason() {
        return unavailabilityReason;
    }

    public void setUnavailabilityReason(String unavailabilityReason) {
        this.unavailabilityReason = unavailabilityReason;
    }

    @JsonProperty("_xFieldBitmask_")
    public ArrayList<Integer> getXFieldBitmask() {
        return this._xFieldBitmask_;
    }
    
    @JsonProperty("_xFieldBitmask_")
    public void setXFieldBitmask(ArrayList<Integer> _xFieldBitmask_) {
        this._xFieldBitmask_ = _xFieldBitmask_;
    }
    
    public final String toString()
    {
      DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS");
      dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      StringBuilder builder = new StringBuilder();
      builder.append("{");
      builder.append("Date=").append(getDate() == null ? "null" : dateFormat.format(getDate()));
      builder.append(",");
      builder.append("BasePrice=").append(getBasePrice());
      builder.append(",");
      builder.append("CustomerPrice=").append(getCustomerPrice());
      builder.append(",");
      builder.append("Price=").append(getPrice());
      builder.append(",");
      builder.append("IsComp=").append(getIsComp());
      builder.append(",");
      builder.append("ProgramIdIsRateTable=").append(getProgramIdIsRateTable());
      builder.append(",");
      builder.append("UnavailabilityReason=").append(getUnavailabilityReason());
      builder.append(",");
      builder.append("IsCTA=").append(getIsCTA());
      builder.append(",");
      builder.append("Points=").append(getPoints());
      builder.append(",");
      builder.append("BasePoints=").append(getBasePoints());
      builder.append(",");
      builder.append("MemberPrice=").append(getMemberPrice());
      builder.append(",");
      builder.append("MemberBasePrice=").append(getMemberBasePrice());
      builder.append(",");
      builder.append("MemberPoints=").append(getMemberPoints());
      builder.append(",");
      builder.append("MemberBasePoints=").append(getMemberBasePoints());
      builder.append(",");
      builder.append("PropertyId=").append(getPropertyId());
      builder.append(",");
      builder.append("RoomType=").append(getRoomType());
      builder.append(",");
      builder.append("ProgramId=").append(getProgramId());
      builder.append(",");
      builder.append("PricingRuleId=").append(getPricingRuleId());
      builder.append(",");
      builder.append("MemberProgramId=").append(getMemberProgramId());
      builder.append("}");
      return builder.toString();
    }
}
