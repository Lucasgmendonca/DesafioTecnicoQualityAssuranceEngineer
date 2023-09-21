public class AutomationLoginTestsFeature {
    public static void main(String[] args) {
        AutomationLoginTestsFeature automationLoginTestsFeature = new AutomationLoginTestsFeature();
        automationLoginTestsFeature.runTests();
    }

    private void runTests() {
        AutomationLoginTestsModel automationLoginTestsModel = new AutomationLoginTestsModel();

        // Cenário 1: TESTE DE LOGIN COM CREDENCIAIS VÁLIDAS
        // - Dado que o usuário esteja na página de login do "Automation Practice"
        // - Quando o usuário inserir um email de usuário e senha válidos e clicar no botão "Sign in"
        // - Então o usuário deve ser redirecionado para a página da conta do usuário
        AutomationLoginTestsModel.TestLoginValidCredentials();

        // Cenário 2: TESTE DE LOGIN COM CREDENCIAIS INVÁLIDAS
        // - Dado que o usuário esteja na página de login do "Automation Practice"
        // - Quando o usuário inserir um email de usuário e/ou senha inválidos e clicar no botão "Sign in"
        // - Então o sistema deve exibir uma mensagem de erro informando que as credenciais são inválidas
        automationLoginTestsModel.TestLoginInvalidCredentials();

        // Cenário 3: TESTE DE RECUPERAÇÃO DE SENHA DE UMA CONTA VÁLIDA
        // - Dado que o usuário esteja na página de login do "Automation Practice"
        // - Quando o usuário clicar no link "Forgot your password?", inserir seu endereço de e-mail registrado e clicar no botão "Retrieve Password"
        // - Então o sistema deve exibir uma mensagem informando que um e-mail de recuperação de senha foi enviado com sucesso
        automationLoginTestsModel.TestPasswordRecovery();

        // Imprimir o relatório
        AutomationLoginTestsModel.report.printOut();
    }
}