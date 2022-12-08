package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingOneTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

//        2. задание booking 1:
//        2.1. Перейти на сайт booking.com
//        2.2. Выбрать нужные (любые) даты
//        2.3. Ввести в поиск «Milano», выбрать для проживания 2 гостей и 1 номер.
//        2.4. Проверить, что в Милане есть отели на введенные даты

        driver.get("https://booking.com/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='xp__dates-inner']")).click();
        driver.findElement(By.xpath("//div[@data-bui-ref='calendar-month'][2]//tr[@class='bui-calendar__row'][3]/td[1]")).click();
        driver.findElement(By.xpath("//div[@data-bui-ref='calendar-month'][2]//tr[@class='bui-calendar__row'][3]/td[7]")).click();

        WebElement search = driver.findElement(By.id("ss"));
        search.sendKeys("Milano");



    }
}
