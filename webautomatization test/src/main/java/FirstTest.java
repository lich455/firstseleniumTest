import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {


    @Test
    public void checkUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(By.xpath(".//input[@data-qa-node='phone-number']")).sendKeys("980666798");

        driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).sendKeys("120");

        driver.findElement(By.xpath(".//input[@data-qa-node='numberdebitSource']")).sendKeys("4093206288191961");

        driver.findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']")).sendKeys("0622");

        driver.findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']")).sendKeys("494");

        driver.findElement(By.xpath(".//button[contains(text(), 'В кошик')]")).click();


        //Asserts//

        Thread.sleep(5000);


        By paymentDetails = By.xpath(".//span[@data-qa-node='details']");
        By cardNumber = By.xpath(".//td[contains(text(),'4093 **** **** 1961')]");
        By nameB = By.xpath(".//span[@data-qa-node='nameB']");
        By amount = By.xpath(".//span[@data-qa-node='amount']");
        By commission = By.xpath(".//span[@data-qa-node='commission']");
        By total = By.xpath(".//div[@data-qa-node='total']");


        Assert.assertEquals("Поповнення телефону. На номер +380980666798", driver.findElement(paymentDetails).getText());
        Assert.assertEquals("4093 **** **** 1961",driver.findElement(cardNumber).getText());
        Assert.assertEquals("Kyivstar Ukraine",driver.findElement(nameB).getText());
        Assert.assertEquals("120",driver.findElement(amount).getText());
        Assert.assertEquals("4",driver.findElement(commission).getText());
        Assert.assertEquals("120 UAH",driver.findElement(total).getText());






    }

}