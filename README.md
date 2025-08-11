# Spring Boot Ollama Demo

This is a Spring Boot demo project that integrates with Ollama to provide chat functionality using a locally running Large Language Model (LLM).

## Prerequisites

Before running this project, make sure you have the following components installed and configured:

### 1. Java Development Environment
- JDK 24 or higher
- Maven 3.9+ (optional, as the project includes Maven Wrapper)

### 2. Ollama Platform
You need to have [Ollama](https://ollama.com/) installed and running locally:

```bash
# Install on macOS using Homebrew
brew install ollama

# Or download the appropriate installer for your OS from https://ollama.com/
```


### 3. DeepSeek-R1 Model
The project is configured to use the [DeepSeek-R1](https://deepseek.com/) model. You need to pull this model first:

```bash
# Pull the DeepSeek-R1 model (adjust the name if needed based on actual availability)
ollama run deepseek-r1:latest
```


> Note: If `deepseek-r1:latest` is not the exact model name in Ollama, please adjust accordingly. You can check installed models with `ollama list`.

## Project Configuration

The project is configured to use the Ollama model in [application.properties](file:///Users/boyangqin/development/springboot-ollama-demo/src/main/resources/application.properties):

```properties
spring.ai.ollama.chat.options.model=deepseek-r1:latest
```


## Quick Start

1. Clone the project to your local machine
2. Ensure the Ollama service is running
3. Make sure you have pulled the `deepseek-r1:latest` model
4. Run the project using Maven:

```bash
# Using the included Maven Wrapper
./mvnw spring-boot:run

# Or using your system's Maven installation
mvn spring-boot:run
```


5. Access the chat endpoint:

```bash
curl "http://localhost:8080/chat?prompt=Hello, tell me about yourself"
```


## API Endpoint

### Chat Endpoint

- **URL**: `/chat`
- **Method**: `GET`
- **Parameter**: `prompt` (required) - The text prompt to send to the model
- **Response**: The model's text response

Example:
```bash
curl "http://localhost:8080/chat?prompt=Hello!"
```


## Project Structure

```
src/main/java/com/example/springboot_ollama_demo/
├── ChatController.java          # Chat controller
├── SpringbootOllamaDemoApplication.java  # Main application class
src/main/resources/
├── application.properties       # Application configuration
```


## Dependencies

- `spring-boot-starter-web`: Spring Web functionality
- `spring-ai-starter-model-ollama`: Spring AI Ollama integration
- `spring-boot-starter-test`: Testing framework

## Troubleshooting

1. **Model not found error**
    - Make sure you've pulled the model using `ollama run deepseek-r1:latest`
    - Check that the model name in [application.properties](file:///Users/boyangqin/development/springboot-ollama-demo/src/main/resources/application.properties) is correct

2. **Ollama service not running**
    - Run `ollama serve` in terminal to start the service
    - Or start Ollama through your system's service manager

3. **Port conflicts**
    - Add `server.port` property in [application.properties](file:///Users/boyangqin/development/springboot-ollama-demo/src/main/resources/application.properties) to change the port

## License

This project is based on Spring Boot and uses the Apache 2.0 License.