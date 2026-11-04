
package com.Vehicle.VehicleService.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Vehicle.VehicleService.center.entity.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

}
