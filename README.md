# 🕷 DESAFIO TÉCNICO – QUALITY ASSURANCE ENGINEER 👨‍💻

## 🎯 DESAFIO

Criar e automatizar possíveis cenários de teste de um projeto web baseando na página de login do site “Automation Practice”. 


## 📝 ATRIBUTOS
  - Framework: Selenium WebDriver
  - Linguagem: Java
  - IDE: IntellijIdea


## 🔎 COMO USAR

Siga as etapas abaixo para executar o código:

1. **Pré-requisitos**: Certifique-se de ter instalado:
    - [Java](https://www.selenium.dev/downloads/)
    - [ChromeDriver](https://chromedriver.chromium.org/downloads)
      
2.  **Execução**: Execute o script: `AutomationLoginTests.java`.

3. **Resultados**: São feitos testes em 3 diferentes tipos de cenário na página de login do site “Automation Practice”.


## ⏩ Cenários

1. **Cenário 1**: TESTE DE LOGIN COM CREDENCIAIS VÁLIDAS
    - Dado que o usuário esteja na página de login do "Automation Practice".
    - Quando o usuário inserir um email de usuário e senha válidos e clicar no botão "Sign in".
    - Então o usuário deve ser redirecionado para a página da conta do usuário.

2. **Cenário 2**: TESTE DE LOGIN COM CREDENCIAIS INVÁLIDAS
    - Dado que o usuário esteja na página de login do "Automation Practice".
    - Quando o usuário inserir um email de usuário e/ou senha inválidos e clicar no botão "Sign in".
    - Então o sistema deve exibir uma mensagem de erro informando que as credenciais são inválidas.

3. **Cenário 3**: TESTE DE RECUPERAÇÃO DE SENHA DE UMA CONTA VÁLIDA
    - Dado que o usuário esteja na página de login do "Automation Practice".
    - Quando o usuário clicar no link "Forgot your password?", inserir seu endereço de e-mail registrado e clicar no botão "Retrieve Password".
    - Então o sistema deve exibir uma mensagem informando que um e-mail de recuperação de senha foi enviado com sucesso.


## 🔗 Referências
    - https://www.selenium.dev/pt-br/documentation/webdriver/
 
