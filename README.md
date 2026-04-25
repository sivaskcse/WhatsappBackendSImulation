# WhatsApp Chatbot Backend Simulation

This project is a simple WhatsApp chatbot backend simulation built with Java and Spring Boot.

## Features

- `POST /webhook` endpoint to receive WhatsApp-style messages
- Accepts JSON request bodies
- Returns predefined replies:
  - `Hi` -> `Hello`
  - `Bye` -> `Goodbye`
- Logs every incoming message
- Includes basic test coverage with MockMvc

## Tech Stack

- Java 17
- Spring Boot 3
- Maven

## Request Format

```json
{
  "sender": "Alice",
  "message": "Hi"
}
```

## Response Format

```json
{
  "reply": "Hello"
}
```

## Run Locally

```bash
mvn spring-boot:run
```

The app starts at:

```text
http://localhost:8080
```

## Test the Endpoint

Example using `curl`:

```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"sender\":\"Alice\",\"message\":\"Hi\"}"
```

Example response:

```json
{
  "reply": "Hello"
}
```

## Run Tests

```bash
mvn test
```

## Deploy on Render

This repo includes a `render.yaml` and `Dockerfile`, so you can deploy it as a web service on Render.
settings:

- Environment: `Docker`
- Port: `8080`

