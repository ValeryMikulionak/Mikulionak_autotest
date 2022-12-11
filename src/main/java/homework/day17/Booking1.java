package homework.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking1 {

    public boolean booky() throws InterruptedException {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10);
        Date day = cal.getTime();
        SimpleDateFormat formatDate = new SimpleDateFormat("d MMMM y");
        String pat = formatDate.format(day);

        WebDriver driver = new ChromeDriver();
        driver.get("https://booking.com/");
        String mainTab = driver.getWindowHandle();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@action,'searchresults')]/div/div[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@aria-label='" + pat + "']")).click();
        Thread.sleep(1000);

        cal.add(Calendar.DAY_OF_MONTH, 15);
        Date day2 = cal.getTime();
        String pat2 = formatDate.format(day2);
        driver.findElement(By.xpath("//*[@aria-label='" + pat2 + "']")).click();
        Thread.sleep(1000);

        WebElement el = driver.findElement(By.xpath("//input[@name='ss']"));
        el.click();
        Thread.sleep(1000);
        el.sendKeys("Izmir");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@action,'searchresults')]/div/div[1]//ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@action,'searchresults')]/div/div[4]")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.xpath("//div[@data-component='arp-header']/div/div/div/h1")).isEmpty()) {
            System.out.println("Отелей нет");
        } else {
            driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@data-testid='sorters-dropdown']//ul/li[4]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-testid='property-card'][1]/div/div[1]")).click();
            Thread.sleep(10000);
            driver.navigate().forward();

            for (String tab : driver.getWindowHandles()) {
                driver.switchTo().window(tab);
            }

            String att = driver.findElement
                            (By.xpath("//div[@data-testid='review-score-right-component']/div[1]"))
                    .getAttribute("aria-label");

            driver.switchTo().window(mainTab);
            driver.quit();

            String[] str = att.split(" ");
            System.out.println(str[1]);
            float f = Float.parseFloat(str[1].trim());
            if (f >= 9) {
                System.out.println("Есть отели с рейтингом выше 9");
                return true;
            } else {
                System.out.println("Нет отелей с рейтингом выше 9");
                return false;
            }

        }
        return false;
    }
}
