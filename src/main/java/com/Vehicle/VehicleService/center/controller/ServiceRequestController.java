
package com.Vehicle.VehicleService.center.controller;

import java.util.List;
import jakarta.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vehicle.VehicleService.center.dto.ServiceRequestDTO;
import com.Vehicle.VehicleService.center.entity.ServiceRequest;
import com.Vehicle.VehicleService.center.service.ServiceRequestService;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    public ServiceRequestController(
            ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @PostMapping
    public ResponseEntity<ServiceRequestDTO> saveServiceRequest(
            @RequestBody ServiceRequest serviceRequest) {

        ServiceRequest savedRequest =
                serviceRequestService.saveServiceRequest(serviceRequest);

        ServiceRequestDTO dto =
                serviceRequestService.convertToDTO(savedRequest);

        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequestDTO>> getAllServiceRequests() {

        List<ServiceRequestDTO> requests =
                serviceRequestService.getAllServiceRequests();

        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequestDTO> getServiceRequestById(
            @PathVariable Long id) {

        ServiceRequestDTO dto =
                serviceRequestService.getServiceRequestById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequestDTO> updateServiceRequest(
            @PathVariable Long id,
            @RequestBody ServiceRequest serviceRequest) {

        ServiceRequest updatedRequest =
                serviceRequestService.updateServiceRequest(id, serviceRequest);

        if (updatedRequest == null) {
            return ResponseEntity.notFound().build();
        }

        ServiceRequestDTO dto =
                serviceRequestService.convertToDTO(updatedRequest);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(
            @PathVariable Long id) {

        serviceRequestService.deleteServiceRequest(id);

        return ResponseEntity.noContent().build();
    }
}
