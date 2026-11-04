
package com.Vehicle.VehicleService.center.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @NotBlank(message = "Part name is required")
    private String partName;

    @NotBlank(message = "Part number is required")
    private String partNumber;

    @NotBlank(message = "Brand is required")
    private String brand;

    @PositiveOrZero(message = "Price cannot be negative")
    private double price;

    @PositiveOrZero(message = "Quantity cannot be negative")
    private int quantity;

    public SparePart() {
    }

    public SparePart(String partName, String partNumber,
                     String brand, double price, int quantity) {
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
