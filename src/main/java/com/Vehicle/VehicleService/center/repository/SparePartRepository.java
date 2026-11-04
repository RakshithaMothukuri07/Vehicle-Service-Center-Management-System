package com.Vehicle.VehicleService.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Vehicle.VehicleService.center.entity.SparePart;

public interface SparePartRepository extends JpaRepository<SparePart, Long> {

}