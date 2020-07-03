# WebStore


## Pré requisito
- Maven 3
- Java 8
- Docker 1.13.0+

## Preparando ambiente


```
mvn clean package dockerfile:build 
```

## Executando

Executando container do Postgres
```
docker run -it \    
    --name docker-postgres \    
    -e POSTGRES_DB=db \   
    -e POSTGRES_USER=postgres \   
    -e POSTGRES_PASSWORD=postgres  
    postgres:10.4
```

Executando container da aplicação
```
docker run -it     
   --link docker-postgres     
   -p 8080:8080    
   lucasfealves/webStore
```

## Acessando 

- http://localhost:8080/web/swagger-ui.html

