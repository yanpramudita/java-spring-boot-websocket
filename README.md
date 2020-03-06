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
* Now you can access this app using your browser on: http://localhost:8080

## Disclaimer
* The data is stored in memory and will be cleared up every time the app is shut down or restarted.

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

### List messages:
* URL: ```GET http://localhost:8080/api/v1/message/list```
* Response:
```$xslt
[
    {
        "id": 1,
        "message": "sd",
        "createdAt": "2020-03-06 18:18:20.243"
    },
    {
        "id": 2,
        "message": "sd",
        "createdAt": "2020-03-06 18:18:24.717"
    }
]
```

## Websocket
* URL: ```localhost:8080/websocket```

### Get new message:
* Subscribtion topic ```/topic/message``` 
* Payload:
```aidl
{
    "id": 1,
    "message": "Hello",
    "createdAt": "2020-03-05 22:48:47.486"
}
```

## References
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)

## License
* MIT
