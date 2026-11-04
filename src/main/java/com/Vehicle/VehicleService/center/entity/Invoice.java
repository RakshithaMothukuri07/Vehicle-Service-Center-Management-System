
package com.Vehicle.VehicleService.center.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Invoice {

    public Invoice() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @NotBlank(message = "Invoice number is required")
    private String invoiceNumber;

    @NotNull(message = "Invoice date is required")
    private LocalDate invoiceDate;

    @PositiveOrZero(message = "Total amount cannot be negative")
    private double totalAmount;

    @NotBlank(message = "Payment status is required")
    private String paymentStatus;

    @NotNull(message = "Service request is required")
    @OneToOne
    @JoinColumn(name = "service_request_id", nullable = false)
    private ServiceRequest serviceRequest;

    public Invoice(String invoiceNumber, LocalDate invoiceDate,
            double totalAmount, String paymentStatus,
            ServiceRequest serviceRequest) {

        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.serviceRequest = serviceRequest;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }
}
