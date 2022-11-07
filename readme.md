# Frameworks

## Bem vindo ao desafio de frameworks do movimento codar.

A idéia deste desafio é forçar a prática deliberada do nosso conhecimento de Spring Boot, Spring MVC, JPA e Spring Data.

## Observações

-> O projeto roda na URL: http://localhost:8080/, no entanto as URLs estão pré configuradas no Postman sendo não necessário acessar a web e digitar manualmente os endereços.

-> No projeto existe um arquivo nomeado ```BlueSoft API Spring Boot.postman_collection.json```, então entre no Postman, clique no botão de ```import```, selecione o arquivo .json e você verá uma pasta com todas as requisições para serem feitas dentro.

-> caso não tenha o Postman instalado entre no link a seguir para realizar o download: https://www.postman.com/downloads/

### Endpoints: 

**Cliente**
- GET: http://localhost:8080/clientes
- GET por id: http://localhost:8080/{id}
- POST Cadastrar cliente: http://localhost:8080/clientes/cadastrar
```
{
	"nome": "Connor Kenedy",
	"cpf": 74185296374,
	"email": "connor@gmail.com",
	"celular": 789456325
}
```

- PUT Atualizar cliente: http://localhost:8080/clientes/atualizar/{cpf}
```
{
	"nome": "Connor Cortez",
	"cpf": 74185296374,
	"email": "connor@mudeiOemail.com",
	"celular": 789456325
}
```
- DELETE Deletar cliente: http://localhost:8080/clientes/deletar/{cpf}

**Carro**
- GET: http://localhost:8080/carros
- GET por placa: http://localhost:8080/carros/{placa} 
- POST Cadastrar carro: http://localhost:8080/carros/cadastrar
```
{
    "placa": "DUF-9348",
    "marca": "Ford",
    "modelo": "Ford GT 3.5 V6 Turbo",
    "cor": "Azul",
    "ano": "2017",
    "quilometragem": "20000",
    "diaria": "750.60"
}
```
- PUT Atualizar carro: http://localhost:8080/carros/atualizar/{placa}
```
{
    "placa": "DUF-1234",
    "marca": "Ford",
    "modelo": "Ford GT 3.5 V6 Turbo",
    "cor": "Preto",
    "ano": "2017",
    "quilometragem": "30000",
    "diaria": "780.60"
}
```

- DELETE Deletar carro: http://localhost:8080/carros/deletar/{placa}

**Vendedor**
- GET: http://localhost:8080/vendedores
- GET por id: http://localhost:8080/vendedores/{id}
- POST Cadastrar vendedor: http://localhost:8080/vendedores/cadastrar
```
{
    "nome": "Ezio Auditore",
    "cpf": 12345678974,
    "dataAdmissao": "2018-03-14"
}
```
- PUT Atualizar vendedor: http://localhost:8080/vendedores/atualizar/{cpf}
```
{
    "nome": "Altair Tores",
    "cpf": 12345678974,
    "dataAdmissao": "2018-03-14"
}
```
- DELETE Deletar vendedor: http://localhost:8080/vendedores/deletar/{cpf}

**Aluguel**
- POST Alugar carro: http://localhost:8080/aluguel
```
{
    "cpfCliente": "39371890017",
    "cpfVendedor": "34378748819",
    "placaCarro": "ABC-1234",
    "quantidadeDeDias": "3"
}
```
GET aluguel pelo id: http://localhost:8080/aluguel/{id}

**Comissão**

- GET Listar todas as comissões: http://localhost:8080/comissoes/listar
- GET Buscar comissão pelo CPF do vendedor: http://localhost:8080/comissoes/{cpf}
