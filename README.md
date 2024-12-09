# Spring Boot API - Integração com ViaCEP

Este é um projeto de uma API REST desenvolvida em Java utilizando o framework Spring Boot. A API faz integração com o serviço externo [ViaCEP](https://viacep.com.br) para buscar informações de endereços com base no CEP informado. Além disso, a API é projetada para enviar os dados processados para um frontend que consome suas requisições.

---

## Front-End 
- [consultar-cep-front](https://busca-cep-plum.vercel.app/)
- [repositorio do front-end](https://github.com/patrickaugusto/busca-cep-front)

## Funcionalidades

1. **Consulta de endereço pelo CEP**:
   - A API recebe um CEP, consulta os dados no serviço ViaCEP e retorna as informações correspondentes.
2. **Envio de dados ao frontend**:
   - Disponibiliza os dados consultados através de endpoints REST para que possam ser consumidos pelo frontend.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** 3.0
  - Spring Web
  - Lombok
  - DevTools
- **API externa**: ViaCEP
- **Maven**
- **Railway** (deploy da aplicação)

---

## Requisitos

1. **Java 17 ou superior**
2. **Maven 3.6+**
3. **Postman ou ferramenta similar** (para testes da API)

---

## Configuração do Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/patrickaugusto/busca-cep.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd busca-cep
   ```

4. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

5. Acesse a API na URL:
   ```
   https://busca-cep-production-8cfa.up.railway.app/
   ```

---

## Endpoints Disponíveis

### 1. Consultar endereço pelo CEP

**GET** `consultar-cep/{cep}`

**Parâmetros**:
- `cep` (obrigatório): CEP no formato `12345678`.

**Exemplo de Requisição**:
```bash
GET https://busca-cep-production-8cfa.up.railway.app/consultar-cep/65910190
```

**Resposta de Sucesso (200):**
```json
{
    "cep": "65910-190",
    "logradouro": "Rua da Igreja",
    "complemento": "",
    "unidade": "",
    "bairro": "Vila Lobão",
    "localidade": "Imperatriz",
    "uf": "MA",
    "estado": "Maranhão",
    "regiao": "Nordeste",
    "ibge": "2105302",
    "gia": "",
    "ddd": "99",
    "siafi": "0803"
}
```

---

## Integração com o ViaCEP

A API utiliza o cliente HTTP do Spring (`RestTemplate`) para se comunicar com o serviço ViaCEP. A URL base utilizada é:
```
https://viacep.com.br/ws/{cep}/json/
```

