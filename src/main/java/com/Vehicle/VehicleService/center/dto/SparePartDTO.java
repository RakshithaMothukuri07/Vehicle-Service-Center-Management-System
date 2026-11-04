
package com.Vehicle.VehicleService.center.dto;

public class SparePartDTO {

    private Long partId;
    private String partName;
    private String partNumber;
    private String brand;
    private double price;
    private int quantity;

    public SparePartDTO() {
    }

    public SparePartDTO(Long partId, String partName,
            String partNumber, String brand,
            double price, int quantity) {

        this.partId = partId;
        this.partName = partName;
        this.partNumber = partNumber;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
