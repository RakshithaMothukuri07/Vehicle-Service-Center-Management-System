package com.Vehicle.VehicleService.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vehicle.VehicleService.center.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}