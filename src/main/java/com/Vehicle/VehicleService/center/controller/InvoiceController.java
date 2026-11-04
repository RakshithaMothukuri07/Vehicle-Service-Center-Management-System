package com.Vehicle.VehicleService.center.controller;

import java.util.List;
import jakarta.validation.Valid;
import com.Vehicle.VehicleService.center.dto.InvoiceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vehicle.VehicleService.center.entity.Invoice;
import com.Vehicle.VehicleService.center.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @PostMapping
    public ResponseEntity<InvoiceDTO> addInvoice(
    		@Valid @RequestBody Invoice invoice) {

        Invoice savedInvoice = invoiceService.saveInvoice(invoice);

        InvoiceDTO invoiceDTO =
                invoiceService.convertToDTO(savedInvoice);

        return ResponseEntity.status(201).body(invoiceDTO);
    }


@GetMapping
public List<InvoiceDTO> getAllInvoices() {

    List<Invoice> invoices = invoiceService.getAllInvoices();

    return invoices.stream()
            .map(invoice -> invoiceService.convertToDTO(invoice))
            .toList();
}


    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {

        Invoice invoice = invoiceService.getInvoiceById(id);

        if (invoice == null) {
            return ResponseEntity.notFound().build();
        }

        InvoiceDTO invoiceDTO = invoiceService.convertToDTO(invoice);

        return ResponseEntity.ok(invoiceDTO);
    }


@PutMapping("/{id}")
public ResponseEntity<InvoiceDTO> updateInvoice(
        @PathVariable Long id,
        @Valid @RequestBody Invoice updatedInvoice) {

    Invoice invoice = invoiceService.updateInvoice(id, updatedInvoice);

    if (invoice == null) {
        return ResponseEntity.notFound().build();
    }

    InvoiceDTO invoiceDTO = invoiceService.convertToDTO(invoice);

    return ResponseEntity.ok(invoiceDTO);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}