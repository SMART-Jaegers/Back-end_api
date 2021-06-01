# SencyCry

##### This repo is a source code of backend of this project

Here you can read about API of uor server

First of all lets see how to write correct request to server:

To get something from the server you need just use get methods and set correct url, like `http
://localhost:8081/sensycry` 

If you want to get all objects of some type you need just write after sencycry name of the type

If it must be one object simply write after type id of object what you want

To post some object of specific type you must write in json all field what have been used in this
 type and write the name of type what is in this type with id of some objects like: `"nested_type": 
 { "id": number },`
 
Update is the same as post but in url you must write also number of object which you want to
 modify
 
The last is delete which is pretty similar to get one object methods 

 