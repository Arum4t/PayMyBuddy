<p align="center"><a href="https://zupimages.net/viewer.php?id=23/26/hl85.png"><img src="https://zupimages.net/up/23/26/hl85.png" alt="" /></a></p>

## Languages and Tools
<p align="center">
<a href="https://www.java.com" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="60" height="60"/>
</a>&ensp;   
<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> 
<img src="https://upload.wikimedia.org/wikipedia/fr/6/62/MySQL.svg" alt="mysql" width="70" height="70"/> 
</a>&emsp; 
<a href="https://spring.io/" target="_blank" rel="noreferrer"> 
<img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="50" height="50"/>
</a> 
</p>

---
## Project Pay My Buddy
Hi, I'm Quentin Schnurr  
I’m currently working on Pay My Buddy as a junior developper.  
It's a person to person payment application using Spring and mySQL.  

---
## Installation

- Fork and clone the project.
- Define a environment variables with your mySQL account to run the project.  

    ### 1) With Intellij/IDE
  - Edit configuration of "PayMyPuddyApplication"
  - Add environment variables in "more option"
  - Add both username and password  
  
       <a href="https://zupimages.net/viewer.php?id=23/27/hmda.png"><img src="https://zupimages.net/up/23/27/hmda.png" alt="" /></a>

### 2) With command prompt
- Open a prompt in the root file of the project

- Use the following commands:   
"export DB_USERNAME=yourUsername" and press enter.  
"export DB_PASSWORD=yourpassword" and press enter.  
"mvn spring-boot:run" is to run the project.

- Default Controller URL `http://localhost:8080/`.  
*You can change port in src/main/resources/application.properties*


## Dependencies

![Static Badge](https://img.shields.io/badge/Maven-red?link=https%3A%2F%2Fmaven.apache.org%2F)  
![Static Badge](https://img.shields.io/badge/Thymleaf-darkgreen?link=https%3A%2F%2Fwww.thymeleaf.org%2F)  
![Static Badge](https://img.shields.io/badge/Spring_security-green?link=https%3A%2F%2Fspring.io%2Fprojects%2Fspring-security)
 

## Built with

**[SpringBoot](https://spring.io/projects/spring-boot/)**  
An open-source tool that makes it easier to use Java-based frameworks to create microservices and web apps.

---
## Conceptual model : UML
<a href="https://zupimages.net/viewer.php?id=23/26/57y9.png"><img src="https://zupimages.net/up/23/26/57y9.png" alt="" /></a>

---
## Relational model
<a href="https://zupimages.net/viewer.php?id=23/26/en7u.png"><img src="https://zupimages.net/up/23/26/en7u.png" alt="" /></a>

---
## Functionnalities 

**Default page**
- Login  
- logout   
- register  
 
**Transfer page**
- Add new connection  
- Add new transaction  
- Look at your transaction made  
- Look at your transaction received  

**Contact page**
- Add new connection  

**Profile page**
- Look at your email   
- Look at your balance  
- Add money  
- Change your password  
- Change your email  
