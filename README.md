# springbootjapcrud



Spring Boot | Data JPA | Swagger UI | Postman API

Functionality->

SignUp
SignIn
GetDataById
GetAllData
UpdateData
DeleteDataById

GitHub- Code/Version Control Management

Spring Boot Features->
1. InBuild Tomcat Server
2. No XML Configuration
3. Devtool- Live Reload
4. With in Minutes Production Ready Application
5. Development Faster


IQ-
Diff. @RequestParam & PathVariable
-> Both annotations used for passed to input parameter and mostly we are doing validations in DAO Layer

=> @RequestParam-                           
 1. It is used to extract query parameters     
 2. Ex-
 @DeleteMapping("/deletedatabyid")
    public ResponseEntity<String> deleteDataById(@RequestParam int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

 3. @RequestParam is more useful on a traditional web application where data is mostly 
     passed in the query parameters
 
 
 
 @PathVariable-
 1. It is used to extract data right from the URI
 2. Ex-
 @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
 
 3. @PathVariable is more suitable for RESTful web services where URL contains values.
 
