package com.bhagat.hritu.aurora.messages;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class SenderVersion implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 718036096463054194L;
    private int majorVersion;
    private int minorVersion;
    private ArrayList<Integer> _xFieldBitmask_;

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    @JsonProperty("_xFieldBitmask_")
    public ArrayList<Integer> getXFieldBitmask() {
        return this._xFieldBitmask_;
    }
    @JsonProperty("_xFieldBitmask_")
    public void setXFieldBitmask(ArrayList<Integer> _xFieldBitmask_) {
        this._xFieldBitmask_ = _xFieldBitmask_;
    }
}
