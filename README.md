"# invoice_service"

H2 Configuration :

    Driver Class : org.h2.Driver
    JDBC URL : jdbc:h2:mem:testdb
    User Name : sa
    **There is no password

Swagger URL : http://localhost:8080/swagger-ui.html

The Post method takes in json formatted in the following layout:
    {
        "client": "ClientName",
        "invoiceDate": "2018-09-29",
        "lineItems": [
            {
                "description": "LineItem1",
                "quantity": 10,
                "unitPrice": 10
            }
        ],
        "vatRate": 10
    }