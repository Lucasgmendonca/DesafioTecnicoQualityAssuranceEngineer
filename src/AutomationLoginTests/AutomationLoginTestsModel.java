package AutomationLoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationLoginTestsModel {
    static final Report report = new Report();
    private static WebDriver driver;

    public static void TestLoginValidCredentials() {
        openBrowser();

        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));

        usernameField.sendKeys("lucas_email_valido@gmail.com");
        passwordField.sendKeys("lucas_senha_valida");

        signInButton.click();

        driver.get("http://www.automationpractice.pl/index.php?controller=my-account");

        WebElement accountPageHeader = driver.findElement(By.className("page-heading"));
        boolean pass = accountPageHeader.getText().equals("MY ACCOUNT");
        report.registerTest(pass);
        if (pass) {
            System.out.println("Cenário 1 Passou - O usuário foi redirecionado para a página da conta do usuário.");
        } else {
            System.out.println("Cenário 1 Falhou - O usuário não foi redirecionado para a página da conta do usuário.");
        }

        closeBrowser();
    }

    public void TestLoginInvalidCredentials() {
        openBrowser();

        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));

        usernameField.sendKeys("lucas_email_valido@gmail.com");
        passwordField.sendKeys("lucas_senha_valida");

        signInButton.click();

        boolean pass = isAlertSuccessDisplayedLoginInvalidCredentials();
        report.registerTest(pass);
        if (pass) {
            System.out.println("Cenário 2 Passou - Foi exibida uma mensagem de erro informando que as credenciais são inválidas.");
        } else {
            System.out.println("Cenário 2 Falhou - A mensagem de erro não foi exibida.");
        }

        closeBrowser();
    }

    public void TestPasswordRecovery() {
        openBrowser();

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgotPasswordLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("lucas_email_valido@gmail.com");

        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium"));
        retrievePasswordButton.click();

        boolean pass = isAlertSuccessDisplayedPasswordRecovery();
        report.registerTest(pass);
        if (pass) {
            System.out.println("Cenário 3 Passou - Foi exibida uma mensagem de sucesso após solicitação de recuperação de senha.");
        } else {
            System.out.println("Cenário 3 Falhou - A mensagem de sucesso após solicitação de recuperação de senha não foi exibida.");
        }

        closeBrowser();
    }

    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lucas\\IdeaProjects\\DesafioTecnicoQualityAssuranceEngineer\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://automationpractice.pl/index.php?controller=authentication&back=myaccount");
    }

    private static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean isAlertSuccessDisplayedLoginInvalidCredentials() {
        try {
            WebElement successMessage = driver.findElement(By.className("alert-danger"));
            return successMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertSuccessDisplayedPasswordRecovery() {
        try {
            WebElement successMessage = driver.findElement(By.className("alert-success"));
            return successMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}