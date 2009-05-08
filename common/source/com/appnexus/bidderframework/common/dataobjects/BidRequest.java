package com.appnexus.bidderframework.common.dataobjects;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 2:43:55 PM
 * 
 */
public class BidRequest {
    private Date timestamp;
    private List<Member> members;
    private boolean allowExclusive;
    private boolean debugRequested;
    private List<Tag> tags;
    private Bid bid;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public boolean isAllowExclusive() {
        return allowExclusive;
    }

    public void setAllowExclusive(boolean allowExclusive) {
        this.allowExclusive = allowExclusive;
    }

    public boolean isDebugRequested() {
        return debugRequested;
    }

    public void setDebugRequested(boolean debugRequested) {
        this.debugRequested = debugRequested;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "BidRequest{" +
                "timestamp=" + timestamp +
                ", members=" + members +
                ", allowExclusive=" + allowExclusive +
                ", debugRequested=" + debugRequested +
                ", tags=" + tags +
                ", bid=" + bid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BidRequest)) return false;

        BidRequest that = (BidRequest) o;

        if (allowExclusive != that.allowExclusive) return false;
        if (debugRequested != that.debugRequested) return false;
        if (bid != null ? !bid.equals(that.bid) : that.bid != null) return false;
        if (members != null ? !members.equals(that.members) : that.members != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = members != null ? members.hashCode() : 0;
        result = 31 * result + (allowExclusive ? 1 : 0);
        result = 31 * result + (debugRequested ? 1 : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (bid != null ? bid.hashCode() : 0);
        return result;
    }
}
