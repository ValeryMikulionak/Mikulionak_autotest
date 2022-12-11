package homework.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookingCss {

    public static void main(String[] args) throws InterruptedException {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,5);
        Date day = cal.getTime();
        SimpleDateFormat formatDate = new SimpleDateFormat("d MMMM y");
        String pat = formatDate.format(day);

        WebDriver driver = new ChromeDriver();
        driver.get("https://booking.com/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("//*[action^='searchresults')]/div/div[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='"+pat+"']")).click();
        Thread.sleep(1000);

        cal.add(Calendar.DAY_OF_MONTH,10);
        Date day2 = cal.getTime();
        String pat2 = formatDate.format(day2);
        driver.findElement(By.xpath("//*[@aria-label='"+pat2+"']")).click();
        Thread.sleep(1000);

        WebElement el = driver.findElement(By.cssSelector("//input[name='ss']"));
        el.click();
        Thread.sleep(1000);
        el.sendKeys("Milano");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@action,'searchresults')]/div/div[1]//ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@action,'searchresults')]/div/div[4]")).click();
        Thread.sleep(2000);

//        if (driver.findElements(By.xpath("//div[@data-component='arp-header']/div/div/div/h1")).isEmpty()) {
//            return false;
//        } else {
//            System.out.println(driver.findElement
//                            (By.xpath("//div[@data-component='arp-header']/div/div/div/h1"))
//                    .getText());
//            driver.close();
//            driver.quit();
//            return true;
//        }
    }
}