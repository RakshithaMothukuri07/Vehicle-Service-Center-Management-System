
package com.Vehicle.VehicleService.center.dto;

public class MechanicDTO {

    private Long mechanicId;
    private String name;
    private String specialization;
    private String phone;
    private String email;
    private double salary;

    public MechanicDTO() {
    }

    public MechanicDTO(Long mechanicId, String name,
            String specialization, String phone,
            String email, double salary) {
        this.mechanicId = mechanicId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }

    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
