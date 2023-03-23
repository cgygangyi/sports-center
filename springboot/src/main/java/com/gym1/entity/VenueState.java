package com.gym1.entity;

import java.util.Date;

public class VenueState {

    private int id;
    private int venueId;
    private Date begin;
    private Date end;

    public VenueState(int venueId, Date begin, Date end){
        this.venueId = venueId;
        this.begin = begin;
        this.end = end;
    }
    public VenueState(int id, int venueId, Date begin, Date end){
        this.id = id;
        this.venueId = venueId;
        this.begin = begin;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VenueState)) return false;

        VenueState that = (VenueState) o;

        if (getId() != that.getId()) return false;
        if (getVenueId() != that.getVenueId()) return false;
        if (getBegin() != null ? !getBegin().equals(that.getBegin()) : that.getBegin() != null) return false;
        return getEnd() != null ? getEnd().equals(that.getEnd()) : that.getEnd() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getVenueId();
        result = 31 * result + (getBegin() != null ? getBegin().hashCode() : 0);
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VenueState{" +
                "id=" + id +
                ", venueId=" + venueId +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
