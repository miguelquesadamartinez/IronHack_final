
#Testing

user: miguel
pass: 1804

http://localhost:8080/transfer-to-account
{
"idOrigin": 14,
"amount": 100,
"idHolderUno": 5,
"idHolderDos": 16
}

http://localhost:8080/create-credit-card

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

http://localhost:8080/pay-third-party
hashedKey header -> aaaaaaa
{
"amount": 150
}