
package com.Vehicle.VehicleService.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Vehicle.VehicleService.center.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
