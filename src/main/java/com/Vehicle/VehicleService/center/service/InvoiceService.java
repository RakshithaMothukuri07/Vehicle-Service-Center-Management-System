package com.Vehicle.VehicleService.center.service;

import java.util.List;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
import com.Vehicle.VehicleService.center.dto.InvoiceDTO;
import com.Vehicle.VehicleService.center.entity.Invoice;
import com.Vehicle.VehicleService.center.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {

        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Invoice not found with ID: " + id));
    }
    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {

        Invoice existingInvoice =
                invoiceRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Invoice not found with ID: " + id));

        existingInvoice.setInvoiceNumber(updatedInvoice.getInvoiceNumber());
        existingInvoice.setInvoiceDate(updatedInvoice.getInvoiceDate());
        existingInvoice.setTotalAmount(updatedInvoice.getTotalAmount());
        existingInvoice.setPaymentStatus(updatedInvoice.getPaymentStatus());

        return invoiceRepository.save(existingInvoice);
    }

    public void deleteInvoice(Long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Invoice not found with ID: " + id));

        invoiceRepository.delete(invoice);
    }
    public InvoiceDTO convertToDTO(Invoice invoice) {

        return new InvoiceDTO(
            invoice.getInvoiceId(),
            invoice.getInvoiceNumber(),
            invoice.getInvoiceDate(),
            invoice.getTotalAmount(),
            invoice.getPaymentStatus(),
            invoice.getServiceRequest().getServiceRequestId()
        );
    }
}