
package com.Vehicle.VehicleService.center.service;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import com.Vehicle.VehicleService.center.dto.SparePartDTO;
import com.Vehicle.VehicleService.center.entity.SparePart;
import com.Vehicle.VehicleService.center.repository.SparePartRepository;

@Service
public class SparePartService {

    private final SparePartRepository sparePartRepository;

    public SparePartService(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    public SparePart saveSparePart(SparePart sparePart) {
        return sparePartRepository.save(sparePart);
    }

    public List<SparePartDTO> getAllSpareParts() {
        return sparePartRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SparePartDTO getSparePartById(Long id) {

        SparePart sparePart =
                sparePartRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Spare part not found with ID: " + id));

        return convertToDTO(sparePart);
    }
    public SparePart updateSparePart(Long id, SparePart updatedPart) {

        SparePart existingPart =
                sparePartRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Spare part not found with ID: " + id));

        existingPart.setPartName(updatedPart.getPartName());
        existingPart.setPartNumber(updatedPart.getPartNumber());
        existingPart.setBrand(updatedPart.getBrand());
        existingPart.setPrice(updatedPart.getPrice());
        existingPart.setQuantity(updatedPart.getQuantity());

        return sparePartRepository.save(existingPart);
    }

    public void deleteSparePart(Long id) {

        SparePart sparePart = sparePartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Spare part not found with ID: " + id));

        sparePartRepository.delete(sparePart);
    }

    public SparePartDTO convertToDTO(SparePart sparePart) {
        return new SparePartDTO(
                sparePart.getPartId(),
                sparePart.getPartName(),
                sparePart.getPartNumber(),
                sparePart.getBrand(),
                sparePart.getPrice(),
                sparePart.getQuantity()
        );
    }
}
