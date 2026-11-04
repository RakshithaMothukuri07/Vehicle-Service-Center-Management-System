# Vehicle Service Center Management System

## Project Overview
The Vehicle Service Center Management System is a RESTful web application developed using Spring Boot and MySQL. It helps manage vehicle servicing operations, including customers, vehicles, service requests, mechanics, spare parts, and invoices.

## Technologies Used
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- DTOs
- ModelMapper
- Bean Validation
- Postman

## Modules
1. **Customer Management** – Manage customer details.
2. **Vehicle Management** – Manage vehicles associated with customers.
3. **Service Request Management** – Create and track service requests for vehicles.
4. **Mechanic Management** – Maintain mechanic information and specializations.
5. **Spare Parts Management** – Manage spare parts, prices, and stock quantities.
6. **Invoice Management** – Generate and manage invoices linked to service requests.

## Features
- CRUD operations (Create, Read, Update, Delete)
- RESTful API architecture
- Entity relationships using JPA
- DTO-based request and response handling
- Input validation using Jakarta Bean Validation
- Centralized exception handling
- MySQL database integration
- API testing using Postman

## Database Relationships
- Customer → Vehicles (One-to-Many)
- Vehicle → Service Requests (One-to-Many)
- Service Request → Invoice (One-to-One)

## How to Run the Project

1. Clone the repository.
2. Open the project in Spring Tool Suite or Eclipse.
3. Configure MySQL credentials in `src/main/resources/application.properties`.
4. Create the database:

   ```sql
   CREATE DATABASE vehicle_service_center;
   ```

5. Run the main Spring Boot application.
6. Access the APIs through Postman.

## API Endpoints

| Module | Endpoint |
|---|---|
| Customers | `/api/customers` |
| Vehicles | `/api/vehicles` |
| Service Requests | `/api/service-requests` |
| Mechanics | `/api/mechanics` |
| Spare Parts | `/api/spare-parts` |
| Invoices | `/api/invoices` |

## Developed By
Rakshitha Mothukuri