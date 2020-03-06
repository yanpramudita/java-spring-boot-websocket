# Simple Message API
An application that serves a simple put message and list all the messages

## How To Run
### Prerequisites:
* Java 8
* Maven

### Build:
```$xslt
$ mvn clean install
```

### Run:
```$xslt
$ java -jar target/websocket-0.0.1-SNAPSHOT.jar

## your app will run on port 8080
```
## API
### Add new message:
* URL: ```POST http://localhost:8080/api/v1/message/add```
* Spec: 

```$xslt
{
   "message" : "Hello" //string
}
```
* Response:
```$xslt
{
    "id": 1,
    "message": "Hello",
    "createdAt": "2020-03-05 22:48:47.486"
}
```


### Get message:
* URL: ```GET http://localhost:8080/api/v1/message/{id}```
* Response:
```$xslt
{
    "id": 1,
    "message": "Hello",
    "createdAt": "2020-03-05 22:48:47.486"
}
```


