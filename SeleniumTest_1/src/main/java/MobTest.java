import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


public class MobTest {

    @Test
    public void CheckMobilePayment() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://next.privat24.ua/mobile");

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

        Thread.sleep(2000);

        By firstNamedebitSource = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        driver.findElement(firstNamedebitSource).sendKeys("Poerto");

        By lastNamedebitSource = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        driver.findElement(lastNamedebitSource).sendKeys("Rico");

        driver.findElement(By.xpath("//button[@data-qa-node='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(".//button[contains(text(), 'Сплатити')]")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Назад')]")).click();



        //Вывод текста
//        System.out.println("AMOUNT" + driver.findElement(By.xpath("//span[@data-qa-node='nameB']")).getText());

        //Проверки
        By operator = By.xpath("//span[@data-qa-node='nameB']");
        Assert.assertEquals("Kyivstar Ukraine", driver.findElement(operator).getText());

        Assert.assertEquals("Поповнення мобільного", driver.findElement(By.xpath("//div[@data-qa-node='category']")).getText());
        Assert.assertEquals("Поповнення телефону. На номер +380688905929", driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());
        Assert.assertEquals("4506 **** **** 4797", driver.findElement(By.xpath("//td[@data-qa-node='card']")).getText());
        Assert.assertEquals("100 UAH", driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());
        Assert.assertEquals("2", driver.findElement(By.xpath("//span[@data-qa-node='commission']")).getText());


    }

}
