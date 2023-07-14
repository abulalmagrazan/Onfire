# Auth Api

## sign in

Endpoint : POST /api/login

Request Body:

```json
{
  "subject":"subject",
  "secretKey":"liberate-tutume-ex-inferis-ad-astra-per-aspera",
  "audience":"Onfire",
  "username":"abul",
  "password":"indocyber",
  "role":"administrator"
}
```

Response Body (Success):
```json
{
  "data": {
    "token": "tokenApi"
  },
  "error": null,
  "pagingResponse": null
}
```

Response Body(Fail):
```json
{
  "data": {
    "token": null
  },
  "error": "message Error",
  "pagingResponse": null
}
```

## Register User

### Customer

Endpoint: POST api/register/customer

Request Body:

```json
{
  "username": "abul",
  "password": "password",
  "email": "Email",
  "role": "customer"
}
```

Response Body(Success):

```json
{
  "data": "Success Create Account"
}
```

Response Body(Fail request):

```json
{
  "data": "Fail",
  "error": {
    "field": "field error",
    "message": "message error"
  }
}
```

Response Body(Fail username/email):

```json
{
  "data": "Username/email is already exist"
}
```



