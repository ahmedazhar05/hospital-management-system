# Design Document
## Title: Health+

### Business Scenario
Hospital Management System came into the picture of hospital management as early as 1960 and have ever since been evolving and synchronizing with the technologies while modernizing healthcare facilities. In today’s world, the management of healthcare starts from the hands of the patients through their mobile phones and facilitates the needs of the patient. Hospitals and healthcare facilities improve the quality of healthcare services, reduce operating costs, and improve the revenue cycle by using such hospital management systems.
**Health+** is a Hospital Management System which is an integrated information system for managing all aspects of a hospital’s operations such as medical, administrative and compliance. It includes electronic health records and appointment scheduling. This Hospital Management System is a patient-centric system which includes *online appointment scheduling and tracking, managing diagnostic reports, doctor and patient portal/dashboard, medicine and diet prescribing solution*.

### Requirements
- Appointment Booking management.
- Should have a calendar like schedule for all types of users to track their scheduled appointment dates.
- Should have a report uploading and management system for the patients.
- Should have a system for doctors to prescribe medicines to patients i.e. prescriptions.

### Users and Features
1. **Patient**
    - Should be able to *create an account* in order to access hospital services.
    - Should be able to *log in* to my account easily with my username and password.
    - Should be able to *book appointments* online with a doctor.
    - Should be able to *upload my medical test reports* in the portal.

2. **Doctor**
    - Should be able to *check patient appointments* to examine and help them recover their illness.
    - Should be able to *log in* to my account easily with my username and password so that I can access patient information and view thier reports.
    - Should be able to *create a prescription* to prescribe medicines to the patients and suggest them diet plans.

3. **Admin**
    - Should be able to *verify patients* and if necessary, *block* them in case they cause nuisance.
    - Should be able to *log in* to my account with my username and password with valid credentials so that I can access and manage hospital information and resources.

![Use Case Diagram](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/ahmedazhar05/hospital-management-system/main/docs/Diagrams/Use%2520Case/system-usage)

### Modules
1. **Sign Up**
2. **User Login**
3. **Book Appointment**
5. **Create Prescription**
7. **Add Reports**

### Schematic Diagram
![Data Flow Diagram](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/ahmedazhar05/hospital-management-system/main/docs/Diagrams/Data%2520Flow/dfd)

### Database Design
![ER Diagram](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/ahmedazhar05/hospital-management-system/main/docs/Diagrams/ER/db)

### High Level Architecture
![Architecture](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/ahmedazhar05/hospital-management-system/main/docs/Diagrams/Architecture/arch)