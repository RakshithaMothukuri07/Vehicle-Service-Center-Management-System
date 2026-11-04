
package com.Vehicle.VehicleService.center.controller;

import java.util.List;
import jakarta.validation.Valid;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vehicle.VehicleService.center.dto.VehicleDTO;
import com.Vehicle.VehicleService.center.entity.Vehicle;
import com.Vehicle.VehicleService.center.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> saveVehicle(
            @RequestBody Vehicle vehicle) {

        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);

        return ResponseEntity.status(201)
                .body(vehicleService.convertToDTO(savedVehicle));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {

        List<VehicleDTO> vehicles = vehicleService.getAllVehicles()
                .stream()
                .map(vehicleService::convertToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(
            @PathVariable Long id) {

        Vehicle vehicle = vehicleService.getVehicleById(id);

        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicleService.convertToDTO(vehicle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle) {

        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);

        if (updatedVehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicleService.convertToDTO(updatedVehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {

        vehicleService.deleteVehicle(id);

        return ResponseEntity.noContent().build();
    }
}
