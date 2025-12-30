# 🌤️ ProjetoSICTR – Consulta Climática em Java

Projeto desenvolvido em **Java (console)** que consulta dados climáticos em tempo real utilizando a **API WeatherAPI**, exibindo informações como temperatura, sensação térmica, umidade, vento e pressão atmosférica a partir do nome de uma cidade informado pelo usuário.

---

## 📌 Funcionalidades

- Consulta climática em tempo real  
- Leitura do nome da cidade via teclado  
- Consumo de API REST com `HttpClient`  
- Tratamento de erro para cidade não encontrada  
- Exibição formatada dos dados climáticos  
- Leitura segura da API Key via arquivo externo  

---

## 🛠️ Tecnologias Utilizadas

- Java 11+  
- WeatherAPI  
- Biblioteca org.json  
- Java HTTP Client (`java.net.http`)  

---

## 📂 Estrutura do Projeto

```
ProjetoSICTR/
 ├── ProjetoSICTR.java
 ├── api-key.txt
 ├── json-20230618.jar
 └── README.md
```

---

## 🔑 Configuração da API Key

1. Crie um arquivo chamado **api-key.txt** na raiz do projeto.
2. Dentro dele, coloque apenas sua chave da WeatherAPI:

```
SUA_API_KEY_AQUI
```

🔗 Obtenha sua chave gratuita em:  
https://www.weatherapi.com/

---

## 📦 Dependência Necessária

Este projeto utiliza a biblioteca **org.json**.

Arquivo utilizado:
```
json-20230618.jar
```

---

## ▶️ Como Compilar e Executar

### Linux / macOS

**Compilar**
```bash
javac -cp .:json-20230618.jar ProjetoSICTR.java
```

**Executar**
```bash
java -cp .:json-20230618.jar ProjetoSICTR
```

---

### Windows

**Compilar**
```bash
javac -cp .;json-20230618.jar ProjetoSICTR.java
```

**Executar**
```bash
java -cp .;json-20230618.jar ProjetoSICTR
```

---

## 🧪 Exemplo de Execução

```
Digite o nome da cidade: Petrolina

=== INFORMAÇÕES CLIMÁTICAS ===
Cidade: Petrolina - Brazil
Data/Hora: 2025-01-30 12:00
Temperatura: 32.5 °C
Sensação Térmica: 34.1 °C
Condição: Ensolarado
Umidade: 45%
Vento: 18.0 km/h
Pressão: 1012 mb
```

---

## 🚀 Melhorias Futuras

- Interface gráfica com JavaFX  
- Organização com Maven  
- Histórico de consultas  
- Previsão de vários dias  

---

## 👨‍💻 Autor

Everton Santos  
Projeto desenvolvido para fins de estudo e aprendizado em Java.
