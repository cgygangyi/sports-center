package com.gym1.entity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;



public class Item {

    private int id;
    private String itemName;
    private double price;
    private String info;
    private byte[] image;

    public Item(String itemName, double price, String info, byte[] image){
        this.itemName = itemName;
        this.price = price;
        this.info = info;
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return itemName;
    }
    public void setName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
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
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        if (getId() != item.getId()) return false;
        if (Double.compare(item.getPrice(), getPrice()) != 0) return false;
        if (getName() != null ? !getName().equals(item.getName()) : item.getName() != null) return false;
        if (getInfo() != null ? !getInfo().equals(item.getInfo()) : item.getInfo() != null) return false;
        return Arrays.equals(getImage(), item.getImage());
    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + itemName + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
