
package com.Vehicle.VehicleService.center.service;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import com.Vehicle.VehicleService.center.dto.MechanicDTO;
import com.Vehicle.VehicleService.center.entity.Mechanic;
import com.Vehicle.VehicleService.center.repository.MechanicRepository;

@Service
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public Mechanic saveMechanic(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    public List<MechanicDTO> getAllMechanics() {
        return mechanicRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public MechanicDTO getMechanicById(Long id) {

        Mechanic mechanic =
                mechanicRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Mechanic not found with ID: " + id));

        return convertToDTO(mechanic);
    }

    public Mechanic updateMechanic(Long id, Mechanic mechanic) {

        Mechanic existingMechanic =
                mechanicRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Mechanic not found with ID: " + id));

        existingMechanic.setName(mechanic.getName());
        existingMechanic.setSpecialization(mechanic.getSpecialization());
        existingMechanic.setPhone(mechanic.getPhone());
        existingMechanic.setEmail(mechanic.getEmail());
        existingMechanic.setSalary(mechanic.getSalary());

        return mechanicRepository.save(existingMechanic);
    }

    public void deleteMechanic(Long id) {

        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Mechanic not found with ID: " + id));

        mechanicRepository.delete(mechanic);
    }
    public MechanicDTO convertToDTO(Mechanic mechanic) {
        return new MechanicDTO(
                mechanic.getMechanicId(),
                mechanic.getName(),
                mechanic.getSpecialization(),
                mechanic.getPhone(),
                mechanic.getEmail(),
                mechanic.getSalary()
        );
    }
}
