package com.bhagat.hritu.aurora.messages;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@ToString
public class Header implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3689172747486231608L;
    private String sourceId;
    private String sessionId;
    private String transactionId;
    private String requestId;
    private SenderVersion senderVersion;
    private ArrayList<Integer> _xFieldBitmask_;

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public SenderVersion getSenderVersion() {
        return this.senderVersion;
    }

    public void setSenderVersion(SenderVersion senderVersion) {
        this.senderVersion = senderVersion;
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
