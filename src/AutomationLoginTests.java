import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationLoginTests {
    private static Report report = new Report();
    private static WebDriver driver;

    public static void main(String[] args) {
        // Cenário 1: TESTE DE LOGIN COM CREDENCIAIS VÁLIDAS
        // - Dado que o usuário esteja na página de login do "Automation Practice"
        // - Quando o usuário inserir um email de usuário e senha válidos e clicar no botão "Sign in"
        // - Então o usuário deve ser redirecionado para a página da conta do usuário
        TestLoginValidCredentials();

        // Cenário 2: TESTE DE LOGIN COM CREDENCIAIS INVÁLIDAS
        // - Dado que o usuário esteja na página de login do "Automation Practice"
        // - Quando o usuário inserir um email de usuário e/ou senha inválidos e clicar no botão "Sign in"
        // - Então o sistema deve exibir uma mensagem de erro informando que as credenciais são inválidas
        TestLoginInvalidCredentials();

        // Cenário 3: TESTE DE RECUPERAÇÃO DE SENHA DE UMA CONTA VÁLIDA
        // - Dado que o usuário esteja na página de login do "Automation Practice"
        // - Quando o usuário clicar no link "Forgot your password?", inserir seu endereço de e-mail registrado e clicar no botão "Retrieve Password"
        // - Então o sistema deve exibir uma mensagem informando que um e-mail de recuperação de senha foi enviado com sucesso
        TestPasswordRecovery();

        // Imprimir o relatório
        report.printOut();
    }

    private static void TestLoginValidCredentials() {
        openBrowser();

        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));

        usernameField.sendKeys("lucas_email_valido@gmail.com");
        passwordField.sendKeys("lucas_senha_valida");

        signInButton.click();

        driver.get("http://www.automationpractice.pl/index.php?controller=my-account");

        WebElement accountPageHeader = driver.findElement(By.className("page-heading"));
        boolean passou = accountPageHeader.getText().equals("MY ACCOUNT");
        report.registrarTeste(passou);
        if (passou) {
            System.out.println("Cenário 1 Passou - O usuário foi redirecionado para a página da conta do usuário.");
        } else {
            System.out.println("Cenário 1 Falhou - O usuário não foi redirecionado para a página da conta do usuário.");
        }

        closeBrowser();
    }

    private static void TestLoginInvalidCredentials() {
        openBrowser();

        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));

        usernameField.sendKeys("lucas_email_invalido@gmail.com");
        passwordField.sendKeys("lucas_senha_invalida");

        signInButton.click();

        WebElement errorAlert = driver.findElement(By.className("alert-danger"));
        boolean passou = errorAlert.isDisplayed();
        report.registrarTeste(passou);
        if (passou) {
            System.out.println("Cenário 2 Passou - Foi exibida uma mensagem de erro informando que as credenciais são inválidas.");
        } else {
            System.out.println("Cenário 2 Falhou - A mensagem de erro não foi exibida.");
        }

        closeBrowser();
    }

    private static void TestPasswordRecovery() {
        openBrowser();

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgotPasswordLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("lucas_email_valido@gmail.com");

        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium"));
        retrievePasswordButton.click();

        WebElement successMessage = driver.findElement(By.className("alert-success"));
        boolean passou = successMessage.getText().contains("A confirmation email has been sent");
        report.registrarTeste(passou);
        if (passou) {
            System.out.println("Cenário 3 Passou - Foi exibida uma mensagem de sucesso após solicitação de recuperação de senha.");
        } else {
            System.out.println("Cenário 3 Falhou - A mensagem de sucesso não foi exibida.");
        }

        closeBrowser();
    }

    private static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lucas\\IdeaProjects\\DesafioTecnicoQualityAssuranceEngineer\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://automationpractice.pl/index.php?controller=authentication&back=myaccount");
    }

    private static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}