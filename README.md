# MVCHBRMYSQL
Spring MVC Maven  Hibernate Mysql CRUD example

CREATE TABLE User (
  id int(11) NOT NULL AUTO_INCREMENT, 
  name varchar(20) NOT NULL DEFAULT '',  
  lastname varchar(20) NOT NULL DEFAULT '',  
  email varchar(20) NOT NULL DEFAULT '', 
  password varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
);

TO-DO: 
1. Use spring-security for password.
2. Use hibernate validation for email

How to create from scratch:

1. New Maven Project
  Create a simple project (skip archetype selection)
  com.sample
  MVCHBRMYSQL
  0.0.1
  war

2. Project - Properties > Maven > Project Facets
   Dynamic Web Module 3.0
   Java               1.8
   Java Script        1.0
   Runtimes: Apache Tomcat v7.0

3. Deployment Descriptor - Generate Deployment Descriptor Stub
(Project –> RightClick –> Java EE Tools –> Generate Deployment Descriptor Stub)
   (creates web.xml)

4. Create file:  /src/main/webapp/index.jsp

TEST: Run on Server

5. pom.xml > Dependencies > Add

   org.springframework    spring-core
   org.springframework    spring-webmvc
   org.springframework    spring-web

6. Modify web.xml

7 . New "Spring Bean Definition file" /WEB-INF/root-context.xml
    Select "beans" for XSD namespace declerations

8. pom.xml > Dependencies > Add    

   org.springframework    spring-context
   org.springframework    spring-tx

9. New "Spring Bean Definition file" /WEB-INF/root-context.xml
   Select "beans", "context", "mvc", "tx" for XSD namespace declerations

10. New "Spring Bean Definition file" /WEB-INF/dispatcher-servlet.xml
   Namespaces: beans, context, mvc

11. Add (see dispatcher-servlet)
   mvc:annotation-driven
   context:component-scan
   prefix suffix definitions

12. Create WEB-INF/views/ directory
    Create WEB-INF/views/index.jsp

13. Create com.sample.controller.WebController class (add "/" section that handles request mapping)

TEST: MVCHBRMYSQL/

14. Delete /src/main/webapp/index.jsp

TEST: MVCHBRMYSQL/

Finally, integrate Hibernate: 
Add user.jsp
Add other dependencies
Create new classes for model /dao / service
Update dispatcher-servlet
