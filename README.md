# Steps to run in your machine
Clone the Repo
Open your project with your favorite ide

Make the necessary changes -> Save

go to SupplierApiApplication.class file present in package - com.makersharks.supplierapi

Right click on the application Run as -> Spring Boot

# you can also pull from docker hub 
   docker pull akramsarfraj/course-api:1

# docker-compose.yaml
services:

    db:
    
      image: postgres:15
      
      environment:
      
        - POSTGRES_PASSWORD=root
        - POSTGRES_USER=postgres
        - POSTGRES_DB=postgres
        
      ports:
        - 5432:5432
        
      volumes:
        - postgres-data:/var/lib/pgsql
        
      restart: always

    springApp:
      image: akramsarfraj/course-api:1
      ports: 
        - 8080:8080

volumes:
  postgres-data:
    driver: local

