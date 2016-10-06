# PlayScala2

pre-requisite:- need sbt installed on machine and an internet connection - to download dependencies

command:- ```sbt run``` 
  - default port is 9000 for play applications

Request - GET - http://localhost:9000/registration/123456789

Response
```
{
  "registrationId": 123456789,
  "status": "Approved",
  "registrationDate": "2016-10-24",
  "processingDate": "2016-10-25T09:30:47Z",
  "isActive": true,
  "cost": 100.75
}
```

Request - POST - http://localhost:9000/registration

Response
```
{
  "registrationId": 123456789,
  "status": "Approved",
  "registrationDate": "2016-10-24",
  "processingDate": "2016-10-25T09:30:47Z",
  "isActive": true,
  "cost": 100.75
}
```

Request - PUT - http://localhost:9000/registration

Response
```
{
  "registrationId": 987654321,
  "status": "Pending",
  "registrationDate": "2016-10-24",
  "processingDate": "2016-10-25T09:30:47Z",
  "isActive": false,
  "cost": 100.75
}
```

Request - DELETE - http://localhost:9000/registration/987654321

Response
```
{
  "registrationId": 987654321,
  "status": "Deleted",
  "registrationDate": "2016-10-24",
  "processingDate": "2016-10-25T09:30:47Z",
  "isActive": true,
  "cost": 100.75
}
```

