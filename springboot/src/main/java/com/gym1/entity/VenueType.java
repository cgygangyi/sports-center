package com.gym1.entity;
import java.util.Arrays;



public class VenueType {

    private int id;
    private String introduction;
    private String typeName;
    private byte[] image;

    public VenueType(){

    }

    public VenueType(String introduction, String typeName){
        this.introduction = introduction;
        this.typeName = typeName;
    }
    public VenueType(int id, String introduction, String type){
        this.id = id;
        this.typeName = type;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setTypeName(String type) {
        this.typeName = type;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VenueType)) return false;
        VenueType venueType = (VenueType) o;
        if (getId() != venueType.getId()) return false;
        if (getIntroduction() != null ? !getIntroduction().equals(venueType.getIntroduction()) : venueType.getIntroduction() != null)
            return false;
        if (getTypeName() != null ? !getTypeName().equals(venueType.getTypeName()) : venueType.getTypeName() != null) return false;
        return Arrays.equals(getImage(), venueType.getImage());
    }
    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getIntroduction() != null ? getIntroduction().hashCode() : 0);
        result = 31 * result + (getTypeName() != null ? getTypeName().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }
    @Override
    public String toString() {
        return "VenueType{" +
                "id=" + id +
                ", introduction='" + introduction + '\'' +
                ", type='" + typeName + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
