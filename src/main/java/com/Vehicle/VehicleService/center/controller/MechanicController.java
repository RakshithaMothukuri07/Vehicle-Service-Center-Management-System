
package com.Vehicle.VehicleService.center.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vehicle.VehicleService.center.dto.MechanicDTO;
import com.Vehicle.VehicleService.center.entity.Mechanic;
import com.Vehicle.VehicleService.center.service.MechanicService;

@RestController
@RequestMapping("/api/mechanics")
public class MechanicController {

    private final MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @PostMapping
    public ResponseEntity<MechanicDTO> saveMechanic(
            @RequestBody Mechanic mechanic) {

        Mechanic savedMechanic =
                mechanicService.saveMechanic(mechanic);

        MechanicDTO dto =
                mechanicService.convertToDTO(savedMechanic);

        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<MechanicDTO>> getAllMechanics() {

        List<MechanicDTO> mechanics =
                mechanicService.getAllMechanics();

        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechanicDTO> getMechanicById(
            @PathVariable Long id) {

        MechanicDTO dto =
                mechanicService.getMechanicById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MechanicDTO> updateMechanic(
            @PathVariable Long id,
            @RequestBody Mechanic mechanic) {

        Mechanic updatedMechanic =
                mechanicService.updateMechanic(id, mechanic);

        if (updatedMechanic == null) {
            return ResponseEntity.notFound().build();
        }

        MechanicDTO dto =
                mechanicService.convertToDTO(updatedMechanic);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMechanic(
            @PathVariable Long id) {

        mechanicService.deleteMechanic(id);

        return ResponseEntity.noContent().build();
    }
}
