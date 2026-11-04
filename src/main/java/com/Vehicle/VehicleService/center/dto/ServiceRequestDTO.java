package com.Vehicle.VehicleService.center.dto;

import java.time.LocalDate;

public class ServiceRequestDTO {

    private Long serviceRequestId;
    private String serviceType;
    private String description;
    private LocalDate serviceDate;
    private String status;
    private Long vehicleId;

    public ServiceRequestDTO() {
    }

    public ServiceRequestDTO(Long serviceRequestId,
            String serviceType, String description,
            LocalDate serviceDate, String status,
            Long vehicleId) {

        this.serviceRequestId = serviceRequestId;
        this.serviceType = serviceType;
        this.description = description;
        this.serviceDate = serviceDate;
        this.status = status;
        this.vehicleId = vehicleId;
    }

    // Getters and Setters

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

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
