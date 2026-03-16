docker build -t demo-app-spring .
docker run -p 8080:8080 -v $(pwd)/src:/app/src demo-app-spring

# Configuração do Ambiente Java no VS Code

Este guia documenta como configurar corretamente o **Java** no VS Code usando a *Extension Pack for Java*, garantindo que o editor utilize o JDK instalado no sistema em vez de caminhos inválidos criados por extensões.

$HOME/.config/Windsurf/User/settings.json

---

## 1. Verificar instalação do JDK no sistema

No Linux Mint, após instalar o JDK (ex.: OpenJDK 17), confirme o caminho:

```bash
java -version
echo $JAVA_HOME
readlink -f $(which java)
```
Saida válida:
/usr/lib/jvm/java-17-openjdk-amd64/bin/java

## 2. Configurar JAVA_HOME
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
source ~/.bashrc
```

### 3. Instalar a Extension Pack for Java no VS Code
```bash

```

### 4. Ajustar settings.json do VS Code
O VS Code pode sobrescrever o JAVA_HOME com caminhos inválidos de extensões.
Edite o arquivo settings.json e configure corretamente:
"java.configuration.runtimes": [
  {
    "name": "JavaSE-17",
    "path": "/usr/lib/jvm/java-17-openjdk-amd64",
    "default": true
  }
],
"java.import.gradle.java.home": "/usr/lib/jvm/java-17-openjdk-amd64",
"maven.executable.path": "/usr/bin/mvn"


### 5. Ajustar perfis de terminal no VS Code

"terminal.integrated.profiles.linux": {
  "bash": {
    "path": "bash"
  }
},
"terminal.integrated.defaultProfile.linux": "bash"

### 6. Reiniciar VS Code
echo $JAVA_HOME
java -version
./gradlew bootRun

### 7. Limpar dependencias
./gradlew clean build --refresh-dependencies


https://copilot.microsoft.com/chats/4LwbAgWkz5mP6sXvedd7v