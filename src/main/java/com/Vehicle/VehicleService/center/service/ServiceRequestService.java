
package com.Vehicle.VehicleService.center.service;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import com.Vehicle.VehicleService.center.dto.ServiceRequestDTO;
import com.Vehicle.VehicleService.center.entity.ServiceRequest;
import com.Vehicle.VehicleService.center.repository.ServiceRequestRepository;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService(
            ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public ServiceRequest saveServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    public List<ServiceRequestDTO> getAllServiceRequests() {
        return serviceRequestRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ServiceRequestDTO getServiceRequestById(Long id) {

        ServiceRequest serviceRequest =
                serviceRequestRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Service request not found with ID: " + id));

        return convertToDTO(serviceRequest);
    }

    public void deleteServiceRequest(Long id) {

        ServiceRequest serviceRequest =
                serviceRequestRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Service request not found with ID: " + id));

        serviceRequestRepository.delete(serviceRequest);
    }

    public ServiceRequest updateServiceRequest(
            Long id, ServiceRequest serviceRequest) {

        ServiceRequest existingRequest =
                serviceRequestRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Service request not found with ID: " + id));

        existingRequest.setServiceType(serviceRequest.getServiceType());
        existingRequest.setDescription(serviceRequest.getDescription());
        existingRequest.setServiceDate(serviceRequest.getServiceDate());
        existingRequest.setStatus(serviceRequest.getStatus());
        existingRequest.setVehicle(serviceRequest.getVehicle());

        return serviceRequestRepository.save(existingRequest);
    }

    public ServiceRequestDTO convertToDTO(ServiceRequest serviceRequest) {
        return new ServiceRequestDTO(
                serviceRequest.getServiceRequestId(),
                serviceRequest.getServiceType(),
                serviceRequest.getDescription(),
                serviceRequest.getServiceDate(),
                serviceRequest.getStatus(),
                serviceRequest.getVehicle().getVehicleId()
        );
    }
}
