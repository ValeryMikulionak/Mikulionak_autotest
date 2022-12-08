package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.*;

public class Pogoda {

//    DayOfWeek.from(LocalDate.now()).plus(1).getDisplayName(TextStyle.FULL, new Locale("be"));

    public static void main(String[] args) throws InterruptedException {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,1);
        Date day = cal.getTime();
        SimpleDateFormat formatDate = new SimpleDateFormat("EEEE", Locale.forLanguageTag("be"));
        String pat = formatDate.format(day);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("погода минск");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]//span[text()='погода минск']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-wob-di='1']/div/img")).click();
        Thread.sleep(1000);

        String weather = driver.findElement
                (By.xpath("//*[contains(@aria-label, 'Celsius') and contains(@aria-label,'"+pat+" 12')][1]"))
                .getAttribute("aria-label");
        String[] str = weather.split(" ");
        System.out.println(str[0]);
        driver.close();
        driver.quit();
    }
}
