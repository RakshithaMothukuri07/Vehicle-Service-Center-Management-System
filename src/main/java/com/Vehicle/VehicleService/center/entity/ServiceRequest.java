
package com.Vehicle.VehicleService.center.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

@Entity
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceRequestId;

    @NotBlank(message = "Service type is required")
    private String serviceType;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Service date is required")
    @FutureOrPresent(message = "Service date cannot be in the past")
    private LocalDate serviceDate;

    @NotBlank(message = "Service status is required")
    private String status;

    @NotNull(message = "Vehicle is required")
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public ServiceRequest() {
    }

    public ServiceRequest(String serviceType, String description,
                         LocalDate serviceDate, String status,
                         Vehicle vehicle) {
        this.serviceType = serviceType;
        this.description = description;
        this.serviceDate = serviceDate;
        this.status = status;
        this.vehicle = vehicle;
    }

    public Long getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Long serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
