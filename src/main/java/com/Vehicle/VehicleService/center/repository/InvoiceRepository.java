package com.Vehicle.VehicleService.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Vehicle.VehicleService.center.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}