package com.bhagat.hritu.aurora.messages;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder({"xRogType","header","prices","_xFieldBitmask_"})
@ToString
public class GetRoomPricingAndAvailabilityResponse implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4315080587343624681L;
    
    private int xRogType;
    private Header header;
    private RoomPrice[] prices;
    private ArrayList<Integer> _xFieldBitmask_;

    @JsonProperty("xRogType")
    public int getXRogType() {
        return this.xRogType;
    }
    
    @JsonProperty("xRogType")
    public void setXRogType(int xRogType) {
        this.xRogType = xRogType;
    }

    public Header getHeader() {
        return this.header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public RoomPrice[] getPrices() {
        return this.prices;
    }

    public void setPrices(RoomPrice[] prices) {
        this.prices = prices;
    }
    
    @JsonProperty("_xFieldBitmask_")
    public ArrayList<Integer> getXFieldBitmask() {
        return this._xFieldBitmask_;
    }
    
    @JsonProperty("_xFieldBitmask_")
    public void setXFieldBitmask(ArrayList<Integer> _xFieldBitmask_) {
        this._xFieldBitmask_ = _xFieldBitmask_;
    }
    
//    public String toString(){
//        return "Hello response";
//    }
}
