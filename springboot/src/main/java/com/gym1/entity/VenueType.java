package com.gym1.entity;

public class VenueType {

    private int id;
    private double price;
    private String address;
    private String introduction;
    private String type;

    public VenueType(int id, double price, String address, String introduction, String type){
        this.id = id;
        this.price = price;
        this.address = address;
        this.type = type;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getIntroduction() {
        return introduction;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VenueType)) return false;

        VenueType venueType = (VenueType) o;

        if (getId() != venueType.getId()) return false;
        if (Double.compare(venueType.getPrice(), getPrice()) != 0) return false;
        if (getAddress() != null ? !getAddress().equals(venueType.getAddress()) : venueType.getAddress() != null)
            return false;
        if (getIntroduction() != null ? !getIntroduction().equals(venueType.getIntroduction()) : venueType.getIntroduction() != null)
            return false;
        return getType() != null ? getType().equals(venueType.getType()) : venueType.getType() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getIntroduction() != null ? getIntroduction().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "VenueType{" +
                "id=" + id +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
