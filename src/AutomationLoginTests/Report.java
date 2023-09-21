package AutomationLoginTests;

public class Report {
    private int totalTests;
    private int testsPass;
    private int testsFailed;

    public Report() {
        this.totalTests = 0;
        this.testsPass = 0;
        this.testsFailed = 0;
    }

    public void registerTest(boolean pass) {
        totalTests++;
        if (pass) {
            testsPass++;
        } else {
            testsFailed++;
        }
    }

    public void printOut() {
        System.out.println("-------- Relatório de Testes --------");
        System.out.println("Total de testes: " + totalTests);
        System.out.println("Testes Passados: " + testsPass);
        System.out.println("Testes Falhados: " + testsFailed);
    }
}