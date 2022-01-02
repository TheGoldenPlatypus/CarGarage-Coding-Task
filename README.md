# Car Garage Management System  
## _Spring Boot CRUD App - HTTP Based REST API_

### Technologies used:
* Java 8
* Spring Framework (Core, Boot, ECB, Data)
* H2 database (embedded)
* Gradle


 ## 📸 Screenshots

![alt text](/Screenshots/db.PNG?raw=true)
 
## Features

- Add a new vehicle to the vehicles collection
- Retrieve a single vehicle by license number
- Retrieve all of the available vehicles
- Inflate vehicle tires to maximum pressure 
 - Add energy (Refuel a vehicle or recharge) by license number

** For your convienet some random data is loaded into the DB in each run of the app



## Installation



**1.1 Clone the repository (alternatively you can just download it) using 
the following command:**

```bash
git clone https://github.com/TheGoldenPlatypus/CarGarage-Coding-Task
```
OR

**1.2 In IDE (If you prefer to download the zip)**

1.2.1 File → Import → Select An Import Wizard → General → Projects From Folder Or Archive → next

1.2.2  In the next screen click the "Directory.." button and chosse the unzipped project's folder

**2. Build Gradle**

2.1 Locate the imported project on your IDE Project explorer and right-click on it

2.2 Configure → Add Gradle Nature

**3. Run The Appliction**

Now you can access the application at http://localhost:8094/ in your browser
(if you didn't configure another port for this purpose in `src/main/resources/application.properties` )




## H2 DB GUI Console

In order to test the app , a H2 GUI (aka. spring.h2.console.enabled=true) configuration were added.
after runing the application, navigate in your browser to : http://localhost:8094/h2-console
extarct from the console log  of your IDE the 'jdbc line' value and paste it into JDBC URL text box and afterwards press the connect button:

![alt text](/Screenshots/H2connect.PNG?raw=true)

