
package com.Vehicle.VehicleService.center.service;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
import java.util.List;
import com.Vehicle.VehicleService.center.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import com.Vehicle.VehicleService.center.entity.Vehicle;
import com.Vehicle.VehicleService.center.repository.VehicleRepository;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vehicle not found with ID: " + id));
    }

    public void deleteVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vehicle not found with ID: " + id));

        vehicleRepository.delete(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {

        Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);

        if (existingVehicle == null) {
            return null;
        }

        existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setVehicleType(vehicle.getVehicleType());
        existingVehicle.setCustomer(vehicle.getCustomer());

        return vehicleRepository.save(existingVehicle);
    }

    
public VehicleDTO convertToDTO(Vehicle vehicle) {

        return new VehicleDTO(
                vehicle.getVehicleId(),
                vehicle.getVehicleNumber(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getVehicleType(),
                vehicle.getCustomer().getCustomerId()
        );
    }
}
