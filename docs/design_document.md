# Design Document
## Title: Health+

### Business Scenario
Hospital Management System came into the picture of hospital management as early as 1960 and have ever since been evolving and synchronizing with the technologies while modernizing healthcare facilities. In today’s world, the management of healthcare starts from the hands of the patients through their mobile phones and facilitates the needs of the patient. Hospitals and healthcare facilities improve the quality of healthcare services, reduce operating costs, and improve the revenue cycle by using such hospital management systems.
**Health+** is a Hospital Management System which is an integrated information system for managing all aspects of a hospital’s operations such as medical, billing, administrative and compliance. It includes electronic health records, appointment scheduling, and customer billing management. This Hospital Management System is a patient-centric system which includes *online appointment scheduling and tracking, room booking, managing diagnostic reports, doctor and patient portal/dashboard, accounting/billing, medicine and diet prescribing solution*.

### Requirements
- Appointment Booking management.
- Should have information/helpdesk page with information of all the doctors and the departments they are involved in.
- Should have a calendar like schedule for all types of users to track their scheduled appointment dates.
- Should have room booking system that allows patients to book hospital rooms/beds on behalf of the patients.
- Should have a report uploading and management system for the patients.
- Should have an integrated billing system to calculate the total cost accumulated with the usage of hospital services and resources.
- Should have a system for doctors to prescribe medicines to patients i.e. prescriptions.

### Users and Features
1. **Patient**
    - Should be able to *create an account* in order to access hospital services.
    - Should be able to *log in* to my account easily with my username and password.
    <!-- - Should be able to *book appointments* online with a doctor. -->
    - Should be able to *update my health information* and access them.
    - Should be able to *upload my medical test reports* in the portal.

2. **Doctor**
    - Should be able to *check patient appointments* to examine and help them recover their illness.
    <!--- Should be able to *log in* to my account easily with my username and password so that I can access patient information and view thier reports. -->
    - Should be able to *create a prescription* to prescribe medicines to the patients and suggest diet plan.

3. **Admin**
    - Should be able to *create bills* for all the services and resources used by the patient.
    <!--- Should be able to *log in* to my account with my username and password with valid credentials so that I can access and manage hospital information and resources. -->
    - Should be able to access and *modify all the information of hospital* and *book room-beds* for patients, in the hospital.

![Use Case Diagram]()

### Modules
1. **Sign Up**
2. **User Login**
3. **Book Appointment**
4. **Book Room**
5. **Create Prescription**
6. **Billing System**
7. **Add Reports**

### Schematic Diagram
![Class Diagram]()

### Database Design
![ER Diagram]()

### Solution Summary
1. **Scope not covered**
    - Payment gateway integration
    - Medicine inventory management

2. **Assumptions**
    - Medicines never run out of stock
    - Bills are always paid by Cash