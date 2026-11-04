
package com.Vehicle.VehicleService.center.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vehicle.VehicleService.center.dto.SparePartDTO;
import com.Vehicle.VehicleService.center.entity.SparePart;
import com.Vehicle.VehicleService.center.service.SparePartService;

@RestController
@RequestMapping("/api/spare-parts")
public class SparePartController {

    private final SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }

    @PostMapping
    public ResponseEntity<SparePartDTO> addSparePart(
            @RequestBody SparePart sparePart) {

        SparePart savedPart = sparePartService.saveSparePart(sparePart);

        return ResponseEntity.status(201)
                .body(sparePartService.convertToDTO(savedPart));
    }

    @GetMapping
    public List<SparePartDTO> getAllSpareParts() {
        return sparePartService.getAllSpareParts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SparePartDTO> getSparePartById(
            @PathVariable Long id) {

        SparePartDTO sparePart = sparePartService.getSparePartById(id);

        if (sparePart == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sparePart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SparePartDTO> updateSparePart(
            @PathVariable Long id,
            @RequestBody SparePart updatedPart) {

        SparePart sparePart =
                sparePartService.updateSparePart(id, updatedPart);

        if (sparePart == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                sparePartService.convertToDTO(sparePart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSparePart(@PathVariable Long id) {
        sparePartService.deleteSparePart(id);
        return ResponseEntity.noContent().build();
    }
}
