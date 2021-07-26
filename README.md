# SALES API

## This API is for validate if a Sale could be done validation your stock 

Are thre Microservices
- Sales
- Stock
- Consumer

The Sales API will recived the request, validate with Stock API and if there are stock for the sale, produces a message on Rabbit.

To run this API, you will need docker installed

run the following commands:
>docker run -d --hostname localhost --name local-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

You can run by swagger:
> http://localhost:8080/swagger-ui.html


You can run with curl:

- Sale Api:

>curl --location --request POST 'http://localhost:8080/sale' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "Caderno",
    "amount": 300
}'

- Stock Api

>curl --location --request GET 'http://localhost:8081/stock?name=Caderno&amount=80'
