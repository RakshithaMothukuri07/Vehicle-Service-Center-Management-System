
package com.Vehicle.VehicleService.center.dto;

import java.time.LocalDate;

public class InvoiceDTO {

    private Long invoiceId;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private double totalAmount;
    private String paymentStatus;
    private Long serviceRequestId;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long invoiceId, String invoiceNumber,
            LocalDate invoiceDate, double totalAmount,
            String paymentStatus, Long serviceRequestId) {

        this.invoiceId = invoiceId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.serviceRequestId = serviceRequestId;
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

    public Long getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Long serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }
}
