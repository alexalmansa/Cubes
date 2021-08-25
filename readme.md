# How to use the API

To execute the project and test it you only have to run the project and make a request to the endpoints of the API.

I've decided to implement the project in Spring because I know the position where I'll work is related to it and I wanted to show my skills in this field.

To use the API you can make it via postman, the collection of all the endpoints is inside the project folder and it's a file named CubesCollection.json.

if you prefer to test it outside Postman, the endpoints are :

GET http://localhost:8080/cubes/all It returns all the cubes

GET http://localhost:8080/cubes/one It returns a cube

POST http://localhost:8080/cubes/create It creates a cube

POST http://localhost:8080/cubes/update It updates a cube

GET http://localhost:8080/cubes/intersect It calculates the intersection of a cube

##Testing

There are also some tests in the test folder that ensure the correct behavior of the system. 
