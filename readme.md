
# Testing

### Login Credentials

user: miguel
pass: 12345

admin: admin
pass: 12345


http://localhost:8080/transfer-to-account

{
"idOrigin": 14,
"amount": 100,
"idHolderUno": 5,
"idHolderDos": 16
}

[CreditCard Creation](http://localhost:8080/create-credit-card)

{
"balance": 100,
"primaryOwner": 5,
"secondaryOwner": 6,
"creationDate": "2022-10-21",
"status": "FROZEN",
"secretKey": "string",
"dateLastAction": "2022-10-21",
"creditLimit": 1000,
"interestRate": 0.2
}

http://localhost:8080//create-third-pàrty

{
"hashedKey": "aaaaa",
"name": "Miguel"
}

http://localhost:8080/pay-third-party

"hashedKey" header -> aaaaaaa
{
"amount": 150
}

http://localhost:8080/get-fraud
Devuelve cuentas con mas de dos transaccion por dia

* More at: http://localhost:8080/swagger-ui