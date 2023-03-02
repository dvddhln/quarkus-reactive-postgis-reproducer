# quarkus-reactive-postgis-reproducer

Reproducer with postgis and reactive panache.


1. Start Quarkus in dev mode  
`mvn quarkus:dev`


2. Call endpoint 

`curl -X POST http://localhost:8080/location`

3. Error  


```
Caused by: io.vertx.pgclient.PgException: ERROR: syntax error at or near "," (42601)
```