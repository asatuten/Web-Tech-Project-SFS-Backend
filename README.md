# webtech-backend

customize the application.yml to your ip addr

modified the user/ pw for datasource ( current root1:root1)

run application.yml

run BasicAuthBackendApplication.java 

Postname:

  POST : http://localhost:7000/api/v0/auth/role
  body - raw - json : 
    [ 
      "ROLE_EMPLOYEE",
      "ROLE_CUSTOMER",
      "ROLE_DIRECTOR",
    ]
  POST :http://localhost:7000/api/v0/auth/sign-up
    //director register info hard coded
     [
      "firstname": " ? ",
      "lastname": " ? ",
      "email": "{{enter mail for director}}", 
      "password" : " {{password}} ",
      "roleList" : [
          "ROLE_DIRECTOR"
     ]
       
    
  
  
