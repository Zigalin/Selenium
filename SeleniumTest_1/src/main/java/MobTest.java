import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class MobTest {

    @Test
    public void CheckMobilePayment() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://next.privat24.ua/mobile");

        wait.until(ExpectedConditions.titleIs("Поповнення рахунку мобільного телефону банківською карткою онлайн — Приват24"));

        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        driver.findElement(phoneNumber).sendKeys("688905929");

        By cvvdebitSource = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        driver.findElement(cvvdebitSource).sendKeys("327");

        By sumPayment = By.xpath("//input[@data-qa-node='amount']");
        driver.findElement(sumPayment).sendKeys("100");

        By numberCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
        driver.findElement(numberCard).sendKeys("4506909324274797");

        By expiredebitSource = By.xpath("//input[@data-qa-node='expiredebitSource']");
        driver.findElement(expiredebitSource).sendKeys("06-22");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-qa-node='firstNamedebitSource']")));

        By firstNamedebitSource = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        driver.findElement(firstNamedebitSource).sendKeys("Poerto");

        By lastNamedebitSource = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        driver.findElement(lastNamedebitSource).sendKeys("Rico");

        driver.findElement(By.xpath("//button[@data-qa-node='submit']")).click();

        // Сплатити
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(), 'Сплатити')]"))).click();

        // Видалити
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='sc-VigVT kQuteT']"))).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-qa-value='submit']"))).click();

        // Закрыть браузер
//        driver.quit();

    }

}
